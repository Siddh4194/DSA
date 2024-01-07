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

// merge two sorted lists
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            } else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1 != null){
            current.next = list1;
        } else{
            current.next = list2;
        }
        return dummy.next;
    }
}

// detect cycle in the linkedlist
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false; //there is no cycle if the two values only present in the list
        }
        ListNode fastStep = head;
        ListNode slowStep = head;

        while(fastStep != null && fastStep.next != null){
            fastStep = fastStep.next.next;
            slowStep = slowStep.next;
            if(fastStep == slowStep){
                return true;
            }
        }
        return false;
    }
}

// reorder the list
// optimized way learn from the disussion
class Solution {
    public void reorderList(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode temp = head;
        int n=0;
        while(temp!=null){
          map.put(n,temp);
          temp=temp.next;
          n++;
        }
        ListNode res=null;
        for(int i=0,j=n-1;i<=j;i++,j--){
          head = map.get(i);
          if(res!=null) res.next = head;          
          res = map.get(j);
          if(head==res)
            break;
          head.next=res;
        }
        res.next=null;
        return;
    }
}
// own way to solve the problem
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode middle = findMiddle(head);

        ListNode reversedSecondHalf = reverseList(middle.next);
        middle.next = null;

        mergeLists(head, reversedSecondHalf);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private void mergeLists(ListNode list1, ListNode list2) {
        while (list2 != null) {
            ListNode next1 = list1.next;
            ListNode next2 = list2.next;

            list1.next = list2;
            list2.next = next1;

            list1 = next1;
            list2 = next2;
        }
    }
}

// tree 

// tree maximum height
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
          return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int maxheight = Math.max(leftHeight,rightHeight) + 1;

        return maxheight;
    }
}

// check for the same tree
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if(p == null && q == null){
        return true;
      }
      if(p == null || q == null){
        return false;
      }
      if(p.val != q.val){
        return false;
      }
      return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
