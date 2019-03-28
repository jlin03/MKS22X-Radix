public class Radix {
	
	public static void sort(int[] data) {
		LinkedList[] freq = new LinkedList[10];
		LinkedList l =  new LinkedList();
		for(int i = 0; i < data.length; i++) {
			l.add(data[i]);
		}
		for(int i = 0; i < freq.length; i++) {
			freq[i] = new LinkedList();
		}
		boolean passAgain = true;
		int step = 1;
		while(passAgain) {
			passAgain = false;
			Node current = l.getStart();
			for(int i = 0; i < data.length; i++) {
				if(current/Math.pow(10,step) != 0) {
					passAgain = true;
				}
				freq[(current/Math.pow(10,step-1)) % 10].add(current);
				current = current.getNext();
			}
			for(int i = 0; i < freq.length-1; i++) {
				freq[i+1] = LinkedList.merge(freq[i],freq[i+1]);
			}
			l = freq[9];
		}
		for(int i = 0; i < data.length; i++) {
			Node current = l.getStart();
			data[i] = current.getVal();
			current = current.getNext();
		}
	}
	
	public 
	
	
	
	
	
	
	
	
}