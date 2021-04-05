package backtracking;

import java.util.ArrayList;
import java.util.List;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同
//
// Related Topics 位运算 数组 回溯算法
// 👍 981 👎 0
public class SubSet {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = new SubSet().subsets(nums);
        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
//        helper(nums, 0, new ArrayList<Integer>(), res);
        backtrack(nums, new ArrayList<Integer>(), res, 0);
        return res;
    }

    private void helper(int[] nums, int index, List<Integer> states, List<List<Integer>> res) {
        // terminator
        if (index == nums.length) {
            // If add states to res list, that is add the reference of states.
            // states will be modify at other recursive level.
            res.add(new ArrayList<Integer>(states));
            return;
        }
        // process current logic
        helper(nums, index + 1, states, res); // not pick the number at this index

        states.add(nums[index]); // pick the number at this index
        // drill down
        helper(nums, index + 1, states, res);
        // reverse states
        states.remove(states.size() - 1);
    }

    private void backtrack(int[] nums, List<Integer> states, List<List<Integer>> res, int start) {
        res.add(new ArrayList<>(states));

        // process current logic
        for (int i = start; i < nums.length; i++) {
            states.add(nums[i]);
            // drill down
            backtrack(nums, states, res, i + 1);
            // reverse states
            states.remove(states.size() - 1);
        }
    }
}
