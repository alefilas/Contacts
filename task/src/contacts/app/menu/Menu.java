package contacts.app.menu;

import contacts.app.ContactsApp;

import java.util.Scanner;

public abstract class Menu {

    protected String actions;
    protected ContactsApp phoneBook;
    protected Scanner scanner = new Scanner(System.in);

    public Menu(String actions) {
        this.actions = actions;
    }

    public String getActions() {
        return actions;
    }

    public void setPhoneBook(ContactsApp phoneBook) {
        this.phoneBook = phoneBook;
    }

    public abstract Menu action();

}
