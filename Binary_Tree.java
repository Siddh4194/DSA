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


// the border of the binarytree
class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> traversal = new ArrayList<>();
	    if(node.left == null && node.right == null){
	        traversal.add(node.data);
	        return traversal;
	    }
	    traversal.add(node.data);
	   // left
	   leftView(node.left,traversal);
	   //leaf nodes
	   leafView(node,traversal);
	   //right
	   rightView(node.right,traversal);
	   return traversal;
	}
	void leftView(Node node, ArrayList<Integer> traversal){
	    if(node == null || (node.left == null && node.right == null)){
	        return;
	    }
	    traversal.add(node.data);
	    if(node.left!=null){
	        leftView(node.left,traversal);
	    } else if(node.right!=null){
	        leftView(node.right,traversal);
	    }
	}
	void rightView(Node node, ArrayList<Integer> traversal){
	    if(node == null || (node.left == null && node.right == null)){
	        return;
	    }
	    if(node.right!=null){
	        rightView(node.right,traversal);
	    } else if(node.left!=null){
	        rightView(node.left,traversal);
	    }
	    traversal.add(node.data);
	}
	void leafView(Node node, ArrayList<Integer> traversal){
	    if(node == null){
	        return;
	    }
	    if(node.left == null && node.right == null){
	        traversal.add(node.data);
	        return;
	    }
	    leafView(node.left,traversal);
	    leafView(node.right,traversal);
	}
}


// create a binary tree using the string
Solution {
    // public static Node preorder(Node root){
    //     if(root == null){
    //         return null;
    //     }
    //     Node node = new Node(root.data);
    //     node.left = preorder(root.left);
    //     preorder(root.right);
    //     return node;
    // }
    public static Node structureTree(String s){
      if (s.isEmpty()) {
            return null;
        }
        int firstParen = s.indexOf("(");
        int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
        Node root = new Node(val);
        if (firstParen != -1) {
            int start = firstParen, count = 0;
            for (int i = start; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    count++;
                } else if (s.charAt(i) == ')') {
                    count--;
                }
                if (count == 0 && start == firstParen) {
                    root.left = structureTree(s.substring(start + 1, i));
                    start = i + 1;
                } else if (count == 0) {
                    root.right = structureTree(s.substring(start + 1, i));
                }
            }
        }
        return root;
    }

    public static Node treeFromString(String s) {
        if(s == ""){
            return null;
        }
        // code here
        Node  root = structureTree(s);
        // Node node = preorder(root);
        return root;
    }
}
        
//  binary tree to the binary search tree
class Solution {
    public static int minSwaps(int n, int[] A) {
        ArrayList<Integer> ar = new ArrayList<>();
        inOrder(ar,A,0);
        return findAns(ar);
    }
    
    public static int findAns(ArrayList<Integer> ar) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int copyArr[] = new int[ar.size()];
        int temp[] = new int[ar.size()];
        for(int i = 0; i < temp.length; i++){
            temp[i] = ar.get(i);
        }
        Arrays.sort(temp);
        for(int i = 0; i < temp.length; i++){
            map.put(temp[i],i);
        }
        for(int i = 0; i < temp.length; i++){
            copyArr[i] = ar.get(i);
        }
        int count = 0;
        for(int i = 0; i < temp.length; i++){
            while(map.get(copyArr[i]) != i){
                count++;
                swaping(copyArr,i,map.get(copyArr[i]));
            }
        }
        return count;
    }
    
    public static void swaping(int[] A, int i, Integer integer){
        int temp = A[i];
        A[i] = A[integer];
        A[integer] = temp;
    }
    public static void inOrder(ArrayList<Integer> ar,int[] A,int i){
        if(i >= A.length){
            return;
        }
        inOrder(ar,A,2*i+1);
        ar.add(A[i]);
        inOrder(ar,A,2*i+2);
    }
}

// detect cycle in the graph

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean hasCycle(ArrayList<ArrayList<Integer>> adj,int src,boolean[] visited) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(src);
        
        while(dq.size() > 0){
            int rem = dq.remove();
            if(visited[rem]){
                return true;
            }
            visited[rem] = true;
            
            for(Integer nbr: adj.get(rem)){
                if(!visited[nbr]){
                    dq.add(nbr);
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                boolean cycle = hasCycle(adj,i,visited);
                if(cycle){
                    return true;
                }
            }
        }
        return false;
    }
}
// find the min distance between the nodes in the binary tree
class GfG {
    Node LCA(Node root,int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node la = LCA(root.left, n1 , n2);
        Node ra = LCA(root.right, n1 , n2);
        if(la == null){
            return ra;
        } else if(ra == null){
            return la;
        }
        return root;
    }
    int distance(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int ld = distance(root.left,n);
        int rd = distance(root.right,n);
        if(ld == -1 && rd == -1){
            return -1;
        } else if(ld == -1){
            return rd+1;
        }
        return ld+1;
    }
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca = LCA(root,a,b);
        int h1 = distance(lca,a);
        int h2 = distance(lca,b);
        return h1 + h2;
    }
}
// duplicates subtree in the bt
class Solution{
    Map<String,Integer> map = new HashMap<>();
    List<Node> result = new ArrayList<>();
    public String helper(Node root){
        if(root == null) return "";
        String left = helper(root.left);
        String right = helper(root.right);
        String curr = root.data +" "+left+" "+right;
        if(map.getOrDefault(curr,0) == 1){
            result.add(root);
        }
        map.put(curr,map.getOrDefault(curr,0) + 1);
        return curr;
    }
    public List<Node> printAllDups(Node root)
    {
       //code here
       helper(root);
       Collections.sort(result,(n1,n2)-> Integer.compare(n1.data,n2.data));
       return result;
    }
    
}
// kth ansestor of the node using the backtracking
# 1st approach
class Solution {
    public void solve(Node root, boolean[] found, int node, List<Integer> ancestors) {
        if (root == null) {
            return;
        }
        if (root.data == node) {
            found[0] = true;
            return;
        }
        solve(root.left, found, node, ancestors);
        if (found[0]) {
            ancestors.add(root.data);
            return;
        }
        solve(root.right, found, node, ancestors);
        if (found[0]) {
            ancestors.add(root.data);
        }
    }

    public int kthAncestor(Node root, int k, int node) {
        boolean[] found = {false};
        List<Integer> ancestors = new ArrayList<>();
        solve(root, found, node, ancestors);
        if (ancestors.size() < k) {
            return -1;
        }
        return ancestors.get(k - 1);
    }}

# 2nd approach
	
class Solution {
    Node root;

    boolean solve(Node root, int[] cnt, int node, int[] val) {
        if (root == null)
            return false;

        if (root.data == node) {
            return true;
        }

        boolean l = solve(root.left, cnt, node, val);
        boolean r = solve(root.right, cnt, node, val);

        if (l || r) {
            cnt[0]--;
            if (cnt[0] == 0)
                val[0] = root.data;

            return true;
        }

        return false;
    }

    int kthAncestor(Node root, int k, int node) {
        int[] cnt = new int[]{k};
        int[] val = new int[]{-1};

        solve(root, cnt, node, val);

        return val[0];
    }
}
// Binary tree maximum path sum
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxPath = new int[1];
        maxPath[0] = Integer.MIN_VALUE;
        solver(root,maxPath);
        return maxPath[0];
    }
    public int solver(TreeNode root,int[] maxPath){
        if(root == null) return 0;
        // get the left sum
        int lSum = solver(root.left,maxPath);
        // get the right sum
        int rSum = solver(root.right,maxPath);
        // add the new sum of right and left sum and the root.val also and pass to the maxPath
        maxPath[0] = Math.max(maxPath[0],lSum + rSum + root.val);
        // get the max from the (left or right) and the root.val or the root val 
        int newPath = Math.max(root.val,Math.max(lSum,rSum) + root.val);
        // find the max path for the previous path and the new 
        maxPath[0] = Math.max(maxPath[0],newPath);
        // return the value of the newPath for the next iteration
        return newPath;
    }
}
// Binary to DLL(Doubly Linked List)
class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    Node head,prev = null;
    Node bToDLL(Node root)
    {
	//  Your code here	
	inOrder(root);
	return head;
    }
    void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        if(head == null){
            head = root;
        } else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        inOrder(root.right);
    }
}
