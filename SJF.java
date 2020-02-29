import java.util.Scanner;
import java.util.Arrays;
public class SJF
{
    int numberOfProcesses;
    Scanner sc = new Scanner(System.in);
    int[] burstTime;
    int[] sortedBurstTime;
    public void printAll(){
        System.out.print("How many processes? ");
        numberOfProcesses = sc.nextInt();
        burstTime = new int[numberOfProcesses];
        sortedBurstTime = new int[numberOfProcesses];
        int input,waitingTime=0;
        double averageWaitingTime = 0;
        //loop for adding processes in the array
        for(int x = 0; x < numberOfProcesses; x++){
            System.out.println("Enter the burst time of process " + (x+1));
            input = sc.nextInt();
            burstTime[x] = input;
        }
        
        sortBurst();
                
        for(int x = 0; x < numberOfProcesses - 1; x++){
            waitingTime = waitingTime + sortedBurstTime[x];
            averageWaitingTime += waitingTime;
        }
        
        averageWaitingTime = averageWaitingTime / numberOfProcesses;
        System.out.println("PROCESS \tBURST TIME");
        for(int x = 0; x < numberOfProcesses; x++){
            System.out.println((x+1)+ "\t\t" + burstTime[x]);
        }
        System.out.println("Average Waiting Time " + averageWaitingTime + "\n");
    }
    
    //SORTING THE BURST TIME BASED ON THE SHORTEST BURST TIME OR JOB
    public void sortBurst(){
        //MAKING A DUPLICATE OF THE ARRAY, ONE FOR THE SORTED, ONE FOR DISPLAYING
        for(int x = 0; x<numberOfProcesses; x++){
            sortedBurstTime[x] = burstTime[x];
        }
        Arrays.sort(sortedBurstTime);
    }
}
