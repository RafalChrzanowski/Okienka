import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ClassContainer {
    private Map<String, Class> groups;
    public ClassContainer() {
        this.groups = new HashMap<>();
    }
    public void addClass(String name, int capacity){
        groups.put(name, new Class(name, capacity));
    }
    public void removeClass(String name){
        groups.remove(name);
    }
    public List<String> findEmpty(){
        List<String> emptyGroups = new ArrayList<>();
        String xyz ="";
        for (Class group : groups.values()){
            if(group.getPercentageFull() == 0){
                emptyGroups.add(group.getGroupName());
                xyz=group.getGroupName();
            }
        }
        System.out.println(xyz);
        return emptyGroups;
    }
    public void summary(){
        for (Class group : groups.values()){
            System.out.printf("Group %s is %.2f%% full\n", group.getGroupName(), group.getPercentageFull());
        }
    }

}
