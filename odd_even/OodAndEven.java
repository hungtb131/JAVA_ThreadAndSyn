package odd_even;

public class OodAndEven implements Runnable {
    public String name;
    public int delay;

    public static void main(String[] args) {
        OodAndEven oodAndEven = new OodAndEven("Even",200);
        OodThread threadEven = new OodThread(oodAndEven);
        OodThread threadOod = new OodThread(oodAndEven);
        threadEven.setPriotity(1);
        threadOod.setPriority(5);
        threadEven.start();
        threadOod.start();
    }
    public OodAndEven(String name,int delay){
        this.name = name;
        this.delay = delay;
    }


    @Override
    public void run() {
    this.print();
    }
    public void print(){
        for (int i =0;i<=10;i++){
            System.out.println(i +" " + Thread.currentThread());
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class OodThread extends Thread{
    private String name;
    OodAndEven obj;
    int delay;
    public OodThread(OodAndEven obj){
        this.obj = obj;
        this.name =obj.name;
        this.delay=obj.delay;

    }
    @Override
    public void run(){
        obj.print();
    }

    public void setPriotity(int i) {

    }
}
class EvenThread extends Thread{
    private String name;
    OodAndEven obj;
    int delay;

    public EvenThread(OodAndEven obj) {
        this.name = obj.name;
        this.obj=obj;
        this.delay=obj.delay;
    }

    @Override
    public void run() {
        this.obj.run();
    }
}
