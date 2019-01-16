
/**
 * Created by sendjasni on 16/01/19.
 */

public class Task {

    private int Id, C, D, T;

    public Task(int Id, int C, int D, int T) {
        this.Id = Id;
        this.C = C;
        this.D = D;
        this.T = T;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        this.C = c;
    }

    public int getD() {
        return D;
    }

    public void setD(int d) {
        this.D = d;
    }

    public int getT() {
        return T;
    }

    public void setT(int t) {
        this.T = t;
    }

    @Override
    public String toString() {
        return "Task{" +
                "tau = P " + Id +
                ", Execution time = " + C +
                ", DeadLine = " + D +
                ", Period = " + T +
                '}';
    }


    public double computeDensity() {
        return C / (double) D;
    }

}

