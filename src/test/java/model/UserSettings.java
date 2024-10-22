package model;

public class UserSettings {

    protected String name;
    protected String patronymic;
    protected String lastname;
    protected String phone;
    protected String position;

    public UserSettings(String name, String patronymic, String lastname, String phone, String position) {
        this.name = name;
        this.patronymic = patronymic;
        this.lastname = lastname;
        this.phone = phone;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }
}
