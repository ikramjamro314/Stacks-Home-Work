public class LinkedStack implements Stack{
    Node head;
    int size;

    class Node {
        Object data;
        Node next;

        Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Object peak() {
        if (head.next==null) {
            return null;
        }
        return head.data;
    }

    public Object pop() {
        if (size == 0) {
            return null;
        }
        Object temp = head.data;
        head = head.next;
        --size;
        return temp;
    }

    public void push(Object Obj1) {
        head=new Node(Obj1,head);
        ++size;
    }
//    1. Print the elements of the linked stack
    public void print(LinkedStack obj){
        while(obj.head!=null){
            System.out.println(" |"+obj.head.data +" |");
            obj.head=obj.head.next;
        }
        System.out.println("------");
    }
    public int getSize(){
        return size;
    }

    //2. Method to store the elements of Linkedstack into ArrayStack
    public arrStack toArrayStack(LinkedStack obj){
        arrStack arr=new arrStack(obj.getSize());
        Node temp=obj.head;
        while(temp!=null){
            arr.push(temp.data);
            temp=temp.next;
        }
        arrStack a1=new arrStack(obj.getSize());
        for(int i= arr.getSize()-1;i>=0;i--){
            a1.push(arr.data[i]);
        }
        return a1;
    }

    //3. Remove the bottom element of the LinkedStack.
    public void removeBottom(LinkedStack obj){
        if(obj.head==null){
            try {
                throw new Exception("Stack is Empty");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(obj.head.next==null){
              obj.head=null;
        }
        Node temp=obj.head;
        while(temp.next.next==null){
            temp=temp.next;

        }
        temp=temp.next.next;
    --size;
    }

    //4. Search any element in the LinkedStack.
    public boolean search( LinkedStack obj , Object data){
        if(obj.head==null){
            return false;
        }
        while(obj.head!=null){
            if(obj.head.data==data){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
  LinkedStack fruit=new LinkedStack();
  fruit.push("Cheko");
        fruit.push("Banana");
        fruit.push("Apple");
        fruit.push("Chilgoza");
//        System.out.println(fruit.removeBottom(fruit));
        fruit.print(fruit);





//        arrStack a1=fruit.toArrayStack(fruit);
//            a1.print(a1);
    }
}
