class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> lists = new ArrayList<>();
      Set<List<Integer>> resultSet = new HashSet<>();
      Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
          if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
          }
          int target = -nums[i];
          int left = i + 1;
          int right = nums.length -1;
          while(left < right){
            int currentSum = nums[left] + nums[right];
            if(currentSum == target){
              lists.add(Arrays.asList(nums[i],nums[left],nums[right]));

              while(left < right && nums[left] == nums[left +1]){
                left++;
              }
              while(left < right && nums[right] == nums[right - 1]){
                right--;
              }
              left++;
              right--;
            } else if(currentSum < target){
              left++;
            } else {
              right--;
            }
          }
        }
        return lists;
    }
}
// find the largest water area
class Solution {// time complexity is O(n) and space complexity is O(1)  which is optimized answer
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0,right = height.length - 1;
        while(left < right){
          int currentArea = (right - left) * (height[left] < height[right] ? height[left] : height[right]);
          if(currentArea > maxArea){
            maxArea = currentArea;
          }
          if(height[left] > height[right]){
            right--;
          } else{
            left++;
          }
        }
        return maxArea;
    }
}
