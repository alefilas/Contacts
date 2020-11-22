package contacts.app.menu;


public class RecordMenu extends Menu {


    private static RecordMenu menu;
    private int index;

    public static RecordMenu getInstance() {
        if (menu == null) {
            menu = new RecordMenu();
        }
        return menu;
    }

    private RecordMenu() {
        super("[record] Enter action (edit, delete, menu):");
    }

    @Override
    public Menu action() {

        switch (scanner.nextLine()) {
            case "edit":
                edit();
                break;
            case "delete":
                delete();
                break;
            case "menu":
                System.out.println();
                return MainMenu.getInstance();
        }

        return RecordMenu.getInstance();
    }

    private void delete() {
        if (phoneBook.isEmpty()) {
            System.out.println("No records to remove!");
            return;
        }

        System.out.println(phoneBook.remove(index));
    }

    private void edit() {

        if (phoneBook.isEmpty()) {
            System.out.println("No records to edit!");
            return;
        }

        System.out.println("Select a field (" + phoneBook.getContact(index) + "):");
        String field = scanner.nextLine();

        System.out.println("Enter " + field + ":");
        String value = scanner.nextLine();

        System.out.println(phoneBook.update(index, field, value));
    }

    void setRecord(int record) {
        index = record - 1;
    }
}
