package contacts.contact_factory;

import contacts.contact.Contact;
import contacts.contact.PersonContact;

import java.util.Scanner;

public class PersonFactory implements Factory{

    @Override
    public Contact createContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name:");
        String name = scanner.nextLine();

        System.out.println("Enter the surname:");
        String surname = scanner.nextLine();

        PersonContact contact = new PersonContact(name, surname);

        System.out.println("Enter the birth date:");
        contact.setBirthDate(scanner.nextLine());

        System.out.println("Enter the gender (M, F):");
        contact.setGender(scanner.nextLine());

        System.out.println("Enter the number:");
        contact.setNumber(scanner.nextLine());

        return contact;
    }
}
