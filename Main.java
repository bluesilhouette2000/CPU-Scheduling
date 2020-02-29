import java.util.Scanner;
public class Main
{
    
    public Main(){
        int choose = -1;
        FCFS fcfs = new FCFS();
        SJF sjf = new SJF();
        PS ps = new PS();
        RRS rrs = new RRS();
        SJF_P sjfp = new SJF_P();
        System.out.println("SCHEDULING");
        do{
        System.out.println("Choose: \n1. First Come First Serve");
        System.out.println("2. Shortest Job First - Non Preemptive");
        System.out.println("3. Priority Scheduling");
        System.out.println("4. Round Robin Scheduling");
        System.out.println("5. Shortest Job First - Preemptive");
        System.out.println("0. EXIT");
        Scanner sc = new Scanner(System.in);
        choose = sc.nextInt();
         switch(choose){
            case 1:
            fcfs.printAll();
            break;
            case 2:
            sjf.printAll();
            break;
            case 3:
            ps.printAll();
            break;
            case 4:
            rrs.printAll();
            break;
            case 5:
            sjfp.printAll();
            break;
           }
        }
        while(choose != 0);
        
    }
}
