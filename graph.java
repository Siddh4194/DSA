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

// number of triangles
class Solution {
    public static int numberOfTriangles(int n, int[][] g) {
        if(n < 3) return 0;
        int countTriangle = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    // hint is if 0 hase connection with 2 
                    // and the 2 has connection with the 1 then it forms the trianfle
                    if(i != k && j!= k && j != i && g[i][j] == 1 && g[j][k] == 1 && g[k][i] == 1){
                        countTriangle++;
                    }
                }
            }
        }
        // divided 
        return countTriangle / 3;
    }
}

// cycle in the graph
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(checkCycle(i,recursionStack,visited,adj)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkCycle(int current , boolean[] recursionStack,boolean[] visited,ArrayList<ArrayList<Integer>> adj){
        visited[current] = true;
        recursionStack[current] = true;
        
        for(int n : adj.get(current)){
            if(!visited[n] && checkCycle(n,recursionStack,visited,adj)){
                return true;
            } else if(recursionStack[n]){
                return true;
            }
        }
        
        recursionStack[current] = false;
        return false;
    }
}
// rat in a maze

class Solution {
    public static ArrayList<String> findPath(int[][] matrix,int n) {
        ArrayList<String> paths = new ArrayList<String>();
        boolean[][] visited = new boolean[n][n];

        if (matrix[0][0] == 1) {
            visited[0][0] = true;
            backtrack(matrix, 0, 0, paths, new StringBuilder(), visited);
        }

        return paths;
    }

    private static void backtrack(int[][] matrix, int x, int y, ArrayList<String> paths, StringBuilder path, boolean[][] visited) {
        int n = matrix.length;

        if (x == n - 1 && y == n - 1) {
            paths.add(path.toString());
            return;
        }

        char[] directions = {'U', 'D', 'L', 'R'};
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (isValidMove(matrix, newX, newY, visited)) {
                visited[newX][newY] = true;
                path.append(directions[i]);
                backtrack(matrix, newX, newY, paths, path, visited);
                visited[newX][newY] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    private static boolean isValidMove(int[][] matrix, int x, int y, boolean[][] visited) {
        int n = matrix.length;
        return x >= 0 && x < n && y >= 0 && y < n && matrix[x][y] == 1 && !visited[x][y];
    }
}
