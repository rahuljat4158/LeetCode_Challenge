package Day6;
import java.util.*;

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    ListNode head;
    void add(int data){
        ListNode new_node = new ListNode(data);
        if(head == null){
            head = new_node;
            return;
        }
        ListNode curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = new_node;
    }
}

public class reverseLinkedList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            int x = input.nextInt();
            list.add(x);
        }
        reverse(list.head);
        System.out.println("");
    }
    public static void reverse(ListNode curr){
        // write code here
        ListNode prev = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        while(prev!=null){
            System.out.print(prev.data+" ");
            prev = prev.next;
        }
    }
}
