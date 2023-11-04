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
