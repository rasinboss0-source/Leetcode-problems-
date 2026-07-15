class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (nums[mid] == target) {
                return mid;              // found!
            } else if (nums[mid] < target) {
                low = mid + 1;            // right side paaru
            } else {
                high = mid - 1;           // left side paaru
            }
        }
        
        return low;   // idhu thaan correct insert position
    }
}
