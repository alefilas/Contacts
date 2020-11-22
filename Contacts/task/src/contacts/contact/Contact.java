package contacts.contact;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Contact implements Serializable {

    protected String number = "";
    protected final LocalDateTime timeCreated;
    protected LocalDateTime timeLastEdit;

    public Contact() {
        timeCreated = LocalDateTime.now().withSecond(0).withNano(0);
        timeLastEdit = timeCreated;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (checkNumber(number)){
            this.number = number;
        } else {
            this.number = "";
            System.out.println("Wrong number format!");
        }
    }

    private boolean checkNumber(String number) {
        Pattern pattern = Pattern.compile("^\\+?(([\\d\\w]+)?[- ]?\\(?[\\d\\w]{2,}\\)?)?[ -]?([ -]?[\\d\\w]{2,}[ -]?)*|[\\d\\w]+");
        Matcher matcher = pattern.matcher(number);

        return matcher.matches();
    }

    public void updateTimeEdit() {
        timeLastEdit = LocalDateTime.now().withSecond(0).withNano(0);
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public LocalDateTime getTimeLastEdit() {
        return timeLastEdit;
    }

    public abstract String getFields();

    public abstract void update(String field, String value);

    public abstract String get();
}
