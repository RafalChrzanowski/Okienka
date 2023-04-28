package rafal_chrzanowski.sping;

import java.util.ArrayList;

public class Generator
{
    public static final String[] firstNames = {"Adam", "Paweł", "Patryk", "Kamil", "Joasia", "Anna"};
    public static final String[] lastName = {"Biegała", "Kowalski", "Wiśniewski", "Chory", "Zguba", "Badziewna"};
    public static final String[] email = {"kochamDziekana@agh.pl", "test@test.pl"};
    ClassContainer container = new ClassContainer();
    public Generator()
    {
        int numberOfClass = getRandomInteger(10, 3);
        for (int i = 1; i <= numberOfClass; i++)
        {
            Klasa generatedClass = generateClass(i);
            container.addClass(generatedClass.getGroupName(), 8);
        }
    }
    Klasa generateClass(Integer i)
    {
        int max = getRandomInteger(10, 3);
        int classLetter = getRandomInteger(10, 1);
        Klasa classOfStudent = new Klasa(i.toString() , 8);
        int numberOfStudents = max/2;
        for (int j = 0; j <= 7; j++)
        {
            Student generatedStudent = generateStudent(j);
            classOfStudent.addStudent(generatedStudent);
            //System.out.println(generatedStudent.print());
        }
        return classOfStudent;
    }
    Student generateStudent(int j)
    {
        int firstname = getRandomInteger(5, 1);
        int lastname = getRandomInteger(5, 1);
        int address = getRandomInteger(1, 0);
        return new Student(firstNames[firstname], lastName[lastname], StudentCondition.SICK, 2000, 5.0, email[address]);
    }
    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

}