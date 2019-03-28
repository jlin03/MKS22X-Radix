import java.util.*;
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
				if(current.getVal()/(int)Math.pow(10,step) != 0) {
					passAgain = true;
				}
				int index = (current.getVal()/(int)Math.pow(10,step-1)) % 10;
				freq[index].add(current.getVal());
				current = current.getNext();
			}
			for(int i = 0; i < freq.length-1; i++) {
				if(freq[i].getStart() != null && freq[i+1].getStart() != null) {
					freq[i+1] = LinkedList.merge(freq[i],freq[i+1]);
				}
				if(freq[i].getStart() != null && freq[i+1].getStart() == null) {
					freq[i+1] = freq[i];
				}
			}
			l = freq[9];
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
	
	public static void main(String[] args) {
		int[] test = {43,5,4,6,1,9,42,5,42,7,52,624,62,1,434,5713,5431,6,31,7};
		sort(test);
		System.out.println(Arrays.toString(test));
		
		
	}
	
	
	
	
	
	
	
	
}