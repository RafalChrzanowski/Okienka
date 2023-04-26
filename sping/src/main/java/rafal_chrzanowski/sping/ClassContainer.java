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
    public void removeClass(String name){
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
}
