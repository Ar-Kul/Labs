import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    private List<T> items;
    
    public MyStack() {
        items = new ArrayList<>();
    }
    
    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Стек пуст");
        }
        return items.remove(items.size() - 1);
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Стек пуст");
        }
        return items.get(items.size() - 1);
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    public int size() {
        return items.size();
    }
    

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Верхний элемент: " + stack.peek());  
        System.out.println("Удалён: " + stack.pop());           
        System.out.println("Удалён: " + stack.pop());           
        System.out.println("Размер: " + stack.size());          
        System.out.println("Стек пуст? " + stack.isEmpty());    
    }
}
