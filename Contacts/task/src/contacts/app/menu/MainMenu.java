package contacts.app.menu;

public class MainMenu extends Menu {

    private static MainMenu menu;

    private MainMenu() {
        super("[menu] Enter action (add, list, search, count, exit):");
    }

    public static MainMenu getInstance() {
        if (menu == null) {
            menu = new MainMenu();
        }
        return menu;
    }

    @Override
    public Menu action() {

        switch (scanner.nextLine()) {
            case "add":
                add();
                break;
            case "list":
                System.out.println(phoneBook.list());
                return ListMenu.getInstance();
            case "search":
                SearchMenu.getInstance().find();
                return SearchMenu.getInstance();
            case "count":
                count();
                break;
            case "exit":
                System.exit(0);
                break;
        }

        return this;
    }

    private void count() {
        System.out.println("The Phone Book has " + phoneBook.count() + " records.\n");
    }

    private void add() {
        System.out.println("Enter the type (person, organization):");
        System.out.println(phoneBook.add(scanner.nextLine()));
    }
}