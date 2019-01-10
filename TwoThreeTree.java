public class TwoThreeTree 
{	
	private Node root;
	
	public TwoThreeTree()
	{
		root = new Node();
	}
	
	public String search(int x)
	{
		Node n = root.find(x);
		
		return n.createString();
	}
	
	public boolean insert(int x)
	{
		Node n = root.find(x);
//			
//		I've already checked to see if it's a duplicate, feels silly to do it 
//		twice
		if(!n.duplicate(x))
		{
			n.addKey(x);
			return true;
		}
			
		return false;
	}
	
	private class Node
	{	
		int keys[];
		int numKeys, numChildren; 
		Node children[], parent;
		
		public Node()
		{
			keys = new int[3];
			children = new Node[4];
		}
		
		public Node(int x, Node p)
		{
			keys = new int[3];
			children = new Node[4];
			keys[0] = x;
			numKeys++;
			parent = p;
		}
		
		public Node find(int x)
		{
//			is there a clever way for me to differentiate the return value of a
//			leaf node and a node with duplicate key value? Store a boolean?
			if(duplicate(x) || leafNode())
				return this;
			
			Node next = children[compareKeys(x)];
			
			return next.find(x);
		}
		
		private boolean duplicate(int key)
		{
			for(int i=0; i<numKeys; i++)
			{
				if(key == keys[i])
					return true;
			}
			return false;
		}
		
		private boolean leafNode()
		{
			return numChildren == 0;
		}
		
		private int compareKeys(int key)
		{
			int i;
			for(i=0; i<numKeys; i++)
			{
				if(key < keys[i])
					return i;
			}
			
			return i;
		}
		
		public void addKey(int key)
		{
			int index = compareKeys(key);
			moveKeys(index);
			keys[index] = key;
			numKeys++;
							
			if(numKeys == keys.length)
				split();
		}
		
		private void moveKeys(int index)
		{
			for(int i=numKeys; i>index; i--)
			{
				keys[i] = keys[i-1];
			}
		}
		
		private void split()
		{	
			int median = keys[1];
			Node right = new Node(keys[2], parent);
			numKeys = 1;
			
			if(numChildren == 4)
				right = splitNode();
			
			promote(median, right);
		}
		
		private void promote(int key, Node n)
		{
			if(parent == null)
			{
				parent = new Node();
				parent.addChild(this);
				root = parent;
			}
			
			parent.addChild(n);
			parent.addKey(key);
		}
		
		private void addChild(Node n)
		{
			n.parent = this;
			int index = getIndex(n);
			moveChildren(index);
			children[index] = n;
			numChildren++;
		}
		
		private int getIndex(Node n)
		{
			int i;
			for(i=0; i<numChildren; i++)
			{
				if(n.keys[0] < children[i].keys[0])
					return i;
			}
			
			return i;
		}
		
		private void moveChildren(int index)
		{
			for(int i=numChildren; i>index; i--)
			{
				children[i] = children[i-1];
			}
		}
		
		private Node splitNode()
		{
			Node right = new Node(keys[2], parent);
			
			for(int i=numChildren/2; i<numChildren; i++)
			{
				right.addChild(children[i]);
				children[i] = null;
			}
			
			numChildren = numChildren/2;
			
			return right;
		}

		public String createString()
		{	
//			return a string with smallest first, largest second
//			if only one integer, return the smallest			
			String s = keys[0] + "";
			
			if(numKeys == 2)
			{
				s += " " + keys[1];
			}
			
			return s;
		}
		
//		private void printKeys()
//		{
//			for(int i=0; i<numKeys; i++)
//			{
//				System.out.print(keys[i] + " ");
//			}
//			
//			System.out.println();
//		}
//		
//		private void printNode()
//		{
//			System.out.print("Keys: ");
//			printKeys();
//			System.out.println("numKeys: " + numKeys);
//			System.out.println("numChildren: " + numChildren);
//			System.out.println();
//		}
	}
}
