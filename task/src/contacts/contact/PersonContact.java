package contacts.contact;

import java.time.LocalDate;

public class PersonContact extends Contact {
    private String name;
    private String surname;
    private String gender;
    private LocalDate birthDate;

    public PersonContact(String name, String surname) {
        super();
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setGender(String gender) {
        if (gender.equals("M") || gender.equals("F")) {
            this.gender = gender;
        } else {
            this.gender = "[no data]";
            System.out.println("Bad gender!");
        }
    }

    public void setBirthDate(String birthDate) {
        try {
            this.birthDate = LocalDate.parse(birthDate);
        } catch (Exception e) {
            System.out.println("Bad birth date!");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {

        String number = this.number.length() == 0 ? "[no number]" : this.number;
        String birthDate = this.birthDate == null ? "[no data]" : this.birthDate.toString();


        return String.format("Name: %s\n" +
                "Surname: %s\n" +
                "Birth date: %s\n" +
                "Gender: %s\n" +
                "Number: %s\n" +
                "Time created: %s\n" +
                "Time last edit: %s\n", name, surname, birthDate, gender, number, timeCreated, timeLastEdit);
    }

    @Override
    public String getFields() {
        return "name, surname, birth, gender, number";
    }

    @Override
    public void update(String field, String value) {
        switch (field) {
            case "name":
                setName(value);
                break;
            case "surname":
                setSurname(value);
                break;
            case "birth":
                setBirthDate(value);
                break;
            case "gender":
                setGender(value);
                break;
            case "number":
                setNumber(value);
                break;
        }
    }

    @Override
    public String get() {
        return name + " " + surname;
    }
}
