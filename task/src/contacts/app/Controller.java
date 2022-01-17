package contacts.app;

import contacts.app.menu.*;

public class Controller {

    private Menu menu = MainMenu.getInstance();

    public Controller(ContactsApp phoneBook) {
        initMenus(phoneBook);
    }


    public void run() {

        System.out.println(menu.getActions());

        while (true) {
            menu = menu.action();
            System.out.println(menu.getActions());
        }
    }

    private void initMenus(ContactsApp phoneBook) {
        MainMenu.getInstance().setPhoneBook(phoneBook);
        ListMenu.getInstance().setPhoneBook(phoneBook);
        SearchMenu.getInstance().setPhoneBook(phoneBook);
        RecordMenu.getInstance().setPhoneBook(phoneBook);
    }
}
