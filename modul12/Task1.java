package ua.goit.sergey.modul12;

public class Task1 {

    private final static long TIME = System.currentTimeMillis();
    private static boolean flag = true;
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            while (flag){
                if (getTime() % 5 != 0) System.out.println(getTime() + " секунд.");
                if (getTime() ==10 ) flag=false;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread1 = new Thread(() -> {
            while (flag){
                if (getTime() % 5 == 0) System.out.println( "Прошло " + getTime() + " секунд.");
                if(getTime() ==10 ) flag=false;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();
        thread1.start();

    }
        
    private static long getTime(){
        return (System.currentTimeMillis() - TIME) / 1000;
    }
}
