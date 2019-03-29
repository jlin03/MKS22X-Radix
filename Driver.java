import java.util.*;
public class Driver {
  public static void main(String[] args) {
    int size = Integer.parseInt(args[0]);
    int range = Integer.parseInt(args[1]);
    Random r = new Random((int)System.currentTimeMillis());
    int[] ary = new int[size];
    for(int i = 0; i < ary.length; i++) {
      ary[i] = r.nextInt();
    }
    

  }


}
