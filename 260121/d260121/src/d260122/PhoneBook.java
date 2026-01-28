package d260122;

public class PhoneBook {

    private String name, hp, email;
    private int id;

    //    필드 생성자를 사용하려면 기본 생성자를 만들어야함
    public PhoneBook() {
    }

    public PhoneBook(int id, String name, String hp, String email) {
        this.id=id;
        this.name = name;
        this.hp = hp;
        this.email = email;
    }

    public PhoneBook(String name, String hp, String email) {
        this.name = name;
        this.hp = hp;
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
}
