import java.util.Scanner;

import java.util.Arrays;
public class SJF_P
{
    int numberOfProcesses;
    Scanner sc = new Scanner(System.in);
    int[] burstTime, arrivalTime, duplicateBurstTime, waitingTime;
    int input;
    int complete = 0, t = 0, minm = Integer.MAX_VALUE; 
        int shortest = 0, finish_time, totalWaitingTime =0;
        double averageWaitingTime; 
        boolean check = false;
  public void printAll(){
      System.out.print("How many processes? ");
        numberOfProcesses = sc.nextInt();
        burstTime = new int[numberOfProcesses];
        arrivalTime = new int[numberOfProcesses];
        waitingTime = new int[numberOfProcesses];
        duplicateBurstTime = new int[numberOfProcesses];
      //loop for adding processes in the array
        for(int x = 0; x < numberOfProcesses; x++){
            System.out.println("Enter the burst time of process " + (x+1));
            input = sc.nextInt();
            burstTime[x] = input;
        }
        for(int x = 0; x < numberOfProcesses; x++){
            System.out.println("Enter the arrival time of process " + (x+1));
            input = sc.nextInt();
            arrivalTime[x] = input;
        }  
      //DUPLICATE BURSTTIME
        for(int x = 0; x < numberOfProcesses; x++){
            duplicateBurstTime[x] = burstTime[x];
        }  
        
        while(complete != numberOfProcesses) {
            for(int x = 0; x<numberOfProcesses; x++){
                if((arrivalTime[x] <= t) && (duplicateBurstTime[x] < minm) && duplicateBurstTime[x] > 0){
                    minm = duplicateBurstTime[x];
                    shortest = x;
                    check = true;
                }
            }
            if(check == false){
                t++;
                continue;
            }
            duplicateBurstTime[shortest]--;
            
            minm = duplicateBurstTime[shortest]; 
            
            if (minm == 0) 
            {
                minm = Integer.MAX_VALUE; 
            }
            
            if(duplicateBurstTime[shortest] == 0){
                complete++;
                check = false;
                finish_time = t + 1; 
                
                waitingTime[shortest] = finish_time - burstTime[shortest] - arrivalTime[shortest];
                
                if(waitingTime[shortest] < 0 ){
                    waitingTime[shortest] = 0;
                }
                
            }
            t++;
       
                
        }
        
        for(int x = 0 ; x< numberOfProcesses; x++){
            totalWaitingTime += waitingTime[x];
        }
        averageWaitingTime = totalWaitingTime;
        averageWaitingTime /= numberOfProcesses;
        System.out.println("PROCESS \tBURST TIME\t ARRIVAL TIME");
        for(int x = 0; x < numberOfProcesses; x++){
            System.out.println((x+1)+ "\t\t" + burstTime[x] + "\t\t" + arrivalTime[x]);
        }
        System.out.println("Average Waiting Time " + averageWaitingTime + "\n");
    }
}
