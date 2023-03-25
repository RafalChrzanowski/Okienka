import java.util.Scanner;
public interface UserInterface {
    Scanner scanner = new Scanner(System.in);
    void startInterface();
    void scanMenuOptions();
    void endInterface();
    default void consoleEnter(){
        System.out.printf("Enter, to go next ...");
        scanner.nextLine();
        scanner.nextLine();
        System.out.printf("\n");
    };
}
