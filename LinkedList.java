public class LinkedList {
	private Node start;
	private Node end;
	private LinkedList next;
	
	public LinkedList() {
		start = null;
		end = null;
		next = null;
	}
	
	public LinkedList(Node s, Node e) {
		start = s;
		end = e;
		next = null;
	}
	
	public void add(int x) {
		Node n = new Node(x);
		if(start == null) {
			start = n;
			end = n;
		}
		else {
			end.setNext(n);
			end = n;
		}
	}
	
	public Node getStart() {
		return start;
	}
	
	public void setNext(LinkedList n) {
		next = n;
	}
	
	public LinkedList getNext() {
		return next;
	}

}