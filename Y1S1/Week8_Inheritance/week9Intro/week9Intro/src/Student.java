public class Student {
    String name;
    int id;
    String department, degree;

  Student(String name, int id, String department, String degree) {
      this.name = name;
      this.id = id;
      this.department = department;
      this.degree = degree;
  }
    void display() {
        System.out.println("Name : " + name);
        System.out.println("id:"+id);
         System.out.println("Department : " + department);
        System.out.println("Degree : " + degree);
    }
}
