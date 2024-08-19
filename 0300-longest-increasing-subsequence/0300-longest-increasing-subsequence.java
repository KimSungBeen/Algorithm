class Solution {
    public int lengthOfLIS(int[] nums) {
        final int[] dpArr = new int[nums.length];
        dpArr[0] = 1;
        int maxCount = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dpArr[i] = Math.max(dpArr[i], Math.max(dpArr[j], 1) + 1);

                    maxCount = Math.max(dpArr[i], maxCount);
                } else if (nums[i] < nums[j]) {
                    dpArr[i] = dpArr[i] > 0 ? dpArr[i] : 1;
                }
            }
        }

        return maxCount;
    }
}
