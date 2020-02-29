import java.util.Scanner;
import java.util.Arrays;
public class RRS
{
    int numberOfProcesses;
    Scanner sc = new Scanner(System.in);
    int[] burstTime, originalBurstTime;
    int[] waitingTime;
    int input;
    int quantum;
    int totalWaitingTime = 0;
    public void printAll(){
        System.out.print("How many processes? ");
        numberOfProcesses = sc.nextInt();
        System.out.print("What is the quantum? ");
        quantum = sc.nextInt();
        burstTime = new int[numberOfProcesses];
        originalBurstTime = new int[numberOfProcesses];
        waitingTime = new int[numberOfProcesses];
        //PUTTING ALL BURSTTIME IN AN ARRAY
        for(int x=0; x<numberOfProcesses; x++){
             System.out.println("Burst time for process " + (x+1));
             input = sc.nextInt();
             burstTime[x]=  input;
        }
        //DUPLICATE BURSTTIME
        for(int x = 0; x < numberOfProcesses; x++){
            originalBurstTime[x] = burstTime[x];
        }
        
        System.out.println("PROCESS \tBURST TIME");
        for(int x = 0; x < numberOfProcesses; x++){
            System.out.println((x+1)+ "\t\t" + originalBurstTime[x]);
        }
        
        //METHOD CALLING
        WaitingTime(burstTime, originalBurstTime, waitingTime, numberOfProcesses, quantum);
        
        //ADD ALL THE WAITING TIME OF ALL PROCESSES
        for(int x = 0;  x<numberOfProcesses; x++){
            totalWaitingTime = totalWaitingTime + waitingTime[x];
        }
        //GETTING THE AVERAGE WAITING TIME OF ALL PROCESSES
        System.out.println("Average Waiting time: " + ((double)(totalWaitingTime) / (double)numberOfProcesses) + " ms.\n");
    }
    
    public void WaitingTime(int[] burstTime, int[] originalBurstTime, int[] waitingTime, int numberOfProcesses,  int quantum){
        int time = 0;
        while(true){
            boolean done = true;
            for(int x= 0; x< numberOfProcesses; x++){
                //CHECK IF THE BURSTTIME IF GREATER THAN 0
                if(burstTime[x] >0){
                    done = false;
                    //IF BURSTTIME IF GREATER THAN QUANTUM, ADD THE QUANTUM TO THE TIME AND REDUCE THE BURSTTIME WITH THE QUANTUM
                    if(burstTime[x] > quantum){
                        time += quantum;
                        burstTime[x] -= quantum;
                    }
                    //IF BURSTTIME IS LESSER OR EQUAL TO THE QUANTUM, ADD THE REMAINING BURSTIME TO THE TIME, 
                    //PUT THE TOTAL WAITING TIME OF THE CURRENT PROCESS BY SUBTRACTING THE TIME BY THE ORIGINAL BURST TIME OF THE CURRENT PROCESS
                    //AND REDUCE THE BURST TIME BY ITSELF TO MAKE IT 0
                    else{
                        time = time+ burstTime[x];
                        waitingTime[x] = time - originalBurstTime[x];
                        burstTime[x] = 0;
                    }
                }
                
            }
            //IF ALL BURSTTIME ARE EQUAL TO 0 THEN END WHILE THE LOOP
            if(done == true){
                break;
            }
        }
    }
}
