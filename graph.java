// bfs for graph
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
         boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        queue.add(0); // Starting from node 0
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return result;
    }
}

// dfs for graph
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void dfs(int node, boolean[] visited,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer>result){
        visited[node] = true;
        result.add(node);
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor,visited,adj,result);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        
        dfs(0,visited,adj,result);
        return result;
    }
}

// 2d matrix color filling example
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if(oldColor != color) search(image,sr,sc,oldColor,color);
        return image;
    }

    public void search(int[][] image,int row,int column,int oldColor,int newColor){
      if(image[row][column] == oldColor){
        image[row][column] = newColor;
        if(row >= 1) search(image,row - 1,column,oldColor,newColor);
        if(column >= 1) search(image,row,column - 1,oldColor,newColor);
        if(row + 1 < image.length) search(image,row + 1,column,oldColor,newColor);
        if(column + 1 < image[0].length) search(image,row,column + 1,oldColor,newColor);
      }
    }
}
