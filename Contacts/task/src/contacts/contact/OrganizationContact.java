package contacts.contact;


public class OrganizationContact extends Contact {

    private String organizationName;
    private String address;

    public OrganizationContact(String number, String organizationName, String address) {
        super();
        this.organizationName = organizationName;
        this.address = address;
        setNumber(number);
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {

        String number = this.number.length() == 0 ? "[no number]" : this.number;

        return String.format("Organization name: %s\n" +
                "Address: %s\n" +
                "Number: %s\n" +
                "Time created: %s\n" +
                "Time last edit: %s\n", organizationName, address, number, timeCreated, timeLastEdit);
    }

    @Override
    public String getFields() {
        return "name, address, number";
    }

    @Override
    public void update(String field, String value) {
        switch (field) {
            case "name":
                setOrganizationName(value);
                break;
            case "address":
                setAddress(value);
                break;
            case "number":
                setNumber(value);
                break;
        }
    }

    @Override
    public String get() {
        return organizationName;
    }
}
