package contacts.contact_factory;

import contacts.contact.Contact;
import contacts.contact.OrganizationContact;

import java.util.Scanner;

public class OrganizationFactory implements Factory{
    @Override
    public Contact createContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the organization name:");
        String name = scanner.nextLine();

        System.out.println("Enter the address:");
        String address = scanner.nextLine();

        System.out.println("Enter the number:");
        String number = scanner.nextLine();

        return new OrganizationContact(number, name, address);
    }
}
