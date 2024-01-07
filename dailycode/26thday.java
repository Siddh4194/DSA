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
// bitwise operation addition
class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
          int carry = a & b;
          a = a ^ b;
          b = carry << 1;
        }
        return a;
    }
}

// give back the no of bits for the index of array return the array
class Solution {
  public static int noOfBits(int n){
    int count = 0;
    while(n!=0){
      // check the rightmost bit if there is 1 then increase the count
      count += n & 1;
      n >>>= 1;
    }
    return count;
  }
    public int[] countBits(int n) {
      int ans[] = new int[n+1];
      for(int i = 0; i <= n; i++){
        // pass every no to count the no of bits in that numbers binary bit representation
        ans[i] = noOfBits(i);
      }
      return ans;
    }
}

// reversing the bits in the no public class Solution {
// you need treat n as an unsigned value
public int reverseBits(int n) {
int reversed = 0;
for(int i = 0; i < 32; i++){
  // if the binary no is 111 we move the no by one 110 to add new bit at the 0 bit
  reversed <<= 1;

  // now at the rightmost element of n and the reversed rightmost element is added
  reversed |= n & 1;

  // now the n no is shifted to the right to get the new no
  n >>>= 1;
}
return reversed;
}
}

// linkedList
// reverse a linkedList
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
          ListNode temp = head.next;
          head.next = prev;
          prev = head;
          head = temp;
        }
        // prev because the last node is saved in the prev
        return prev;
    }
}
