
/**
 * DoubleList
 */
public class DoubleList {

    private Node head;
    private Node tail;

    public void addFromTail(Object val) {
        Node n = new Node(val);
        if(this.head == null){
            this.head = n;
            this.tail = n;
        }else{
            this.tail.next = n;
            n.prev = this.tail;
            this.tail = n;
        }
    }

    public void addFromHead(Object val){
        Node n = new Node(val);
        if(this.head == null){
            this.head = n;
            this.tail = n;
        }else{
            n.next = this.head;
            this.head.prev = n;
            this.head = n;
        }
    }


    public void traverse() {
        Node n = this.head;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    public void reverse(){
        Node n = this.tail;
        while(n != null){
            System.out.println(n.val);
            n = n.prev;
        }
    }

    public boolean contains(Object val) {
        Node n = this.head;
        while(n != null){
            if(n.val == val){
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public boolean remove(Object val){
        if(this.head == null)return false;
        
        if(this.head.val == val){
            if(this.head == this.tail){
                this.head = null;
                this.tail = null;
            }else{
                this.head = this.head.next;
                this.head.prev = null;
            }
            return true;
        }
        Node n = this.head.next;
        while (n != null) {
            if(n.val == val){
                if(n == this.tail){
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                }else{
                    n.prev.next = n.next;
                    n.next.prev = n.prev;
                }
                
                return true;
            }
            n = n.next;
        }
        return false;
    }


    public static void main(String[] args) {
        DoubleList dl = new DoubleList();
        for(int i = 0;i<10;i++){
            dl.addFromTail(i);
        }
        dl.addFromHead(32);
        dl.addFromHead(4);
        dl.traverse();
        System.out.println();
        //dl.reverse();
        dl.remove(9);
        dl.traverse();
    }
}