public class runnable2 implements Runnable
{
    Obraz obraz;
    int row;
    public runnable2(int row, Obraz obraz)
    {
        this.obraz = obraz;
        this.row = row;
    }
    @Override
    public void run()
    {
        obraz.calculate_print_histogram_for_one_row(row);
    }
}