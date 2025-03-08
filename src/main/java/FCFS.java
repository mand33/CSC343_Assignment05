/**
 * Implemenation FCFS
 * @author Amandaharnos
 */

import java.text.ParseException;

class FCFS {

    // Method for wait time
    static void waitTime(int processID[], int n, int bursttime[], int waittime[]) {
        waittime[0] = 0;


        for (int i = 1; i < n; i++) {
            waittime[i] = bursttime[i - 1] + waittime[i - 1];
        }
    }

    // Method for turn around
    static void turnAroundTime(int processID[], int n, int bursttime[], int waittime[], int turntime[]) {
        for (int i = 0; i < n; i++) {
            turntime[i] = bursttime[i] + waittime[i];
        }
    }

    //Method for avg time
    static void printResults(int processID[], int n, int bursttime[]) {
        int waittime[] = new int[n], turntime[] = new int[n];
        int total_waittime = 0, total_turntime = 0;


        waitTime(processID,n, bursttime, waittime);
        turnAroundTime(processID,n, bursttime, waittime, turntime);



        System.out.printf("Process ID | Waiting Time | Turnaround Time\n");

        for (int i = 0; i < n; i++) {
            total_waittime= total_waittime + waittime[i];
            total_turntime = total_turntime + turntime[i];
            System.out.print((i + 1) + "\t\t\t|\t");
            System.out.print(waittime[i] + "\t\t\t|\t");
            System.out.print(turntime[i] + "\n");

        }
    }

    public static void main(String[] args) throws ParseException {
        //TEST CODE
        int processes[] = {1, 2, 3};
        int n = processes.length;

        int burst_time[] = {10, 5, 8};

        printResults(processes, n, burst_time);

    }
}

