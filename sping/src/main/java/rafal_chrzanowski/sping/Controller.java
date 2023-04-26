package rafal_chrzanowski.sping;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class Controller {
    ClassContainer agh = new Generator().container;
    @GetMapping("/message")
    public String getMessage() {return "WYŚWIETLA";}
    //http://localhost:8080/api/student?className=1&firstname=Jan&lastname=Kiepa&condition=SICK&birthYear=2000&points=4.5&address=Kalwarysjka5
    @RequestMapping("/student")
    public String addStudent(
            @RequestParam String className,
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam StudentCondition condition,
            @RequestParam int birthYear,
            @RequestParam double points,
            @RequestParam String address
    )
    {
        if(agh.Exist(className))
        {
            return agh.getKlasa(className).addStudent(
                    new Student(firstname, lastname, condition, birthYear, points, address)
            );
        }
        else return "This class of student not exist";
    }
    @RequestMapping("/student/{className}/{lastname}")
    public String deleteStudent(
            @PathVariable String className,
            @PathVariable String lastname
    )
    {
        if(agh.Exist(className))
        {
            return agh.getKlasa(className).removeStudent(lastname);
        }
        else return "This class of student not exist";
    }

    @GetMapping("/course")
    public String getAllClassNames()
    {
        return agh.getAllClassNames().toString();
    }
    @GetMapping("/course/{classname}")
    public String getAllClassNames(@PathVariable String classname)
    {
        return agh.getKlasa(classname).summary();
    }
    @GetMapping("/allStudents")
    public StringBuilder getAllStudents()
    {
        return agh.getAllStudents();
    }
}
