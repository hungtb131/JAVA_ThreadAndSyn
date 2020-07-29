package SimpleThread;

public class NumberGenerator implements Runnable {
    String name;

    public NumberGenerator(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        this.print();
    }

    synchronized public void print() {
        try {
            for(int i=0;i<10;i++){
                System.out.println("t "+this.name+" " +i+" "+this.hashCode());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NumberGenerator numberGenerator1=new NumberGenerator("thread1");
        NumberGenerator numberGenerator2=new NumberGenerator("thread2");

        Thread thread1=new Thread(numberGenerator1);
        Thread thread2=new Thread(numberGenerator2);

        thread1.start();
        thread1.setPriority(1);
        thread2.start();
        thread2.setPriority(2);
    }
}