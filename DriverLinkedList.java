import java.util.*;
import java.io.*;
public class DriverLinkedList {

  public static void main(String[] args) {
    MyLinkedList gibby = new MyLinkedList();
    gibby.add("Affe"); gibby.add("Bruecke"); gibby.add("Drucker");
    System.out.println(gibby.size());
    System.out.println(gibby.toString());
    System.out.println("Should be the same " +gibby.get(0)+"/"+gibby.get(1)+"/"+gibby.get(2)+"\n");
    gibby.add(2, "Christkind");
    System.out.println(gibby.toString());
    gibby.set(1, "Biene");
    gibby.set(3, "Dachs");
    gibby.add(4, "Eichhoernchen");
    gibby.add(5, "Guerteltier");
    gibby.add(0, "Alphabet Tiergarten");
    System.out.println(gibby.toStringBack());
    gibby.set(6, "Fuchs");
    gibby.add("Gepard");
    System.out.println(gibby.toString());
    //need to test for index out of bound exceptions, with try and catch
    try {
      gibby.get(-2);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("caught it!");
    } catch (RuntimeException e) {
      System.out.println("it fell doofus");
    }
    try {
      gibby.add(9, "Helga the Zoo-Keeper");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("caught it!");
    } catch (RuntimeException e) {
      System.out.println("it fell doofus");
    }
    try {
      gibby.set(8, "pigeons");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("caught it!");
    } catch (RuntimeException e) {
      System.out.println("it fell doofus");
    }
    System.out.println(gibby.toStringBack());
  }


//
}
