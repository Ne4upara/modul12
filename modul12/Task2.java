package ua.goit.sergey.modul12;

class A extends Thread {
    public void run() {
        System.out.print("fizz, ");
    }
}
class B extends Thread {
    public void run() {
        System.out.print("buzz, ");
    }
}
class C extends Thread {
    public void run() {
        System.out.print("fizzbuzz, ");
    }
}
public class Task2 {

    public static void main(String[] args) throws Exception {

        getNumber(30);
    }

    private static void getNumber (int n) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    C threadC = new C();
                    threadC.start();
                    threadC.join();}
                else if (i % 5 == 0) {
                    B threadB = new B();
                    threadB.start();
                    threadB.join();}
                else if (i % 3 == 0) {
                    A threadA = new A();
                    threadA.start();
                    threadA.join();}
                else {System.out.print(i + ", ");}
        }
    }
}
