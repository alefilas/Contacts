package contacts.app;

import contacts.contact.*;
import contacts.contact_factory.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactsApp {

    private List<Contact> contacts;
    private final String fileName;

    public ContactsApp(String fileName) {
        this.fileName = fileName;
       try {
            readFromFile(fileName);
        } catch (IOException | ClassNotFoundException e) {
            contacts = new ArrayList<>();
            saveToFile();
        }
        contacts = new ArrayList<>();
        saveToFile();
    }

    private void saveToFile() {

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(contacts);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readFromFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);

        ArrayList<?> list = (ArrayList<?>) ois.readObject();
        contacts = new ArrayList<>();
        for (Object ob : list) {
            contacts.add((Contact) ob);
        }
        ois.close();
    }

    public String add(String type) {

        Factory factory;
        switch (type) {
            case "person":
                factory = new PersonFactory();
                break;
            case "organization":
                factory = new OrganizationFactory();
                break;
            default:
                return "Unknown operation!\n";
        }

        contacts.add(factory.createContact());
        saveToFile();

        return "The record added.\n";
    }

    public String remove(int record) {

        if (record < contacts.size() && record >= 0) {
            contacts.remove(record);
            saveToFile();
            return "The record removed!\n";
        } else {
            return  "Wrong number!\n";
        }
    }

    public String list () {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < contacts.size(); i++) {
            builder.append(i + 1)
                    .append(". ")
                    .append(contacts.get(i).get())
                    .append("\n");
        }
        return builder.toString();
    }

    public int count() {
        return contacts.size();
    }

    public boolean isEmpty() {
        return contacts.isEmpty();
    }

    public String getInfo(String record) {
        return contacts.get(Integer.parseInt(record) - 1).toString();
    }

    public String getContact(int index) {
        return contacts.get(index).getFields();
    }

    public String update(int record, String type, String value) {
        if (record > contacts.size() || record < 0) {
            return "Wrong number!";
        }
        contacts.get(record).update(type, value);
        contacts.get(record).updateTimeEdit();
        saveToFile();
        return "The record updated!\n";
    }

    public String find(String query) {

        List<Contact> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);

        for (Contact con : contacts) {

            Matcher matcher = pattern.matcher(con.get());
            if (matcher.find()) {
                list.add(con);
            }
        }

        StringBuilder builder = new StringBuilder("Found " + list.size() + " results:\n");
        for (int i = 0; i < list.size(); i++) {
            builder.append(i + 1)
                    .append(". ")
                    .append(list.get(i).get())
                    .append("\n");
        }
        return builder.toString();
    }
}
