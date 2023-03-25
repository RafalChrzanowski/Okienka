public class Prism extends Figure implements Printable{
    double H;
    Figure base;

    public Prism(Figure base, double H)
    {
        this.H=H;
        this.base = base;
    }
    @Override
    public String toString()
    {
        return "A regular prism Height %.2f ,Base %s".formatted(H, this.base.toString());
    }
    @Override
    double calculateArea()
    {
        return this.base.calculateArea() * H;
    }
    double calculatePerimeter()
    {
        return 2 * this.base.calculateArea() + this.base.calculatePerimeter() * H;
    }
    @Override
    public  void print()
    {
        System.out.println(this);
        System.out.printf("Area: %.2f%n", this.calculateArea());
        System.out.printf("Perimeter: %.2f%n", this.calculatePerimeter());
    }
}
