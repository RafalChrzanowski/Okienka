public class FigureCalcInterface implements  UserInterface{
    @Override
    public void startInterface(){
        System.out.printf("Hello ");
    }
    @Override
    public void scanMenuOptions() {
        System.out.printf("Choose: ");
        System.out.printf("1.Circle ");
        System.out.printf("2.Square: ");
        System.out.printf("3.Triangle ");
        System.out.printf("4.Prism ");
        System.out.printf("5.END \n");
        switch (scanner.nextInt()) {
            case 1:
                CircleScan();
                scanMenuOptions();
            case 2:
                SquareScan();
                scanMenuOptions();
            case 3:
                TriangleScan();
                scanMenuOptions();
            case 4:
                PrismScan();
                scanMenuOptions();

            case 5: {
                return;
            }
            default: {
                System.out.printf("No valid choice given, choose a number between 1 and 5 \n");
            }
        }
    consoleEnter();
    scanMenuOptions();
}
    @Override
    public void endInterface()
    {
    System.out.printf("Bye");
    }

    public void CircleScan()
    {
        System.out.printf("You choose circle, pass a r: \n");
        Circle userCircle = new Circle(scanner.nextInt());
        userCircle.print();
        System.out.printf("\n");
    }
    public void SquareScan()
    {
        System.out.printf("You choose Square,pass the sides: \n");
        Square userSquare = new Square(scanner.nextInt());
        userSquare.print();
        System.out.printf("\n");
    }
    public void TriangleScan()
    {
        System.out.printf("You choose Triangle, pass the sides: \n");
        Triangle userTriangle = new Triangle(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        userTriangle.print();
        System.out.printf("\n");
    }
    public void PrismScan()
    {
        System.out.printf("You have chosen a regular prism, choose a figure in the base:\n");
        System.out.printf("1 - Square\n");
        System.out.printf("2 - Circle\n");
        System.out.printf("3 - Triangle\n");
        Figure userBase = scanBase();
        System.out.printf("Enter the height of the prism:\n");
        Prism userPrism = new Prism(userBase, scanner.nextInt());
        userPrism.print();
        System.out.printf("\n");
    }
    public Figure scanBase()
    {
        Figure userBase = null;
        boolean isSet = false;
        while (!isSet) {
            switch (scanner.nextInt())
            {
                case 1:
                    System.out.printf("You choose Square,pass the sides: \n");
                    userBase = new Square(scanner.nextInt());
                    isSet = true;
                    break;

                case 2:
                    System.out.printf("You choose circle, pass a r: \n");
                    userBase = new Circle(scanner.nextInt());
                    isSet = true;
                    break;
                case 3:
                    System.out.printf("You choose Triangle, pass the sides: \n");
                    userBase = new Triangle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                    isSet = true;
                    break;
                default:
                    System.out.printf("Error,choose a number from 1 to 3");
                    break;
            }
        }
        return userBase;
    }
}
