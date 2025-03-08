import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;

class SJF {
    static class Process {
        int id;
        int burstTime;
        int waitTime;
        int turnAroundTime;

        public Process(int id, int burstTime) {
            this.id = id;
            this.burstTime = burstTime;
            this.waitTime = 0;
            this.turnAroundTime = 0;
        }
    }

    // Method for wait time
    static void waitTime(Process[] processes) {

        Arrays.sort(processes, Comparator.comparingInt(p -> p.burstTime));

        processes[0].waitTime = 0;

        for (int i = 1; i < processes.length; i++) {
            processes[i].waitTime = processes[i-1].burstTime + processes[i-1].waitTime;
        }
    }

    // Method for turn around
    static void turnAroundTime(Process[] processes) {
        for (int i = 0; i < processes.length; i++) {
            processes[i].turnAroundTime = processes[i].burstTime + processes[i].waitTime;
        }
    }

    // Method for printing results
    static void printResults(Process[] processes) {
        int total_waittime = 0, total_turntime = 0;

        System.out.printf("Process ID | Waiting Time | Turnaround Time\n");

        for (int i = 0; i < processes.length; i++) {
            total_waittime = total_waittime + processes[i].waitTime;
            total_turntime = total_turntime + processes[i].turnAroundTime;
            System.out.print(processes[i].id + "\t\t\t|\t");
            System.out.print(processes[i].waitTime + "\t\t\t|\t");
            System.out.print(processes[i].turnAroundTime + "\n");

        }
    }


    public static void main(String[] args) throws ParseException {
        // TEST DATA
        int[] processIds = {1, 2, 3};
        int[] burstTimes = {10, 5, 8};
        int n = processIds.length;


        Process[] processes = new Process[n];
        for (int i = 0; i < n; i++) {
            processes[i] = new Process(processIds[i], burstTimes[i]);
        }

        waitTime(processes);
        turnAroundTime(processes);
        printResults(processes);
    }
}