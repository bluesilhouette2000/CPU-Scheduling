import java.util.Scanner;
public class FCFS
{
    int numberOfProcesses;
    Scanner sc = new Scanner(System.in);
    public void printAll(){
        System.out.print("How many processes? ");
        numberOfProcesses = sc.nextInt();
        int[] burstTime = new int[numberOfProcesses];
        int input,waitingTime=0;
        double averageWaitingTime = 0;
        //PUTING THE BURST TIME OF THE PROCESSES ON THE ARRAY
        for(int x = 0; x < numberOfProcesses; x++){
            System.out.println("Enter the burst time of process " + (x+1));
            input = sc.nextInt();
            burstTime[x] = input;
        }
        //ADDING THE TOTAL WAITING TIME OF ALL PROCESSES
        for(int x = 0; x < numberOfProcesses - 1; x++){
            waitingTime = waitingTime + burstTime[x];
            averageWaitingTime += waitingTime;
        }
        
        averageWaitingTime = averageWaitingTime / numberOfProcesses;
        System.out.println("PROCESS \tBURST TIME");
        for(int x = 0; x < numberOfProcesses; x++){
            System.out.println((x+1)+ "\t\t" + burstTime[x]);
        }
        System.out.println("Average Waiting Time " + averageWaitingTime + "\n");
    }
}
