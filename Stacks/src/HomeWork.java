class arrStack implements Stack{
      Object[] data;
      int size;
    public arrStack(int capacity){
        data=new Object[capacity];
    }
    public int getSize(){
        return size;
    }
    public Object peak() {
        if(getSize()==0) {
            try {
                throw new Exception("Stack is Empty");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return data[size-1];
    }
    public Object pop() {
        if(getSize()==0){
            try {
                throw new Exception("Stack is Empty");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        Object temp=data[--size];
        data[size]=null;
        return temp;
    }
    public void push(Object obj){
        if(size==data.length){
            Resize();
        }
        data[size++]=obj;
    }
    public void  Resize(){
        Object[] old=data;
        data=new Object[2*data.length];
        System.arraycopy(old,0,data,0,size);
    }

    // 1. Method to merge the elements of the two staccks in one stack
    public arrStack mergeStacks(arrStack obj1, arrStack obj2){
        while (obj2.getSize() != 0) {
            obj1.push(obj2.pop());
        }
        return obj1;
    }

    //2. to print the elements of the stack
    public void print(arrStack obj) {
        for (int i = 0; i < getSize(); i++) {
            System.out.println("| "+obj.data[i]+" |");
        }
        System.out.println("------");
    }

    // 3. to compare that if the elements of two stacks are equal or not
    public boolean compArray(arrStack obj1, arrStack obj2) {
        if (obj1.getSize() != obj2.getSize()) {
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            if (obj1.data[i] != obj2.data[i]) {
                return false;
            }
        }
        return true;

    }

    //4. Method to change the elements of the Arraystack to store in the form of Linkedstack
    public LinkedStack toLinkedStack(arrStack obj) {
        LinkedStack LL = new LinkedStack();
        for (int i = 0; i < getSize(); i++) {
            LL.push(obj.data[i]);
        }
        return LL;
    }

// 5. Method to print the elements of the stack in string form instead of giving a worse address of the object
    public String toString() {
        StringBuilder str=new StringBuilder("{");
        for (int i = 0; i < getSize(); i++) {
            str.append(data[i]+" ,");
        }
        String s1 = new String(str+" } ");
        return s1;
    }
}
public class HomeWork {
    public static void main(String[] args) throws Exception{

        arrStack fruit =new arrStack(10);
        fruit.push("Orange");
        fruit.push("Banana");
        fruit.push("Kiwi");
        fruit.push("Tomatoes");
//        System.out.println(fruit);


        arrStack vegetables=new arrStack(10);
        vegetables.push("Carrot");
        vegetables.push("Onion");
        vegetables.push("Cucumber");
//        LinkedStack L1=vegetables.toLinkedStack(vegetables);
//        L1.print();


//        arrStack total=new arrStack(20);
//       total= total.mergeStacks(fruit,vegetables);
//       total.print(total);
//        System.out.println(total.compArray(fruit,fruit));



}
    }

