public class MyLinkedList{

 private int size;
 private Node head,tail;
 //Any helper method that returns a Node object MUST BE PRIVATE! never return nodes, only strings
 public MyLinkedList(){
   size = 0;
   head = null;
   tail = null;
 }

 public int size() {
   return size;
 }

 public boolean add(String value) {
   Node x = new Node(value);
   if (size < 1) {
     head = x;
   } else {
     tail.setNext(x);
     x.setPrev(tail);
   }
   tail = x;
   size++;
   return true;
 }

 public boolean add(int index, String value) {
   Node x = new Node(value);
   if (index > size | index < 0) return false; //should throw but i just down want to worry about it
   if (index == size) {
     return add(value);
   } else if (index == 0) {
     x.setNext(head); head.setPrev(x);
     head = x;
     size++;
     return true;
   } else {
     Node y = findNth(index);
     Node z = y.prev();
     x.setNext(y);  x.setPrev(z); y.setPrev(x); z.setNext(x);
     size++;
     return true;
   }
 }

 public String get(int index) {
   return findNth(index).data();
 }

 public String set(int index, String value) {
   if (index >= size | index < 0) return "false";
   Node b; String temp;
   if (index == size - 1) {
     b = tail;
     temp = b.data();
     b.setData(value);
     b.prev().setNext(b);
     tail = b;
   } else if (index == 0) {
     b = head;
     temp = b.data();
     b.setData(value);
     b.next().setPrev(b);
     head = b;
   } else {
     b = findNth(index);
     temp = b.data();
     b.setData(value);
     b.prev().setNext(b);
     b.next().setPrev(b);
   }
   return temp;
 }

 public String toString() {
   Node current = head;
   String ans = "";
   for (int i = 0; i < size; i++) {
     ans += current.data() + "/";
     current = current.next();
   }
   return ans;
  }

  public String toStringBack() {
    Node current = tail;
    String ans = "";
    for (int i = 0; i < size; i++) {
      ans = current.data() + "/" + ans;
      current = current.prev();
    }
    return ans;
   }

  private Node findNth(int index) {
    Node current;
    //if (size/2 < index) {
    if (false) {
      current = tail;
      for (int i = size; i > index; i--) {
        current = current.prev();
      }
    } else {
      current = head;
      for (int i = 0; i < index; i++) {
        current = current.next();
      }
    }
    return current;
  }

  public String getTail() {
    return tail.data();
  }

  public String getHead() {
    return head.data();
  }

///////////
}
