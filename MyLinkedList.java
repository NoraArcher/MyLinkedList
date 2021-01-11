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

 public void add(int index, String value) { // index = 2, value = "1x"., this = 0x, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9  size =11
   Node x = new Node(value); // x = "1x", next null, prev null
   if (index > size | index < 0) {
     throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
   }
   if (index == size) {
     add(value);
   } else if (index == 0) {
     x.setNext(head); head.setPrev(x);
     head = x;
     size++;
   } else if (index == size - 1) {
     x.setNext(tail); x.setPrev(tail.prev());
     tail.prev().setNext(x);  tail.setPrev(x);
     size++;
   } else {
     Node ahead = findNth(index);
     ahead.next().setPrev(ahead);
     x.setNext(ahead);
     x.setPrev(ahead.prev());
     ahead.prev().setNext(x);
     ahead.setPrev(x);
     size++;
   }
 }

 public String get(int index) {
   if (index >= size | index < 0) {
     throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
   }
   return findNth(index).data();
 }

 public String set(int index, String value) {
   if (index >= size | index < 0) {
     throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
   }
   String temp;
   if (size == 1) {
     temp = tail.data();
     tail.setData(value);
     head = tail;
   } else if (index == size - 1) {
     Node b = tail;
     temp = b.data(); // temp = drucker
     b.setData(value);
     b.prev().setNext(b);
     tail = b;
   } else if (index == 0) {
     Node b = head;
     temp = b.data();
     b.setData(value);
     b.next().setPrev(b);
     head = b;
   } else {
     Node b = findNth(index);
     temp = b.data();
     b.setData(value);
     b.prev().setNext(b);
     b.next().setPrev(b);
   }
   return temp;
 }

 public String toString() {
   if (size == 0) return "[]";
   Node current = head;
   String ans = "[";
   for (int i = 0; i < size; i++) {
     ans += current.data() + ", ";
     current = current.next();
   }
   return ans.substring(0, ans.length() - 2) + "]";
 }

 public String toStringBack() {
   if (size == 0) return "[]";
   Node current = tail;
   String ans = "";
   for (int i = 0; i < size; i++) {
     ans = current.data() + ", " + ans;
     current = current.prev();
   }
   return "["+ans.substring(0, ans.length() - 2) + "]";
 }

 public String toStringReversed() {
   if (size == 0) return "[]";
   Node current = tail;
   String ans = "[";
   for (int i = 0; i < size - 1; i++) {
     ans += current.data() + ", ";
     current = current.prev();
   }
   ans += current.data() + ", ";
   return ans.substring(0, ans.length() - 2) + "]";
 }

 private Node findNth(int index) {
   Node current;
   if (index >= size | index < 0) {
     throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
   }
   if (size/2 < index) {
     current = tail;
     for (int i = size - 1; i > index; i--) {
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

 ///PART 2

 //There should be several cases: removing the head/tail , removing the final element of a list (size 1 list), and removing from the middle.
 public String remove(int index) {
   if (index >= size | index < 0) {
     throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
   }
   Node gone = findNth(index);
   String t = gone.data();
   if (size == 1) {
     head = null;
     tail = null;
     size = 0;
   } else if (index == size - 1) { // remove tail
     gone.prev().setNext(null);
     tail = gone.prev();
     size--;
   } else if (index == 0) { // remove head
     gone.next().setPrev(null);
     head = gone.next();
     size--;
   } else {
     gone.prev().setNext(gone.next());
     gone.next().setPrev(gone.prev());
     size--;
   }
   return t;
 }

 /*
*@postcondition: All of the elements from other are removed from the other, and connected to the end of this linked list.
*@postcondition: The size of other is reduced to 0.
*@postcondition: The size of this is now the combined sizes of both original lists
*/
 public void extend(MyLinkedList other){
   if (this.size < 1) {
     this.head = other.head;
     this.tail = other.tail;
   } else if (other.size < 1) {
     int x = 1;
   } else {
     other.head.setPrev(this.tail);
     this.tail.setNext(other.head);
     this.tail = other.tail;
   }
   this.size += other.size;
   other.size = 0;
   other.head = null;
   other.tail = null;
 }

///PART 3?




///////////
}
