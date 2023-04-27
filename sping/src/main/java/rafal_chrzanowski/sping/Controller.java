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
    //http://localhost:8080/api/student?className=1&firstname=Jan&lastname=Kiepa&condition=SICK&birthYear=2000&points=4.5&email=test@test2.pl
    @RequestMapping("/student")
    public String addStudent(
            @RequestParam String className,
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam StudentCondition condition,
            @RequestParam int birthYear,
            @RequestParam double points,
            @RequestParam String email
    )
    {
        if(agh.Exist(className))
        {
            Student student = new Student(firstname, lastname, condition, birthYear, points, email);
            agh.getKlasa(className).addStudent(student);
            return student.toString();
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

/* //ToDo
    @GetMapping("/student/{lastname}/grade")
    public String getStudentGrade(
            @PathVariable String lastname
    ) {
        return agh.getKlasa(className).getStudentPoints(lastname);
    }
*/
    @GetMapping("/course")
    public String getAllClassNames()
    {
        return agh.getAllClassNames().toString();
    }

//http://localhost:8080/api/course/add?className=test&max=8
    @RequestMapping("/course/add")
    public String addClassOfStudents(@RequestParam String className, @RequestParam int max) {
        return agh.addEmptyClass(className, max);
    }

    @RequestMapping("/course/{className}")
    public String deleteClassOfStudents(@PathVariable String className) //ToDo
    {
        return agh.removeClass(className);
    }


    //http://localhost:8080/api/course/1/students
    @GetMapping("/course/{className}/students")
    public String summaryClassOfStudents(@PathVariable String className)
    {
        return agh.getKlasa(className).summary();
    }

    //http://localhost:8080/api/course/1/fill
    @GetMapping("/course/{className}/fill")
    public String getClassOfStudentsPercentages(@PathVariable String className)
    {
        return agh.getKlasa(className).getPercentages();
    }
    //POST-/api/rating-dodaje ocenę dla przedmiotu/grupy //ToDo
    /*
    private void getCSV(HttpServletResponse response, List<Student> listStudents) throws IOException {
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Firstname", "Lastname", "Condition", "BirthYear", "Points", "Address"};
        String[] nameMapping = {"firstName", "lastName", "studentCondition", "birthYear", "numberOfPoint", "studentAddress"};
        csvWriter.writeHeader(csvHeader);

        for (Student student : listStudents) {
            csvWriter.write(student, nameMapping);
        }
        csvWriter.close();
    }
     */


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
