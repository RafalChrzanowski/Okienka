public class Square extends Figure implements Printable{
    double a;

    public Square(double a)
    {
        this.a=a;
    }
    @Override
    public String toString()
    {
        return "square by side: %.2f".formatted(a);
    }
    @Override
    double calculateArea()
    {
        return a*a;
    }
    double calculatePerimeter()
    {
        return 4*a;
    }
    @Override
    public  void print()
    {
        System.out.println(this);
        System.out.printf("Area: %.2f%n", this.calculateArea());
        System.out.printf("Perimeter: %.2f%n", this.calculatePerimeter());
    }
}
