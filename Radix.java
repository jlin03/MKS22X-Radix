import java.util.*;
public class Radix {

	public static void radixsort(int[] data) {
		LinkedList[] freq = new LinkedList[20];
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
				if(current.getVal()/(int)Math.pow(10,step) != 0) {
					passAgain = true;
				}
				int index = Math.abs((current.getVal()/(int)Math.pow(10,step-1)) % 10);
				if(current.getVal() < 0) {
					freq[9-index].add(current.getVal());
				}
				else {
					freq[10+index].add(current.getVal());
				}
				current = current.getNext();
			}
			for(int i = 0; i < freq.length-1; i++) {
				if(freq[i].getStart() != null && freq[i+1].getStart() != null) {
					freq[i+1] = LinkedList.merge(freq[i],freq[i+1]);
					freq[i] = null;
				}
				else if(freq[i].getStart() != null && freq[i+1].getStart() == null) {
					freq[i+1] = freq[i];
					freq[i] = null;
				}
			}
			l = freq[19];
			for(int i = 0; i < freq.length; i++) {
				freq[i] = new LinkedList();
			}
			step++;
		}
		Node current = l.getStart();
		for(int i = 0; i < data.length; i++) {
			data[i] = current.getVal();
			current = current.getNext();
		}
	}



}
