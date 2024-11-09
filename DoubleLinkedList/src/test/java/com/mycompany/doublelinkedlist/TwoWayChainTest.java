import com.mycompany.doublelinkedlist.TwoWayChain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwoWayChainTest {

    @Test
    public void testMove() {
        TwoWayChain<Integer> node1 = new TwoWayChain<>(1);
        TwoWayChain<Integer> node2 = new TwoWayChain<>(2);
        TwoWayChain<Integer> node3 = new TwoWayChain<>(3);

        node1.insertAfter(node2);
        node2.insertAfter(node3);

        // Test moving forward
        TwoWayChain<Integer> movedNode = node1.Move(twc -> twc.Next);
        assertEquals(3, movedNode.Data); 

        // Test moving backward
        movedNode = node3.Move(twc -> twc.Prev);
        assertEquals(1, movedNode.Data);  
    }

    @Test
    public void testInsertAfter() {
        TwoWayChain<Integer> node1 = new TwoWayChain<>(1);
        TwoWayChain<Integer> node2 = new TwoWayChain<>(2);
        TwoWayChain<Integer> node3 = new TwoWayChain<>(3);

        node1.insertAfter(node2);
        node2.insertAfter(node3);

        // Check connections
        assertEquals(2, node1.Next.Data); 
        assertEquals(3, node2.Next.Data); 
        assertEquals(1, node2.Prev.Data);  
    }

    @Test
    public void testRemove() {
        TwoWayChain<Integer> node1 = new TwoWayChain<>(1);
        TwoWayChain<Integer> node2 = new TwoWayChain<>(2);
        TwoWayChain<Integer> node3 = new TwoWayChain<>(3);

        node1.insertAfter(node2);
        node2.insertAfter(node3);
        assertEquals(2, node1.Next.Data);
        assertEquals(2, node3.Prev.Data);

        node2.Remove(); 

       
        assertEquals(3, node1.Next.Data);  
        assertEquals(1, node3.Prev.Data);  
                        
    }

    @Test
    public void testFirst() {
        TwoWayChain<Integer> node1 = new TwoWayChain<>(1);
        TwoWayChain<Integer> node2 = new TwoWayChain<>(2);
        TwoWayChain<Integer> node3 = new TwoWayChain<>(3);

        node1.insertAfter(node2);
        node2.insertAfter(node3);

        assertEquals(1, node3.First().Data); 
    }

    @Test
    public void testLast() {
        TwoWayChain<Integer> node1 = new TwoWayChain<>(1);
        TwoWayChain<Integer> node2 = new TwoWayChain<>(2);
        TwoWayChain<Integer> node3 = new TwoWayChain<>(3);

        node1.insertAfter(node2);
        node2.insertAfter(node3);


        assertEquals(3, node1.Last().Data);
    }
}
