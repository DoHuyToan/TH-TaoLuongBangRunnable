public class RunnableDemo implements Runnable{  //implements interface Runnable
    private Thread t;
    private final String theadName;

    RunnableDemo(String name) {
        theadName = name;
        System.out.println("Creating " + theadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + theadName);
        try{
            for (int i=4; i>0; i--){
                System.out.println("Thread: " + theadName + ", " + i);
                // dừng vòng lặp 50s
                Thread.sleep(50);
            }
        } catch (InterruptedException e){
            System.out.println("Thread " + theadName + " interrupted.");
        }
        System.out.println("Thread " + theadName + " exiting.");
    }

//    Phương thức run thực hiện việc hiển thị luồng nào đang được thực hiện.
//    Phương thức start() được sử dụng để tạo ra các luồng với tên tương ứng

    public void start(){
        System.out.println("Starting " + theadName);
        if (t == null) {
            t = new Thread(this, theadName);
            t.start();
        }
    }

//    khai báo 2 đối tượng runnableDemo1 và runnableDemo2 trong phương thức main
//    để tạo 2 luồng thực thi khác nhau

    public static void main(String[] args) {
        System.out.println("Main thread running... ");

        RunnableDemo runnableDemo1 = new RunnableDemo("Thread-1-HR-Database");
        runnableDemo1.start();

        RunnableDemo runnableDemo2 = new RunnableDemo("Thread-2-Send-Email");
        runnableDemo2.start();

        System.out.println("Main thread stopped!!! ");
    }
}
