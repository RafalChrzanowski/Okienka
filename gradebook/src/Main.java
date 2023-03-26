
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Student student = new Student("Rafal", "Chrzanowski",StudentCondition.DOING,2000,3.0,"rafalchrzanowski00@gmail.com");
        student.print();
    }
}