public class TesterLinkedList{
  public static void main(String[]args){
    MyLinkedList words = new MyLinkedList();

    //add 0-9 in order
    for(int i = 0; i < 10; i++){
      words.add(i+"");
    }
    //insert 0x - 9x before each value 0-9
    for(int i = 0; i < 10; i++){
      words.add(2*i,i+"x");
    }
    //check the head/tail add
    words.add(0,"head");
    words.add(words.size(),"tail");

    try{
      words.add(-1,"");
      System.out.println("ERROR! Added to negative index");
    }catch(IndexOutOfBoundsException e){

    }

    try{
      words.add(words.size()+1,"");
      System.out.println("ERROR! Added to (size + 1) index");
    }catch(IndexOutOfBoundsException e){

    }


    System.out.println("Your result:\n"+words+" "+words.size());
    System.out.println("expected:\n[head, 0x, 0, 1x, 1, 2x, 2, 3x, 3, 4x, 4, 5x, 5, 6x, 6, 7x, 7, 8x, 8, 9x, 9, tail] 22");
    System.out.println("\nYour result:\n"+words.toStringReversed()+" "+words.size());
    System.out.println("expected:\n[tail, 9, 9x, 8, 8x, 7, 7x, 6, 6x, 5, 5x, 4, 4x, 3, 3x, 2, 2x, 1, 1x, 0, 0x, head] 22");

    MyLinkedList x = new MyLinkedList();
    System.out.println("\nBlank linked list: "+x.toString());
    x.add("Kartoffel");
    System.out.println("One-Node linked list: "+x.toString());

    MyLinkedList a = new MyLinkedList();
    MyLinkedList b = new MyLinkedList();
    for(int i = 0; i < 10; i++){
      if(i < 5){
        a.add(i+"");
      }else{
        b.add(i+"");
      }
    }
    System.out.println();
    System.out.println("A:"+a+a.size());
    System.out.println("B:"+b+b.size());

    a.extend(b);
    System.out.println("A:"+a+a.size());
    System.out.println("B size:"+ b.size());
    System.out.println("B:"+b+b.size());
    System.out.println("A reversed:"+a.toStringReversed()+a.size());
    System.out.println("B reversed:"+b.toStringReversed()+b.size());

    MyLinkedList a2 = new MyLinkedList(); MyLinkedList a3 = new MyLinkedList(); //you cannot just make a copy, they collect the same nodes
    for(int i = 0; i < 10; i++){
      a2.add(i+"");
      a3.add(i+"");
    }
    a2.remove(0);  a2.remove(1);  a2.remove(2);  a2.remove(3);  a2.remove(4);
    a3.remove(1);  a3.remove(2);  a3.remove(3);  a3.remove(4);  a3.remove(5);
    System.out.println();
    System.out.println("A: "+a+a.size());
    System.out.println("Odd A: "+a2+a2.size());
    System.out.println("Even A: "+a3+a3.size());
    x.remove(0);
    System.out.println("One-Node now No-Node linked list:"+x);

  }
}
