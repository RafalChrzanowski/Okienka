public class Triangle extends Figure implements Printable{
    double a,b,c;

    public Triangle(double a,double b,double c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    @Override
    public String toString()
    {
        return "Triangle by side: %.2f , %.2f, %.2f".formatted(a,b,c);
    }
    @Override
    double calculateArea()
    {
        double x = (a+b+c)/2;
        return Math.sqrt(x * (x-a)*(x-b)*(x-c));
    }
    double calculatePerimeter()
    {
        return a+b+c;
    }
    @Override
    public  void print()
    {
        System.out.println(this);
        System.out.printf("Area: %.2f%n", this.calculateArea());
        System.out.printf("Perimeter: %.2f%n", this.calculatePerimeter());
    }
}
