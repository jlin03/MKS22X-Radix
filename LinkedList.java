public class LinkedList {
	private Node start;
	private Node end;

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

	public Node getStart() {
		return start;
	}

	public Node getEnd() {
		return end;
	}

	public String toString() {
		if(start == null) {
			return "[]";
		}
		String out = "[ ";
		Node current = start;
		while(!current.isEnd()) {
			out += current.getVal() + " ";
			current = current.getNext();
		}
		if(current == end) {
			out += current.getVal() + " ";
		}
		out += "]";
		return out;
	}

	public static LinkedList merge(LinkedList one, LinkedList two) {
		if(one.getStart() == null) {
			return two;
		}
		if(two.getStart() == null) {
			return one;
		}
		one.getEnd().setNext(two.getStart());
		return new LinkedList(one.getStart(),two.getEnd());
	}


}
