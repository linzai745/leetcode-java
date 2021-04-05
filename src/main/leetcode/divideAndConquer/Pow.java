package divideAndConquer;
//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
//
//
//
// 示例 1：
//
//
//输入：x = 2.00000, n = 10
//输出：1024.00000
//
//
// 示例 2：
//
//
//输入：x = 2.10000, n = 3
//输出：9.26100
//
//
// 示例 3：
//
//
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
//
//
//
//
// 提示：
//
//
// -100.0 < x < 100.0
// -231 <= n <= 231-1
// -104 <= xn <= 104
//
// Related Topics 数学 二分查找
// 👍 574 👎 0
public class Pow {
    public static void main(String[] args) {
        double result = new Pow().myPow(2, -2147483648);
        System.out.println(result);
    }
    /**
     *  D&C
     *  1. terminator
     *      if: n == 0 return 1
     *  2. process current logic (split your big problem)
     *      x^10 = x^5 * x^5
     *      subProblem: n/2
     *  3. drill down (process sub-problem) & merge (sub-result)
     *      process subProblem: subResult = myPow(x, n / 2)
     *      merge:
     *          n is odd: subResult * subResult * x
     *          n is even: subResult * subResult
     *  4. reverse states
     *
     */
    public double myPow(double x, long n) {
        //terminator
        if (n == 0) return 1.0;

        // process current logic (split big problem)
        double subResult = n < 0 ? myPow(x, (-n) >> 1) : myPow(x, n >> 1);

        // drill down (process subProblem) & merge (subResult)
        double result = (n & 1) == 1 ? subResult * subResult * x : subResult * subResult;

        return n < 0 ? 1.0 / result : result;
    }
}
