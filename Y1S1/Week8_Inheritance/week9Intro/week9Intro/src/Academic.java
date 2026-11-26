public class Academic {
    String name;
    int id;
    String subject;

    Academic(String name, int id, String subject) {
        this.name = name;
        this.id = id;
        this.subject = subject;
    }

    void display() {
        System.out.println(name + " " + id + " " + subject);
    }
}
