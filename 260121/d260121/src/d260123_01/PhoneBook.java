package d260123_01;

public class PhoneBook {
    int id;
    String name;
    String hp;
    String email;

    public PhoneBook() {
    }

    public PhoneBook(int id, String name, String hp, String email) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp='" + hp + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
