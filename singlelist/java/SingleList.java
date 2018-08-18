/**
 * SingleList
 */
public class SingleList {

    private Node head;
    private Node tail;


    public void addFromTail(Object v){
        Node node = new Node(v);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            this.tail = node;
        }
    }

    public void addFromHead(Object v){
        Node node = new Node(v);
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }

    public boolean contains(Object v){
        if(this.head == null)return false;
        Node node = this.head;
        while(node != null){
            if(node.val == v){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean remove(Object v){
        if(this.head == null)return false;
        Node node = this.head;
        if(node.val == v){
            if(this.head == this.tail){
                this.head = null;
                this.tail = null;
            }else{
                this.head = this.head.next;
            }
            return true;
        }
        
        while(node.next != null){
            if(node.next.val == v){
                if(node.next == this.tail){
                    tail = node;
                }
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void display(){
        Node node = this.head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public void reverse(){
        Node curr = this.tail;
        while (curr != this.head) {
            Node prev = this.head;
            while (prev.next != curr) {
                prev = prev.next;
            }
            System.out.println(curr.val);
            curr = prev;
        }
        System.out.println(curr.val);
    }


    public static void main(String[] args){
        SingleList sl = new SingleList();

        for (int i = 0; i < 10; i++) {
            sl.addFromTail(i);
        }

        sl.addFromHead(67);
        sl.addFromHead(78);

        sl.display();
        
        System.out.println();
        System.out.println(sl.remove(9));
        sl.display();
    }
}