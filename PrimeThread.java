import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class PrimeThread {

  private static int total = 0;
  // this provided thread calls functions you will need to run in order to
  // calculate the number of threads between the provided min and max values.

  /**
   * Notice how this is a synchronized method! This allows multiple threads to
   * access it safely.
   * We use this to keep track of the total number of primes found.
   */
  synchronized private static void sendBack(int count) {
    total += count;
  }

  /**
   * Count the primes between min and max, inclusive.
   * you need to implement this!
   */
  private static int countPrimes(int min, int max) {
    int count = 0;
    for (int i = min; i <= max; i++) {
      if (isPrime(i) == true) {
        count++;
      }
    }
    return count;
  }

  /**
   * Test whether x is a prime number.
   * x is assumed to be greater than 1.
   * You need to implement this!
   */

  public static boolean isPrime(int n) {

        if((n > 2 && n % 2 == 0) || n == 1) {
            return false;
        }

        for (int i = 3; i <= (int)Math.sqrt(n); i += 2) {

            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

  public static void main(String args[]) {
    int processors = Runtime.getRuntime().availableProcessors();
    if (processors == 1)
      System.out.println("Your computer has only 1 available processor.\n");
    else
      System.out.println("Your computer has " + processors + " available processors.\n");
    // uncomment the following once you're ready to take user input for the number
    // of threads and max value to test
    Scanner reader = new Scanner(System.in);
    System.out.println("Enter the number for which you wish to know how many primes are smaller than it: ");
    int max = reader.nextInt();
    System.out.println("Enter the number of threads you wish to use in your program");
    int threads = reader.nextInt();
    reader.close();

    // Starting time
    Instant start = Instant.now();

    // Write the code for spawning the desired number of CountPrimeThreads
    // be sure to divide the work among the specified number of threads efficiently.
    // Use .join() to check to see if a thread is finished. write this in java

    // write code for creating the right number of threads based on max divided by
    // chunk
    CountPrimesThread[] threadArray = new CountPrimesThread[threads];
    // write code for starting the threads

    int chunk = max / threads;
    int top = chunk;
    int bottom = 1;

    for (int i = 0; i < threads; i++) {
      if (i == threads - 1) {
        top = max;
      }
      CountPrimesThread thread = new CountPrimesThread(bottom, top);
      thread.start();
      threadArray[i] = thread;
      bottom += chunk;
      top += chunk;
    }

    // write code for joining the threads
    for (CountPrimesThread thread : threadArray) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // write code for printing the total number of primes found

    System.out.println("Found " + total + " primes.");

    // End time
    Instant end = Instant.now();
    long time = Duration.between(start, end).toMillis();
    System.out.println();
    System.out.println(time + " Milli seconds");
  }

  public static class CountPrimesThread extends Thread {
    int count = 0;
    int min, max;

    public CountPrimesThread(int min, int max) {
      this.min = min;
      this.max = max;
    }

    public void run() {
      count = countPrimes(min, max);
      sendBack(count);
    }
  }
}
