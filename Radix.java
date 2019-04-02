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
		int max = 0;
		for(int i = 0; i < data.length; i++) {
			if((int)Math.log10(data[i]) + 1 > max) {
				max = (int)Math.log10(data[i]) + 1;
			}
		}

		int step = 1;
		while(step <= max) {
			Node current = l.getStart();
			for(int i = 0; i < data.length; i++) {
				int index = Math.abs((current.getVal()/(int)Math.pow(10,step-1)) % 10);
				if(current.getVal() < 0) {
					freq[9-index].add(current.getVal());
				}
				else {
					freq[10+index].add(current.getVal());
				}
				current = current.getNext();
			}
			l = new LinkedList();
			for(int i = 0; i < freq.length; i++) {
				if(freq[i].getStart() != null) {
					l = LinkedList.merge(l,freq[i]);
				}
			}
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
