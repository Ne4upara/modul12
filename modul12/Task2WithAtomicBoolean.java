package modul11;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Task2WithAtomicBoolean {

        static ArrayList list = new ArrayList();
        static AtomicBoolean flag = new AtomicBoolean(true);
        static int n = 15;
        public static void main(String[] args) throws InterruptedException {

            Thread fizzThread = new Thread(() -> fizz());
            Thread buzzThread = new Thread(() -> buzz());
            Thread fizzBuzzThread = new Thread(() -> fizzBuzz());
            Thread numberThread = new Thread(() -> number());

            fizzThread.start();
            buzzThread.start();
            fizzBuzzThread.start();
            numberThread.start();

            fizzThread.join();
            buzzThread.join();
            fizzBuzzThread.join();
            numberThread.join();

            print();
        }

        private static void fizz() {
            while (flag.compareAndSet(false, true)){
                list.add("fizz");
            }
        }

        private static void buzz()  {
            while (flag.compareAndSet(false, true)){
                list.add("buzz");
            }
        }

        private static void fizzBuzz() {
            while (flag.compareAndSet(false, true)){
                list.add("fizzbuzz");
            }
        }

        private static void number() {
            for (int i = 1; i <= n; i++) {

                if (i % 3 == 0 && i % 5 == 0) {
                    flag.set(false);
                    fizzBuzz();
                } else if (i % 3 == 0) {
                    flag.set(false);
                    fizz();
                } else if (i % 5 == 0) {
                    flag.set(false);
                    buzz();
                } else {
                    list.add(String.valueOf(i));
                }
            }
        }

        private static void print(){
            for (Object arr : list){
                System.out.println(arr);
            }
        }
    }