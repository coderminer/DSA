import java.util.ArrayList;
import java.util.List;

public class LinkedList{
    private Node head;

    // add from head
    public void prepend(Object data){
        Node node = new Node(data);
        if(this.head != null){
            node.next = this.head;
        }
        this.head = node;
    }

    //add from tail
    public void append(Object data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            return;
        }
        Node last = this.head;
        while(last.next != null){
            last = last.next;
        }
        last.next = node;
    }

    //remove the node by value
    public boolean removeByValue(Object data){
        if(this.head == null){
            return false;
        }
        if(this.head.data == data){
            this.head = this.head.next;
            return true;
        }
        Node node = this.head;
        while (node.next != null) {
            if(node.next.data == data){
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    //remove the node by index
    public boolean removeByIndex(int i){

        return false;
    }

    //search the data from the linkedlist
    public boolean search(Object data){
        Node node = this.head;
        while(node != null){
            if(node.data == data){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    //get the first node of the linkedlist
    public Node first(){
        return this.head;
    }

    //get the last node of the linkedlist
    public Node last(){
        if(this.head == null){
            return null;
        }
        
        Node last = this.head;
        while(last.next != null){
            last = last.next;
        }
        return last;
    }

    //get the size of the linkedlist
    public int size(){
        Node cur = this.head;
        int size = 0;
        while(cur != null){
            cur = cur.next;
            size++;
        }
        return size;
    }

    //traverse the linkedlist
    public void display(){
        Node node = this.head;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public void reverse(){
        Node cur = this.last();
        while(cur != this.head){
            Node prev = this.head;
            while(prev.next != cur){
                prev = prev.next;
            }
            System.out.println(cur.data);
            cur = prev;
        }
        System.out.println(cur.data);
    }

    public List<Object> toArrayList(){
        List<Object> arrs = new ArrayList<>();
        Node node = this.head;
        while(node != null){
            arrs.add(node.data);
            node = node.next;
        }
        return arrs;
    }


    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.append(2);
        list.append(4);
        list.append(6);
        list.append(7);
        list.append(9);
        list.append(10);

        list.display();
        // System.out.println(list.size());
        // List<Object> arrs = list.toArrayList();
        // System.out.println(arrs.size());
        // for(Object arr : arrs){
        //     System.out.println(arr);
        // }
        System.out.println();
        list.reverse();
        
    }
}