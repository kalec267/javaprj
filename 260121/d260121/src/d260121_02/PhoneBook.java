package d260121_02;

public class PhoneBook {
    private String name, hp, email;

    public PhoneBook() {
    }

    public PhoneBook(String name, String hp, String email) {
        this.name = name;
        this.hp = hp;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "name='" + name + '\'' +
                ", hp='" + hp + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
