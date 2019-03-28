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
				freq[(current/Math.pow(10,step-1)) % 10]
			}
			
			
		}
		
		
	}
	
	
	
	
	
	
	
	
}