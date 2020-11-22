package contacts;

import contacts.app.ContactsApp;
import contacts.app.Controller;


public class Main {
    public static void main(String[] args) {

        ContactsApp app;
        if (args.length > 0) {
            app = new ContactsApp(args[0]);
        } else {
            app = new ContactsApp("testing.txt");
        }

        Controller controller = new Controller(app);
        controller.run();

    }
}

