public class runnable  implements Runnable{
    Obraz obraz;
    int searchedChar;
    public runnable(int searchedChar,Obraz obraz){
        this.searchedChar = searchedChar;
        this.obraz = obraz;
    }
    public void run(){
        for(int i =0; i<searchedChar; i++){
            obraz.calculate_histogram_for_char(i);
            obraz.print_histogram_for_char(i);
        }
    }
}
