public class DoubleLinkedList{
    public Node head;
    public Node tail;

    public void prepend(Object data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    public void append(Object data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }

    public boolean search(Object data){
        if(this.head == null){
            return false;
        }
        Node node = this.head;
        while(node != null){
            if(node.data == data){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean remove(Object data){
        if(this.head == null){
            return false;
        }
        if(this.head.data == data){
            if(this.head == this.tail){
                this.head = null;
                this.tail = null;
            }else{
                this.head = this.head.next;
                this.head.prev = null;
            }
            return true;
        }
        Node node = this.head.next;
        while(node != null){
            if(node.data == data){
                if(node == this.tail){
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                }else{
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int size(){
        int count = 0;
        Node node = this.head;
        while(node != null){
            node = node.next;
            count++;
        }
        return count;
    }

    public void traverse(){
        Node node = this.head;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public void reverse(){
        Node node = this.tail;
        while(node != null){
            System.out.println(node.data);
            node = node.prev;
        }
    }

    public void toArrayList(){

    }

    public static void main(String[] args){
        DoubleLinkedList list = new DoubleLinkedList();
        list.append(2);
        list.append(4);
        list.append(6);
        list.append(7);
        list.append(9);
        list.append(10);

        //list.traverse();
        //System.out.println(list.size());
        //list.reverse();
        System.out.println(list.remove(9));
        list.traverse();

    }
}