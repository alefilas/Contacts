package contacts.app.menu;


public class ListMenu extends Menu {

    private static ListMenu menu;

    public static ListMenu getInstance() {
        if (menu == null) {
            menu = new ListMenu();
        }
        return menu;
    }

    private ListMenu() {
        super("[list] Enter action ([number], back):");
    }

    @Override
    public Menu action() {

        int record;
        try {
            record = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println();
            return MainMenu.getInstance();
        }

        System.out.println(phoneBook.getInfo(String.valueOf(record)));

        RecordMenu.getInstance().setRecord(record);

        return RecordMenu.getInstance();
    }
}