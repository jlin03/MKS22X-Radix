public class LinkedList {
	private Node start;
	private Node end;
	private LinkedList next;
	
	public LinkedList() {
		start = null;
		end = null;
	}
	
	public LinkedList(Node s, Node e) {
		start = s;
		end = e;
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
	
	
	
	
	
	
	
}