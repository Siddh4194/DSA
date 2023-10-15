# !st day challange
// level order traversal using the queue
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            
            ans.add(levelNodes);
        }
        
        return ans;
    }
}
// subtree
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        
        if (isIdentical(root, subRoot)) {
            return true;
        }
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        
        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }
}
// left view of the tree
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
    //   if (root == null) {
    //         return 1;
    //     }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();

                // For the first node at each level, add its value
                if (i == 0 && node != null) {
                    ans.add(node.data);
                }

                if (node != null && node.left != null) {
                    queue.add(node.left);
                }

                if (node != null && node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }
}

// right view of tree
class Solution{
    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node node) {
        //add code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        while(!que.isEmpty()){
            int squeue = que.size();
            for(int i = 0; i < squeue ; i++){
                Node temp = que.poll();
                if(i == squeue - 1 && temp != null){
                    ans.add(temp.data);
                }
                if(temp != null && temp.left != null){
                    que.add(temp.left);
                }
                if(temp != null && temp.right != null){
                    que.add(temp.right);
                }
            }
        }
        return ans;
    }
}
// tree zigzag traversal
#first approach
class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    Queue<Node> queue = new LinkedList<>();
	    int flag = 0;
	    int initial = 0;
	    queue.add(root);
	    queue.add(null);
	    while(!queue.isEmpty()){
	        Node temp = queue.remove();
	        if(temp == null){
	            if(queue.isEmpty()){
	                break;
	            }else{
	                queue.add(temp);
	                flag = flag == 0 ? 1 : 0;
	                initial = 0;
	                continue;
	            }
	        }
	        if(flag == 1){
	            ans.add(ans.size() - initial,temp.data);
	            initial++;
	        }
	        if(flag == 0){
	            ans.add(temp.data);
	        }
	        if(temp.left != null){
	            queue.add(temp.left);
	        }
	        if(temp.right != null){
	            queue.add(temp.right);
	        }
	    }
	    return ans;
	}
}
#2nd approach
class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    ArrayList<Integer> ans = new ArrayList<>();
	    ArrayList<Integer> temp = new ArrayList<>();
	    Queue<Integer> que = new ArrayList<>();
	    que.add(root);
	    int t = 0;
	    while(!que.isEmpty()){
	        int size = que.size();
	        for(int i = 0; i < size; i++){
	            Node node = que.poll();
	            temp.add(node.data);
	            if(node != null && node.left != null){
	                que.add(node.left);
	            }
	            if(node != null && node.right != null){
	                que.add(node.right);
	            }
	        }
	        if(t % 2 != 0){
	           Collections.reverse(temp);
	        }
	        ans.addAll(temp);
	        temp.clear();
	        t++;
	    }
	    return ans;
	}
}
// mirror element in tree using the target integer
class Solution {
    public Node mirror(Node root) {
        if(root == null){
            return null;
        }
        Node root1 = new Node(root.data);
        root1.right = mirror(root.left);
        root1.left = mirror(root.right);
        return root1;
    }
    public void helper(Node root, Node root1, int target , int[] d){
        if(root == null || root1 == null){
            return;
        }
        if(root.data == target){
            if(root1 == null){
                d[0] = -1;
            } else{
                d[0] = root1.data;
            }
        }
        helper(root.left, root1.left, target ,d);
        helper(root.right, root1.right, target ,d);
    }
    public int findMirror(Node root, int target) {
        Node root1 = mirror(root);
        int[] d = new int[1];
        d[0] = -1;
        helper(root,root1,target,d);
        return d[0];
    }
}
// leaf nodes level
class Solution
{
    ArrayList<Integer> ans = new ArrayList<>();
    boolean check(Node root)
    {
	// Your code here	
	checkH(root,0);
	for(int i = 1; i < ans.size(); i++){
	    if(ans.get(i-1) != ans.get(i)) {
	        return false;
	    }
	}
// 	System.out.println(ans);
	return true;
    }
    void checkH(Node root,int level){
        if(root.left == null && root.right == null){
            ans.add(level);
            return;
        }
        if(root.left != null){
            checkH(root.left,level+1);
        }
        if(root.right != null){
            checkH(root.right,level+1);
        }
    }
}
// binary tree balanced or not
class Tree
{
    
    //Function to check whether a binary tree is balanced or not.
    int Height(Node root){
        if(root == null){
            return 0;
        }
        int left = Height(root.left);
        int right = Height(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left,right) + 1;
    }
    boolean isBalanced(Node root)
    {
        return Height(root) != -1;
    }
}
// tree sum
class Solution{
    int calculate(Node root){
        if(root == null){
             return 0;
         }
         int original = root.data;
         int left = calculate(root.left);
         int right = calculate(root.right);
         root.data = left+right;
         return root.data + original;
    }
    public void toSumTree(Node root){
         //add code here.
         calculate(root);
    }
}
// isomorphic trees 
class Solution  
{ 
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node root1, Node root2)  
    { 
         // code here.
         if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.data != root2.data){
            return false;
        }
        // first check for the same position
        // other wise go to the diffrent positions
        return (isIsomorphic(  root1.left,   root2.left) && isIsomorphic(  root1.right,   root2.right))
        || (isIsomorphic(  root1.right,   root2.left) && isIsomorphic(  root1.left,   root2.right));
    }
    
}   
// same tree
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
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
// build tree from inorder and preorder arrays
//1st approach
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // Call the helper function to construct the tree
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        // Base cases
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                inIndex = i;
                break;
            }
        }

        root.left = buildTreeHelper(preorder, inorder, preStart + 1, inStart, inIndex - 1);
        root.right = buildTreeHelper(preorder, inorder, preStart + (inIndex - inStart) + 1, inIndex + 1, inEnd);

        return root;
    }
}

// 2nd approach
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = inorder.length;
        for(int i = 0; i < len; i++){
            map.put(inorder[i],i);
        }
        return buildTreeHelper(preorder,map,0,inorder.length - 1);
    }
    int preOrderIdx = 0;
    public TreeNode buildTreeHelper(int[] preorder,HashMap<Integer,Integer> map,int left,int right){
        if(left > right){
            return null;
        }
        int pval = preorder[preOrderIdx];
        TreeNode root = new TreeNode(pval);
        int inorderIdx = map.get(pval);
        preOrderIdx++;

        root.left = buildTreeHelper(preorder,map,left,inorderIdx - 1);
        root.right = buildTreeHelper(preorder,map,inorderIdx + 1,right);
        return root;
    }
}

// top view of a tree using the queue arraylist and the hashmap
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static Info{
        int hd;
        Node node;
        public Info(int hd,Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArayList<Integer> ans = new ArrayList<>();
        Queue<Info> queue = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        queue.add(new Info(0,root));
        queue.add(null);
        
        int min = 0, max = 0;
        while(!queue.isEmpty()){
            Node curr = queue.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                } else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }
                if(curr.node.left != null){
                    queue.add(new Info(curr.hd - 1,curr.node.left));
                    min = Math.min(min,curr.hd - 1);
                }
                if(curr.node.right != null){
                    queue.add(new Info(curr.hd + 1,curr.node.right));
                    min = Math.max(max,curr.hd + 1);
                }
            }
        }
        for(int i = min; i <= max; i++){
            ans.add(map.get(i).data);
        }
        return ans;
    }
}
// bottom view of the binary tree
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    static class Pair{
        int data;
        int vd;
        public Pair(int vd,int data){
            this.data = data;
            this.vd = vd;
        }
    }
    void helper(Node root,int hd,int vd,TreeMap<Integer,Pair> map){
        if(root == null){
            return;
        }
        helper(root.left,hd-1,vd+1,map);
        helper(root.right,hd+1,vd+1,map);
        if(map.containsKey(hd)){
            Pair p = map.get(hd);
            if(p.vd <= vd){
                map.put(hd,new Pair(vd,root.data));
            }
        } else{
                map.put(hd,new Pair(vd,root.data));
        }
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer>  ans = new ArrayList<>();
        TreeMap<Integer,Pair> map = new TreeMap<>();
        helper(root,0,0,map);
        map.forEach((el,value)->{
            ans.add(value.data);
        });
        return ans;
    }
} 
