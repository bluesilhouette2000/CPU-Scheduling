import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
public class PS
{
    int[][] arr;
    int numberOfProcesses,input;
    int[][] unsortedArr;
    int waitingTime=0;
    double averageWaitingTime=0;
    public void printAll(){
      Scanner sc = new Scanner(System.in);
      System.out.print("How many processes? ");
      numberOfProcesses = sc.nextInt();
      arr = new int[numberOfProcesses][2];
      unsortedArr = new int[numberOfProcesses][2];
        for(int x=0; x<numberOfProcesses; x++){
             System.out.println("Burst time for process " + (x+1));
             input = sc.nextInt();
             arr[x][0] =  input;
             System.out.println("Priority for process " +(x+1));
             input = sc.nextInt();
             arr[x][1] =  input;  
        }
        
        //MAKE A DUPLICATE OF THE BURSTIME WITH ITS PRIORITY
        for(int x = 0; x < numberOfProcesses; x++){
            for(int y = 0; y< 2; y++){
                unsortedArr[x][y] = arr[x][y];
            }
        }
        
        sortByColumn(arr,1);
        
        //ADDING THE TOTAL WAITING TIME 
        for(int x = 0; x < numberOfProcesses - 1; x++){
            waitingTime = waitingTime + arr[x][0];
            averageWaitingTime += waitingTime;
        }
        averageWaitingTime = averageWaitingTime / numberOfProcesses;
        
        System.out.println("PROCESS\tBurst Time\tPriority");
        for(int x = 0; x < numberOfProcesses; x++){
            System.out.print((x+1) + "\t" + unsortedArr[x][0] + "\t\t" + unsortedArr[x][1]);;
            System.out.println();
        }
        System.out.println("Average Waiting Time " + averageWaitingTime + "\n");
    }
    
    //METHOD TO SORT THE 2D ARRAY BASED ON THE 2ND COLUMN WHICH IS THE PRIORITY COLUMN
    public static void sortByColumn(int arr[][], int col){
     Arrays.sort(arr, new Comparator<int[]>(){
         @Override
         public int compare(final int[] entry1, final int[] entry2){
             if(entry1[col] > entry2[col])
             return 1;
             else
             return -1;
            }
        }
     );   
    }
}
