public class Person {
        String name;
        int id;

        Person(String name, int id) {
            this.name = name;
            this.id = id;
        }
        void display() {
            System.out.println("Name: " + name);
            System.out.println("id: " + id);
        }

}

