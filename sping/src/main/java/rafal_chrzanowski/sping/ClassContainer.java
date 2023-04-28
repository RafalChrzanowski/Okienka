package rafal_chrzanowski.sping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ClassContainer {
    private Map<String, Klasa> groups;
    public ClassContainer() {
        this.groups = new HashMap<>();
    }
    public void addClass(String name, int capacity){
        groups.put(name, new Klasa(name, capacity));
    }
    public void removeClass2(String name){
        groups.remove(name);
    }
    public List<String> findEmpty(){
        List<String> emptyGroups = new ArrayList<>();
        String xyz ="";
        for (Klasa group : groups.values()){
            if(group.getPercentageFull() == 0){
                emptyGroups.add(group.getGroupName());
                xyz=group.getGroupName();
            }
        }
        System.out.println(xyz);
        return emptyGroups;
    }
    public void summary(){
        for (Klasa group : groups.values()){
            System.out.printf("Group %s is %.2f%% full\n", group.getGroupName(), group.getPercentageFull());
        }
    }
    public boolean Exist(String klasa){
        return groups.containsKey(klasa);
    }
    public Klasa getKlasa(String klasa){
        return groups.get(klasa);
    }
    StringBuilder getAllClassNames()
    {
        StringBuilder classNames= new StringBuilder();
        groups.forEach((key, value) ->
        {
            classNames.append(key + "\n");
        });
        return classNames;
    }
    StringBuilder getAllStudents()
    {
        StringBuilder message = new StringBuilder();
        groups.forEach((key, value) ->
        {

                //message.append(value.students[0]);

        });
        return message;
    }
    String addEmptyClass(String className, int maxNumberOfStudent) {
        String message;
        if (groups.containsKey(className)) {
            System.out.println("Taka klasa jest już w kontenerze");
            message = "This class is already in container";
        } else {
            Klasa newClassOfStudents = new Klasa(className, maxNumberOfStudent);
            groups.put(className, newClassOfStudents);
            System.out.printf("Dodano klasę %s do kontenera%n", className);
            message = "Class added successfully";
        }
        return message;
    }
    String removeClass(String className) { //Todo
        String message;
        if (groups.containsKey(className)) {
            groups.remove(className);
            System.out.println("Usunięto klasę z konetenra");
            message = "Class removed sucessfully";
        } else {
            System.out.println("Taka klasa nie jest w kontenerze");
            message = "This class not exist in container";
        }
        return message;
    }
    public List<Student> getStudents(String klasa) {
        if (Exist(klasa)) {
            return getKlasa(klasa).getStudents();
        } else {
            return null;
        }
    }
    public String getStudentPoints(String lastname) {
        for (Student student : getStudents(getAllClassNames().toString())) {
            if (student.getLastname().equals(lastname)) {
                return Double.toString(student.getPoints());
            }
        }
        return "Get grade failed. Student with this lastname doesn't exist";
    }

}
