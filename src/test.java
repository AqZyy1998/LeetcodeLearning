public class test {
    private volatile int pos = 1;
    private volatile Integer count = 0;

    public void one(int i) {
        synchronized (this) {
            System.out.println(count++);
        }
    }

    public static void main(String[] args) {
        test demo = new test();
        for (int i = 1; i <= 6; i++) {
            int j = i;
            new Thread(()->{
                while(true) {
                    demo.one(j);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e){}
                }
            }).start();
        }
    }
}
