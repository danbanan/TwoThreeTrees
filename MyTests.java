import static org.junit.Assert.*;

import org.junit.Test;

public class MyTests {
	private TwoThreeTree tree;
	
	@Test
	public void OneKeyTwoChildren()
	{
		tree = new TwoThreeTree();
		tree.insert(5);
		tree.insert(3);
		tree.insert(6);
		tree.insert(7);
		
		String expected = "6 7";
		assertEquals(expected, tree.search(7));
		assertEquals(expected, tree.search(6));
		
		expected = "5";
		assertEquals(expected, tree.search(5));
		
		expected = "3";
		assertEquals(expected, tree.search(3));
	}
	
	@Test
	public void TwoKeysThreeChildren() {
		tree = new TwoThreeTree();
		tree.insert(5);
		tree.insert(3);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		
		String expected = "3";
		assertEquals(expected, tree.search(3));
		
		expected = "6";
		assertEquals(expected, tree.search(6));
		
		expected = "8 9";
		assertEquals(expected, tree.search(8));
		
		expected = "5 7";
		assertEquals(expected, tree.search(7));
	}
	
	@Test
	
	public void DoubleSplit()
	{
		tree = new TwoThreeTree();
		tree.insert(5);
		tree.insert(3);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(10);
		tree.insert(11);
		tree.insert(12);
		tree.insert(5);
		tree.insert(12);
		
		String expected = "3";
		assertEquals(expected, tree.search(3));
		
		expected = "6";
		assertEquals(expected, tree.search(6));
		
		expected = "8";
		assertEquals(expected, tree.search(8));
		
		expected = "9 11";
		assertEquals(expected, tree.search(9));
		assertEquals(expected, tree.search(11));
		
		expected = "7";
		assertEquals(expected, tree.search(7));
		
		expected = "10";
		assertEquals(expected, tree.search(10));
		
		expected = "12";
		assertEquals(expected, tree.search(12));
		assertEquals(expected, tree.search(13));
	}	
}
