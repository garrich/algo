package arrays;

import java.util.HashSet;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0, right = 0;
        int res = 0;
        int current_sum = 0;
        var set = new HashSet<Integer>();

        while (right < nums.length) {
            while (left < nums.length) {
                var elem = nums[left];
                current_sum+=elem;
                if(set.contains(elem)){
                    current_sum-=elem;
                    break;
                }else {
                    set.add(elem);
                }
                left++;
            }
            res = Math.max(res, current_sum);
            current_sum-=nums[right];
            set.remove(nums[right]);
            right++;
        }
        return res;
    }

    private boolean isUniqueSubArray(int[] nums, int right, int left) {
        var set = new HashSet<Integer>();
        for (int i = right; i < left; i++) {
            if (set.contains(nums[i]))
                return false;
            set.add(nums[i]);
        }
        return true;
    }

    private int sum(int left, int right, int[] nums) {
        int sum = 0;
        for (int i = right; i < left; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
