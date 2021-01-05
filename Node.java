public class Node {

  private String data;
  private Node next,prev;

  public Node(String value){
    data = value;
    next = null;
    prev = null;
  }

  public String data() {
    return data;
  }

  public Node next() {
    return next;
  }

  public Node prev() {
    return prev;
  }

  public String setData(String value) {
    String temp = data;
    data = value;
    return temp;
  }

  public Node setNext(Node a) {
    Node temp = next;
    next = a;
    return temp;
  }

  public Node setPrev(Node b) {
    Node temp = prev;
    prev = b;
    return temp;
  }

}
