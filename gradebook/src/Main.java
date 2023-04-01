import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        //add
        System.out.println("Hello world!\n");
        Student student = new Student("Rafal", "Chrzanowski1",StudentCondition.DOING,2000,3.0,"rafalchrzanowski00@gmail.com");
        student.print();
        //compare
        System.out.printf("compare\n");
        Student student2 = new Student("Tomasz", "Chrzanowski",StudentCondition.SICK,2001,4.0,"rafalchrzanowski@gmail.com");
        Student student3 = new Student("Piotr", "Maka",StudentCondition.ABSENT,2004,2.0,"Maka@gmail.com");
        if(student2.compareTo(student3)) System.out.printf("Studenci mają takie samo nazwisko\n");
        else System.out.printf("Studenci nie mają takiego samego nazwiska\n");

        //add to class
        System.out.printf("add to class\n");
        List studentsList = new ArrayList<Student>();
        studentsList.add(student);
        studentsList.add(student2);
        studentsList.add(student3);
        Class firstClass = new Class("nazwa",4);
        firstClass.addStudent(student);
        firstClass.addStudent(student2);
        firstClass.addStudent(student3);

        //points
        System.out.printf("add points\n");
        firstClass.addPoints(student, 1.6);

        //remove points
        System.out.printf("remove points\n");
        firstClass.removePoints(student,1.0);

        //status
        System.out.printf("status\n");
        firstClass.changeCondition(student, StudentCondition.SICK);
        //search
        System.out.printf("search\n");
        Student search = firstClass.search("Maka");
        //searchPartial
        System.out.printf("searchPartial\n");
        List<Student>searchPartial = firstClass.searchPartial("Mak");
        //countByCondition
        System.out.printf("countByCondition:SICK \n");
        System.out.println("Ilość studentów z: %s w klasie %s to: %d\n".formatted(StudentCondition.SICK.toString(), firstClass.getGroupName(), firstClass.countByCondition(StudentCondition.SICK)));
        //summary
        System.out.printf("summary\n");
        firstClass.summary();
        //sortByName
        System.out.printf("sortByName\n");
        firstClass.sortByName();
        firstClass.summary();
        //sortByPoint
        System.out.printf("sortByPoint\n");
        firstClass.sortByPoints();
        firstClass.summary();
        //max
        System.out.printf("max\n");
        firstClass.max();
        //add container
        System.out.printf("add container\n");
        ClassContainer firstContainer = new ClassContainer();
        firstContainer.addClass("nazwa", 20);
        //remove container
        System.out.printf("remove container\n");
        firstContainer.removeClass("nazwa");
        //find empty
        System.out.printf("find empty\n");
        ClassContainer secondContainer = new ClassContainer();
        secondContainer.addClass("nazwa2", 2);
        List emptyGroups = secondContainer.findEmpty();

        firstContainer.summary();
    }
}