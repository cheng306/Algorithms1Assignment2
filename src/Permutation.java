import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
	 public static void main(String[] args) {
		 int num = Integer.parseInt(args[0]);
		 In in = new In(args[2]);
		 RandomizedQueue<String> rq = new RandomizedQueue<String>();
		 while (in.hasNextChar()) {
			 //String s = in.readString();
			 //System.out.println(s);
			 rq.enqueue(in.readString());
		 }
		 for (int i = 0; i < num; i++) {
			 StdOut.println(rq.dequeue());
		 }
	 }
}
