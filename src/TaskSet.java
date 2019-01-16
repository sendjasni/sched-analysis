import java.util.ArrayList;

/**
 * Created by sendjasni on 16/01/19.
 */

public class TaskSet {

    static ArrayList<Task> ts_Constrained;
    static ArrayList<Task> ts_Implicit;

    public TaskSet() {
        ts_Constrained = new ArrayList<Task>();
        ts_Implicit = new ArrayList<Task>();

    }

    public ArrayList<Task> getConstrainedTaskSet() {
        return ts_Constrained;
    }

    public ArrayList<Task> getImplicitTaskSet() {
        return ts_Implicit;
    }

    public static void addConstrainedTask(Task tau) {
        ts_Constrained.add(tau);
    }

    public static void addImplicitTask(Task tau) {
        ts_Implicit.add(tau);
    }

    public static void printTs() {
        for (Task tau : ts_Constrained)
            System.out.println(tau);

        for (Task tau1 : ts_Implicit)
            System.out.println(tau1);
    }

    /*
     *  Sort task set by deadlines
     * */
    public static void SortByDeadLines(ArrayList<Task> ts) {
        Task tmp;
        int k = 0;
        while (k <= ts.size() - 1) {
            for (int i = k + 1; i < ts.size(); i++) {
                if (ts.get(i).getD() > ts.get(k).getD()) {
                    tmp = ts.get(k);
                    ts.set(k, ts.get(i));
                    ts.set(i, tmp);
                }
            }
            k++;
        }
    }

    /*
     *  Sort task set by period
     * */

    public static void SortByPeriods(ArrayList<Task> ts) {
        Task tmp;
        int k = 0;
        while (k <= ts.size() - 1) {
            for (int i = k + 1; i < ts.size(); i++) {
                if (ts.get(i).getT() > ts.get(k).getT()) {
                    tmp = ts.get(k);
                    ts.set(k, ts.get(i));
                    ts.set(i, tmp);

                }
            }
            k++;
        }
    }


    /*
     * Compute the task utilization for task i
     * */

    private static double computeUtil(Task tau) {
        return tau.getC() / (double) tau.getT();
    }

    public static void utilisationBasedTest(TaskSet ts) {
        int i;
        double tauxUtil = 0;

        ArrayList<Task> task = ts.getConstrainedTaskSet();
        for (i = 0; i < task.size(); i++) {
            tauxUtil += computeUtil(task.get(i));  /* Task set total utilization */
        }
        if (tauxUtil <= 1)
            System.out.println(" The task set is schedulable ");
        else 
            System.out.println(" The task set is not schedulable! ");
    }

    public static String jeffrySecondCondition(TaskSet ts) {
        int i, L, j;
        double tmpSum = 0;

        ArrayList<Task> task = ts.getConstrainedTaskSet();
        for(i = 2; i < task.size(); i++) {
            for(L = task.get(0).getT() + 1; L < task.get(i).getT(); L++) {
                for(j = 1; j < i; j++) {
                    
                    tmpSum += Math.floor(L -1 / (double) task.get(j).getT()) * task.get(j).getC();

                }
                if( L <= tmpSum + task.get(i).getC()){
                    return " The Jeffry's second condition is not verified for this task set!";
                }
            }
        }

        return " The Jeffry's second condition is verified for this task set!";
    }
}
