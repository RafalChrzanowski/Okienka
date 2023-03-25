public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        FigureCalcInterface fcInterface = new FigureCalcInterface();

        fcInterface.startInterface();
        fcInterface.scanMenuOptions();
        fcInterface.endInterface();
    }
}