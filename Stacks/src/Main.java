interface Stack{
     public Object peak();
     public Object pop();
     public void push(Object obj);
     public int getSize();
}
class ArrayStack implements Stack {
    public Object[] data;
    private int size;
    public ArrayStack(int capacity){
        data=new Object[capacity];
    }
    public int getSize(){
        return size;
    }
    public Object peak() {
        if(size==0) {
            try {
                throw new Exception("Stack is Empty");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return data[size-1];
    }
    public Object pop() {
        if(size==0){
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

    public void print(ArrayStack obj) {
        for(int i=0;i<getSize();i++){
            System.out.println(obj.data[i]+" ");
        }
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        ArrayStack fruit = new ArrayStack(10);
        fruit.push("Orange");
        fruit.push("Banana");
        fruit.push("Kiwi");

    }
}