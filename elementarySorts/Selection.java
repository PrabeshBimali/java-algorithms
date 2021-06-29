package elementarySorts;
import edu.princeton.cs.algs4.In;

public class Selection {
	private static boolean less(String v, String w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(String[] a, int i, int j) {
		String c = a[i]; a[i] = a[j]; a[j] = c;
	}
	
	public static void show(String[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]+ " ");
		}
	}
	
	public static boolean isSorted(String[] a) {
		for(int i=1; i<a.length; i++) {
			if(less(a[i], a[i-1])) return false;
		}
		
		return true;
	}
	
	public static void sort(String[] a) {
		int n = a.length;
		for(int i=0; i<n; i++) {
			int min = i;
			for(int j=i+1; j<n; j++) {
				if(less(a[j], a[min])) min=j;
			}
			exch(a, i, min);
		}
	}
	
	
	public static void main(String[] args){ 
		// Read strings from standard input, sort them, and print.
		//String[] a = In.readStrings();
		String[] a = {"one", "two", "three"};
 		sort(a);
		assert isSorted(a);
		show(a);
	}
}
