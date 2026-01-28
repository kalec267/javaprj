package d260122_01_rebuild;

public class PhoneBook {
    private String name, hp, email;
    private int id;

    public PhoneBook(String name, String hp, String email, int id) {
        this.name = name;
        this.hp = hp;
        this.email = email;
        this.id = id;
    }

    public PhoneBook(String name, String hp, String email) {
        this.name = name;
        this.hp = hp;
        this.email = email;
    }

    public PhoneBook(int id, String name, String hp, String email) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                ", id=" + id +
                "name='" + name + '\'' +
                ", hp='" + hp + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
