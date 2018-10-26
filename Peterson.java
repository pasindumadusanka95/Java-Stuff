
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class Producer extends Thread{
    
    Producer(String name){
        this.setName(name);
    }


    
    public void run(){
        for(int rounds=0;rounds<20;rounds++){
            Peterson.enter_region(0);//add process to critical region
            int bufferdatacount=Peterson.bufferdatacount;
            int buffersize=Peterson.buffer.length;

            if(bufferdatacount!=buffersize){
                Random rand = new Random();
                Peterson.buffer[bufferdatacount]= rand.nextInt(50) + 1;
                Peterson.bufferdatacount+=1;
            }
            else{
                System.out.println("No free space in the buffer");
            }

             for(int i=0;i<Peterson.buffer.length;i++){
                System.out.print(Peterson.buffer[i]+" ");
            }
            System.out.println();

            Random rand = new Random();//get random integer to make thread sleep
            int sleep=(rand.nextInt(4) + 1)*1000;
            System.out.println(this.getName()+" "+"will sleep for "+sleep/1000+" seconds");
            Peterson.leave_region(0);//leave process from the critical region
            System.out.println();
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
       System.out.println("\n\n"+this.getName()+" "+" is Terminated..!\n"); 
          
    }
    
}

class Consumer extends Thread{
    
    Consumer(String name){
        this.setName(name);
    }
    
    public void run(){
        for(int rounds=0;rounds<20;rounds++){
            Peterson.enter_region(1);//add process to critical reigion
            int bufferdatacount=Peterson.bufferdatacount;

            if(bufferdatacount!=0){
                System.out.println(Peterson.buffer[bufferdatacount-1]);
                Peterson.buffer[bufferdatacount-1]=0;
                Peterson.bufferdatacount-=1;
            }
            else{
                System.out.println("No data to fetch");
            }
            for(int i=0;i<Peterson.buffer.length;i++){
                System.out.print(Peterson.buffer[i]+" ");
            }
            System.out.println();

            Random rand = new Random();//get random integer to make thread sleep
            int sleep=(rand.nextInt(4) + 1)*1000;
            System.out.println(this.getName()+" "+"will sleep for "+sleep/1000+" seconds");
            Peterson.leave_region(1);//leave process from the critical region
            System.out.println();
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("\n\n"+this.getName()+" "+" is Terminated..!\n");   
    }
    
}


public class Peterson {
    static int pcount=2;//No of process, In this code processes are equal to threads
    static int turn; 
    static boolean interested[]=new boolean[pcount]; //boolean process array. control the critical reagion state by changing values
    static int buffer[]=new int[6]; //buffer to illustrate produser, consumer problem
    static int bufferdatacount=0; // filled data count in the buffer
    static Thread arr[]=new Thread[2];// process array

    
    public static void enter_region(int process){
        int other=1-process;
        interested[process]=true;//set process to ready state(add to critical region)
        turn=process;
        System.out.println(arr[process].getName()+" "+" is Waiting ");
        //keep the process in waiting mod till below condition get false
        while(turn==process && interested[other]==true){}
        //start run the process after the waiting mod
        System.out.println(arr[process].getName()+" "+" is Executing "); 
        
    }
   
    public static void leave_region(int process){
        System.out.println(arr[process].getName()+" "+" is leaved from the critical region "); 
        interested[process]=false;//remove process from the critical region
    }
    
    public static void main(String[] args) {
       //initialze the boolean array with value false
       for(int i=0;i<pcount;i++){
           interested[i]=false;
       }
       
       //initialize the buffer with 0 values 
       for(int i=0;i<6;i++){
           buffer[i]=0;
       }
       
       //make processes which call producer and consumer
       arr[0]=new Producer("Producer");
       arr[1]=new Consumer("Consumer");
       arr[0].start();
       arr[1].start();
          
    }
    
}
