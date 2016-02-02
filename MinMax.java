import java.util.*;
import java.lang.Math;
class MinMax {
	private static class Pair {
		int alpha;   // the smaller one 
		int omega; // the bigger one 
		Pair ( int a, int o ) { alpha = a; omega = o; }
    public String toString() {
      return "("+this.alpha+","+this.omega+")";
    }
    public boolean equals(Object o) {
      if (!(o instanceof Pair)) return false;
      Pair p = (Pair)o;
      return (p.omega == this.omega) && (p.alpha == this.alpha);
    }
	}
  public static int cmp = 0;	

  public static Pair mmThree(int a, int b, int c) {
    System.out.println("Comparing 3 values: " + a + " " + b + " " + c);
    cmp++;
    if (a < b) {
      cmp++;
      if (c > b) {
        return new Pair(a, c);
      } else {
        cmp++;
        if (a < c) {
          return new Pair(a, b);
        } else {
          return new Pair(c, b);
        }
      }
    } else {
      cmp++;
      if (c < b) {
        return new Pair(c, a);
      } else {
        cmp++;
        if (c > a) {
          return new Pair(b, c);
        } else {
          return new Pair(b, a);
        }
      }
    }
  }

	public static Pair mmA(int lb, int ub, int[] a ) {
    assert lb <= ub : "Lower bound is less than upper bound";
    if (ub == lb) {
      return new Pair(a[ub], a[ub]);
    }
		if (ub - lb == 1) {
      System.out.println("Upper bound: " + ub + " lower bound: " + lb);
      cmp++;
			if (a[ub] < a[lb]) {
				return new Pair(a[ub], a[lb]);
			} else {
				return new Pair(a[lb], a[ub]);
			}
		}
		else {
      int split = ub - lb;
      int pivot;
      if (split % 2 == 0) {
        pivot = split / 2;
      } else {
        pivot = (split + 1) / 2;
      }
      System.out.println("Lower Pair upper bound: " + ub + " lower bound: " + lb + " pivot: " + pivot);
      Pair lbp = mmA(lb, pivot - 1 + lb, a);
      System.out.println("Upper Pair upper bound: " + ub + " lower bound: " + (lb + pivot) + " pivot: " + pivot);
      Pair ubp = mmA(lb + pivot, ub, a);

      System.out.println("Subpairs: " + lbp.toString() + ubp.toString());

      cmp++;
			int lower = lbp.alpha < ubp.alpha ? lbp.alpha : ubp.alpha;
      cmp++;
			int upper = lbp.omega > ubp.omega ? lbp.omega : ubp.omega;

      assert lower <= upper : "Lower is greater than upper";

      Pair p = new Pair(lower, upper);
      System.out.println("Better pair: " + p.toString());
      return p;
		}
		
	}
	
	public static Pair mmB(int lb, int ub, int[] a) {
    assert lb <= ub : "Lower bound is less than upper bound";
    if (ub == lb) {
      return new Pair(a[ub], a[ub]);
    }
		else if (ub - lb == 1) {
      System.out.println("Upper bound: " + ub + " lower bound: " + lb);
      cmp++;
			if (a[ub] < a[lb]) {
				return new Pair(a[ub], a[lb]);
			} else {
				return new Pair(a[lb], a[ub]);
			}
		}
    else if (ub - lb == 2) {
      Pair t = mmThree(a[lb], a[lb+1], a[lb+2]);
      System.out.println("Three pair compare: " + t.toString());
      return t;
    } 
      
		else {
      int split = ub - lb;
      int pivot;
      if (split % 2 == 0) {
        pivot = split / 2;
      } else {
        pivot = (split + 1) / 2;
      }
      System.out.println("Lower Pair upper bound: " + ub + " lower bound: " + lb + " pivot: " + pivot);
      Pair lbp = mmB(lb, pivot - 1 + lb, a);
      System.out.println("Upper Pair upper bound: " + ub + " lower bound: " + (lb + pivot) + " pivot: " + pivot);
      Pair ubp = mmB(lb + pivot, ub, a);

      System.out.println("Subpairs: " + lbp.toString() + ubp.toString());

      cmp++;
			int lower = lbp.alpha < ubp.alpha ? lbp.alpha : ubp.alpha;
      cmp++;
			int upper = lbp.omega > ubp.omega ? lbp.omega : ubp.omega;

      assert lower <= upper : "Lower is greater than upper";

      Pair p = new Pair(lower, upper);
      System.out.println("Better pair: " + p.toString());
      return p;
		}
	}
	
	public static void main(String[] args) {
		int[] a = { 10, 4, 0, 5, 265, 1000, 1, 2, 4, 8, 50, 32 , 100, 43, 54, 103, 5, 2, 1 , 99, 65, 432, 1, 99, 43};
    System.out.println(Arrays.toString(a));
	  int n = a.length;
    Pair exp = new Pair(0, 1000);

    double optimal = ((double)(3 * n) / 2.0) - 2.0;
		Pair one = mmA(0, a.length - 1, a);
    
    System.out.println("Found min/max mmA in " + cmp + " compares. Should have gotten: " + optimal);
    System.out.println("Are they equal? " + exp.equals(one));

    cmp = 0;
		Pair two = mmB(0, a.length - 1, a);

    System.out.println("Found min/max mmB in " + cmp + " compares. Should have gotten: " + optimal);
    System.out.println("Are they equal? " + exp.equals(two));
		
		System.out.println("");
	}
}
	
