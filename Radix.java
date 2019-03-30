import java.util.*;
public class Radix {

	public static void sort(int[] data) {
		LinkedList[] freq = new LinkedList[10];
		LinkedList[] negFreq = new LinkedList[10];
		LinkedList l =  new LinkedList();
		for(int i = 0; i < data.length; i++) {
			l.add(data[i]);
		}
		for(int i = 0; i < freq.length; i++) {
			freq[i] = new LinkedList();
			negFreq[i] = new LinkedList();
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
				if(current.getVal() < 0) {
					negFreq[index*-1].add(current.getVal());
				}
				else {
					freq[index].add(current.getVal());
				}
				current = current.getNext();
			}
			for(int i = -9; i < freq.length-1; i++) {
				if(i < 0) {
					if(negFreq[i*-1].getStart() != null && negFreq[i*-1-1].getStart() != null) {
						negFreq[i*-1-1] = LinkedList.merge(negFreq[i*-1],negFreq[i*-1-1]);
						negFreq[i*-1] = null;
					}
					else if(negFreq[i*-1].getStart() != null && negFreq[i*-1-1].getStart() == null) {
						negFreq[i*-1-1] = negFreq[i*-1];
						negFreq[i*-1] = null;
					}
				}
				if(i == 0 && negFreq[i].getStart() != null) {
					if(freq[i].getStart() != null) {
						freq[0] = LinkedList.merge(negFreq[0],freq[0]);
					}
					else {
						freq[0] = negFreq[0];
					}
					negFreq[0] = null;
				}
				if(i >= 0) {
					if(freq[i].getStart() != null && freq[i+1].getStart() != null) {
						freq[i+1] = LinkedList.merge(freq[i],freq[i+1]);
						freq[i] = null;
					}
					else if(freq[i].getStart() != null && freq[i+1].getStart() == null) {
						freq[i+1] = freq[i];
						freq[i] = null;
					}
				}
			}
			l = freq[9];
			for(int i = 0; i < freq.length; i++) {
				freq[i] = new LinkedList();
				negFreq[i] = new LinkedList();
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
