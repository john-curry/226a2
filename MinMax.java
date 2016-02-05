import java.util.*;
import java.lang.Math;
class MinMax {
  public static int cmp = 0;	

  public static Pair mmThree(int a, int b, int c) {
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
      Pair lbp = mmA(lb, pivot - 1 + lb, a);
      Pair ubp = mmA(lb + pivot, ub, a);


      cmp++;
			int lower = lbp.alpha < ubp.alpha ? lbp.alpha : ubp.alpha;
      cmp++;
			int upper = lbp.omega > ubp.omega ? lbp.omega : ubp.omega;

      assert lower <= upper : "Lower is greater than upper";

      Pair p = new Pair(lower, upper);
      return p;
		}
		
	}
	
	public static Pair mmB(int lb, int ub, int[] a) {
    assert lb <= ub : "Lower bound is less than upper bound";
    if (ub == lb) {
      return new Pair(a[ub], a[ub]);
    }
		else if (ub - lb == 1) {
      cmp++;
			if (a[ub] < a[lb]) {
				return new Pair(a[ub], a[lb]);
			} else {
				return new Pair(a[lb], a[ub]);
			}
		}
    else if (ub - lb == 2) {
      Pair t = mmThree(a[lb], a[lb+1], a[lb+2]);
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
      Pair lbp = mmB(lb, pivot - 1 + lb, a);
      Pair ubp = mmB(lb + pivot, ub, a);


      cmp++;
			int lower = lbp.alpha < ubp.alpha ? lbp.alpha : ubp.alpha;
      cmp++;
			int upper = lbp.omega > ubp.omega ? lbp.omega : ubp.omega;

      assert lower <= upper : "Lower is greater than upper";

      Pair p = new Pair(lower, upper);
      return p;
		}
	}
	
	public static void main(String[] args) {
    return;
  }
}
	
