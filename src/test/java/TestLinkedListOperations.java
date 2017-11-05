import com.observeai.llops.LinkedList;
import com.observeai.llops.LinkedListOperations;
import com.observeai.llops.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedListOperations {
    private LinkedList list1;
    private LinkedList list2;
    private Node head1;
    private Node head2;
    private LinkedListOperations linkedListOperations;

    @Before
    public void setUp() {
        linkedListOperations = new LinkedListOperations();
        list1 = new LinkedList();
        list1.addNodeAtTheEnd(new Node(4));
        list1.addNodeAtTheEnd(new Node(0));
        list1.addNodeAtTheEnd(new Node(0));

        list2 = new LinkedList();
        list2.addNodeAtTheEnd(new Node(8));
        list2.addNodeAtTheEnd(new Node(0));
        list2.addNodeAtTheEnd(new Node(0));
        list2.addNodeAtTheEnd(new Node(0));

        head1 = new Node(5);
        head1.setNext(new Node(2));

        head2 = new Node(1);
        head2.setNext(new Node(3));

    }

    @Test
    public void testSumPositiveCase() {
        LinkedList sum = linkedListOperations.sum(list1, list2);
        String expected = "8400";
        Assert.assertEquals(expected, sum.toString());
    }

    @Test
    public void testSumWithBothNullLists() {
        LinkedList sum = linkedListOperations.sum(null, null);
        String expected = "0";
        Assert.assertEquals(expected, sum.toString());
    }

    @Test
    public void testSumWithFirstListAsNull() {
        LinkedList sum = linkedListOperations.sum(null, list2);
        String expected = "8000";
        Assert.assertEquals(expected, sum.toString());
    }


    @Test
    public void testSumWithSecondListAsNull() {
        LinkedList sum = linkedListOperations.sum(list1, null);
        String expected = "400";
        Assert.assertEquals(expected, sum.toString());
    }

    @Test
    public void testSumWithFirstListAsEmpty() {
        LinkedList sum = linkedListOperations.sum(new LinkedList(), list2);
        String expected = "8000";
        Assert.assertEquals(expected, sum.toString());
    }

    @Test
    public void testSumWithSecondListAsEmpty() {
        LinkedList sum = linkedListOperations.sum(list1, new LinkedList());
        String expected = "400";
        Assert.assertEquals(expected, sum.toString());
    }

    @Test
    public void testOptimizedSumPositiveCase() {
        Node head = linkedListOperations.optimizedSum(head1, head2);
        String expected = "65";
        String actual = listToString(head);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testOptimizedSumWithFirstParameterAsNull() {
        Node head = linkedListOperations.optimizedSum(null, head2);
        String expected = "13";
        String actual = listToString(head);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testOptimizedSumWithSecondParameterAsNull() {
        Node head = linkedListOperations.optimizedSum(head1, null);
        String expected = "52";
        String actual = listToString(head);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testOptimizedSumWithBothParameterAsNull() {
        Node head = linkedListOperations.optimizedSum(null, null);
        String expected = "0";
        String actual = listToString(head);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyPositiveCase() {
        LinkedList multiplication = linkedListOperations.multiply(list1, list2);
        String expected = "3200000";
        Assert.assertEquals(expected, multiplication.toString());
    }

    @Test
    public void testMultiplyWithBothNullLists() {
        LinkedList multiplication = linkedListOperations.multiply(null, null);
        String expected = "0";
        Assert.assertEquals(expected, multiplication.toString());
    }

    @Test
    public void testMultiplyWithFirstListAsNull() {
        LinkedList multiplication = linkedListOperations.multiply(null, list2);
        String expected = "0";
        Assert.assertEquals(expected, multiplication.toString());
    }

    @Test
    public void testMultiplyWithSecondListAsNull() {
        LinkedList multiplication = linkedListOperations.multiply(list1, null);
        String expected = "0";
        Assert.assertEquals(expected, multiplication.toString());
    }

    @Test
    public void testMultiplyWithFirstListAsEmpty() {
        LinkedList multiplication = linkedListOperations.multiply(new LinkedList(), list2);
        String expected = "0";
        Assert.assertEquals(expected, multiplication.toString());
    }

    @Test
    public void testMultiplyWithSecondListAsEmpty() {
        LinkedList multiplication = linkedListOperations.multiply(list1, new LinkedList());
        String expected = "0";
        Assert.assertEquals(expected, multiplication.toString());
    }

    private String listToString(Node head) {
        if (head == null) new String();
        Node curr = head;
        StringBuffer sb = new StringBuffer();
        while (curr != null) {
            sb.append(curr.getVal());
            curr = curr.getNext();
        }
        return sb.toString();
    }

}
