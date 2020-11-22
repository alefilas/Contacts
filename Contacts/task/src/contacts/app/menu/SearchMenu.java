package contacts.app.menu;

public class SearchMenu extends Menu {

    private static SearchMenu menu;

    public static SearchMenu getInstance() {
        if (menu == null) {
            menu = new SearchMenu();
        }
        return menu;
    }

    private SearchMenu() {
        super("[search] Enter action ([number], back, again):");
    }

    @Override
    public Menu action() {

        String input = scanner.nextLine();

        try {
            int record = Integer.parseInt(input);
            System.out.println(phoneBook.getInfo(String.valueOf(record)));
            RecordMenu.getInstance().setRecord(record);
            return RecordMenu.getInstance();
        } catch (Exception ignored) {
        }

        switch (input) {
            case "back":
                return MainMenu.getInstance();
            case "again":
                find();
                return SearchMenu.getInstance();
        }
        return SearchMenu.getInstance();
    }

    public void find() {
        System.out.println("Enter search query:");
        String query = scanner.nextLine();
        System.out.println(phoneBook.find(query));
    }
}
