package A;


/*
 * RAFIQUL ISLAM 
 *
 * 
 * 
 */
import java.util.Scanner;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

class SharedMemory extends Thread {
	final static int LOOP = 50;
	final int BUFFER_SIZE = 10;
	int buffer[] = new int[BUFFER_SIZE];
	int in = 0;
	int out = 0;
	int counter = 0;

	// use Producer
	synchronized void insert(int item) {
		 if(counter == BUFFER_SIZE) {
			System.out.println("Buffer is full");
			return;	
		}

		buffer[in] = item;
		System.out.println(item);
		in = (in + 1) % BUFFER_SIZE;
		counter++;
	}

	// use Consumer
	synchronized void remove() {
		int item;
		while (counter == 0) {
			System.out.println("Buffer empty");
			return;
		}
		item = buffer[out];
		out = (out + 1) % BUFFER_SIZE;
		System.out.println(item);
		counter--;
	}

}

class Producer implements Runnable {
	SharedMemory P;
	Random generator = new Random();

	Producer(SharedMemory P) {
		this.P = P;
	}

	public void run() {
		for (int i = 1; i <= SharedMemory.LOOP; i++) {
			try {
				int value;
				value = generator.nextInt(100);
				System.out.print("Produce Number:  " + i + " Produce value: ");
				P.insert(value);
                                
                                // Sleeping Random amount of Time
				Thread.sleep(generator.nextInt(generator.nextInt(3000)));
			} 
                        catch (InterruptedException ex) {
				System.out.println("Exception found in Producer Class");
			}

		}
		System.out.println("Producer Thread Terminated");
	}
}

class Consumer implements Runnable {
	SharedMemory C;
	Random generator = new Random();

	Consumer(SharedMemory C) {
		this.C = C;
	}

	public void run() {
		for (int i = 1; i <= SharedMemory.LOOP; i++) {
			try {
				System.out.print("Consumer Number: " + i + "   Consume Value: ");
				C.remove();
				
				// Sleeping Random amount of Time
				Thread.sleep(generator.nextInt(3000));
			} catch (InterruptedException ex) {
				System.out.println("Exception found in Consumer Class");
			}
		}
		System.out.println("Consumer Thread Terminated");
	}
}

public class Testing {
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		SharedMemory s = new SharedMemory();
		exe.execute(new Producer(s));
		exe.execute(new Consumer(s));
		exe.shutdown();
	}
}


