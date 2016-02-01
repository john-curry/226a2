import java.util.*;
import java.lang.Math;
class MinMax {
	private static class Pair {
		int alpha;   // the smaller one 
		int omega; // the bigger one 
		Pair ( int a, int o ) { alpha = a; omega = o; }
	}
	
	public static Pair mmA(int lb, int ub, int[] a ) {
		if (ub - lb == 1) {
			if (a[ub] < a[lb]) {
				return new Pair(a[ub], a[lb]);
			} else {
				return new Pair(a[lb], a[ub]);
			}
		}
		else {
			int pivot = Math.floor(ub - lb / 2);
			Pair lbp = mmA(lb, pivot, a);
			Pair ubp = mmA(pivot, ub, a);
			int lower = lbp.alpha < ubp.alpha ? lbp.alpha : ubp.alpha;
		}
		
	}
	
	public static Pair mmB(int lb, int ub, int[] a) {
	
		return null;
	}
	
	public static void main(String[] args) {
		int[] a = {  1, 2, 4, 8, 50, 32 };
		
		Pair one = mmA(0, a.length - 1, a);
		Pair two = mmB(0, a.length - 1, a);
		
		System.out.println("Perhaps implement everything kay?");
	}
}
	