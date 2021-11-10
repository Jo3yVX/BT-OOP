import java.io.*;
import java.lang.reflect.Array;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PhanTu <T extends Comparable<T>>{
  private T element;

  public boolean isGreaterThan(T a) {
    return element.compareTo(a) == 1 ? true : false;
  }

  public void readFile() throws IOException {
    Scanner sc = new Scanner(System.in);

    System.out.println("Input file: ");
    String inPath = sc.nextLine();
    File readFile = new File(inPath);

    System.out.println("Output file: ");
    String outPath = sc.nextLine();
    File newFile = new File(outPath);

    if (!newFile.createNewFile()) {
      System.out.println("Existed!");
      return;
    }

    Queue<T> pq = new PriorityQueue<T>();
    sc = new Scanner(readFile);

    while (sc.hasNextLine()) {
      pq.add((T)sc.nextLine());
    }

    FileWriter fw = new FileWriter(outPath);
    while (!pq.isEmpty()) {
      fw.write((String)pq.remove() + "\n");
    }
    fw.close();
  }

}
