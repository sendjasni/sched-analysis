
/**
 * Created by sendjasni on 16/01/19.
 */

public class Main {
    public static void main(String[] args) {

        int hyper_Period;

        TaskSet taskSet = new TaskSet();

        /*
        *   Task creation
        *   */
        Task tau1 = new Task(0, 1, 1, 3);
        Task tau2 = new Task(1, 1, 2, 4);
        Task tau3 = new Task(1, 1, 3, 8);

        TaskSet.addConstrainedTask(tau1);
        TaskSet.addConstrainedTask(tau2);
        TaskSet.addConstrainedTask(tau3);

        System.out.println("******************************************************************");
        System.out.println("                 L'algorithme EDF Constrained                     ");
        System.out.println("******************************************************************");
        
        TaskSet.printTs();

        System.out.println("******************************************************************");

        TaskSet.utilisationBasedTest(taskSet);
        System.out.println(TaskSet.jeffrySecondCondition(taskSet));
    }
}
