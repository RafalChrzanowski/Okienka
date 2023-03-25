public class Circle extends Figure implements Printable{
    double r;

    public Circle(double r) {this.r = r;}

    @Override
    public String toString()
    {
        return "Circle o r: %.2f".formatted(r);
    }
    @Override
    double calculateArea()
    {
        return Math.pow(r,2) * Math.PI;
    }
    @Override
    double calculatePerimeter()
    {
        return 2 * r * Math.PI;
    }
    @Override
    public void print()
    {
        System.out.println(this);
        System.out.printf("Area: %.2f%n", this.calculateArea());
        System.out.printf("Perimeter %.2f%n", this.calculatePerimeter());
    }
}
