public class Node {
	private int val;
	private Node next;
	private boolean end;
	
	public Node(int x) {
		val = x;
		end = true;
		next = null;
	}
	
	public int getVal() {
		return val;
	}
	
	public void setNext(Node n) {
		next = n;
		end = false;
	}
	
	public Node getNext() {
		return next;
	}
	
	public boolean isEnd() {
		return end;
	}

}