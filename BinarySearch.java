#find the median in the matrix
class Solution {
     int median(int matrix[][], int R, int C) {
        // code here
        // total elements
        int N = R*C;
        int medianIndex = N/2;
        int start = 1;
        int end = 2000;

        while (start<=end){
            int assumedMedian = start + (end-start)/2;
            // no of elements less than assumed median.
            // k -> lesserElements
            int lesserElements = findSmallerElements(matrix, assumedMedian);
            if(lesserElements <= medianIndex){
              start = assumedMedian+1;
            } else {
                end = assumedMedian-1;
            }
        }
        return start;

    }
    int findSmallerElements(int matrix[][], int assumedMedian){
        int noOfSmallerElements = 0;
        // traverse row by row
        for(int i=0;i<matrix.length;i++){
            // matrix[i] -> 0,1,2
            // apply binary search on matrix[i]
//            int arr[] = matrix[i];
            int start = 0;
            int end = matrix[i].length-1;
            while (start<=end){
                int mid = start + (end-start)/2;
                if(matrix[i][mid] <= assumedMedian){
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
            // start.
            noOfSmallerElements += start;
        }
        return noOfSmallerElements;
    }

}

// BST to balanced BST
class GfG {
    Node buildBalancedTree(Node root) {
        // Add your code here.
        List<Node> nodes = new ArrayList<>();

        inOrder(root, nodes);

        return constructBST(nodes, 0, nodes.size() - 1);
    }

    public void inOrder(Node root, List<Node> nodes) {
        if (root == null) {
            return;
        }
        inOrder(root.left, nodes);
        nodes.add(root);
        inOrder(root.right, nodes);
    }

    Node constructBST(List<Node> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        Node root = nodes.get(mid);
        root.left = constructBST(nodes, start, mid - 1);
        root.right = constructBST(nodes, mid + 1, end);
        return root;
    }
}

// Get the next node for every node
// eg. 
    //     10
    //    /  \
    //   8    12
    //  /
    // 3
// Output will be
3 -> 8 8 -> 10 10 -> 12 12 -> -1
// code 
     class Solution {
    Node prev;

    public void populateNext(Node root) {
        if (root == null) {
            return;
        }

        populateNext(root.right);

        root.next = prev;

        prev = root;

        populateNext(root.left);
    }
}

// Marging of Two arrays
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    List<Integer> list = new ArrayList<>();
    public List<Integer> merge(Node root1,Node root2){
        // Write your code here
        inOrder(root1);
        inOrder(root2);
        Collections.sort(list);
        return list;
    }
    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        list.add(root.data);
        inOrder(root.right);
    }
}
// replace every no
class Solution {
    class Node{
        int data;
        Node left;
        Node right;
        public Node(int value){
            this.data = value;
        }
    }
    public Node gr = null;
    
    public Node insert(int value, Node parent, Node current, boolean isLeft, Node greater){
        Node node = new Node(value);
        if(current == null){
            node = new Node(value);
            if(isLeft){
                parent.left = node;
            } else {
                parent.right = node;
            }
            gr = greater;
            return node;
        }
        if(current.data >= value){
            node = insert(value, current, current.left, true, current);
        } else {
            node = insert(value, current, current.right, false, greater);
        }
        return node;
    }
    
    public  ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Node[] nodear = new Node[n];
        Node root = new Node(arr[n-1]);
        nodear[0] = root;
        for(int i = n - 2; i >= 0; i--){
            insert(arr[i], root, root, true, null);
            nodear[i] = gr;
        }
        
        for(Node node : nodear){
            if(node == null){
                result.add(-1);
                continue;
            }
            result.add(node.data);
        }
        // result.add(-1);
        return result;
    }
}
// binary search tree Search in Rotated Sorted Array
public class Solution {

    public int binarySearch(int[] nums, int x, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid < 0 || mid >= nums.length) {
                return -1;
            }

            if (nums[mid] == x) {
                return mid;
            } else if (nums[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int findPivot(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid < high && nums[mid + 1] < nums[mid]) {
                return mid + 1;
            } else if (low < mid && nums[mid - 1] > nums[mid]) {
                return mid;
            } else if (nums[mid] <= nums[low]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        if (nums[0] <= target) {
            return binarySearch(nums, target, 0, pivot - 1);
        } else {
            return binarySearch(nums, target, pivot, nums.length - 1);
        }
    }
}
