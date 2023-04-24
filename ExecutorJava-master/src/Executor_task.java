import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Executor_task {
    private static final int NTHREADS = 20;
    static List<FutureTask<Double>> tasksTab;

    public static void main(String[] args) {
        tasksTab = new ArrayList<FutureTask<Double>>();
        double sum_calka = 0.0;
        double r = Math.PI / NTHREADS;
        ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);

        for (int i = 0; i < NTHREADS; i++)
        {
            Calka_callable clb = new Calka_callable(i*r, (i+1)*r, 0.1 / NTHREADS);
            FutureTask ft =new FutureTask<Double>(clb);
            tasksTab.add(ft);
            executor.execute(ft);
        }
        for (FutureTask<Double> futureTask : tasksTab) {
            try
            {
                sum_calka += futureTask.get();
            }
            catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.println("calka = " + sum_calka);
    }
}
