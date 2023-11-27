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

// knight moves towards the target using the bfs
class Solution {
    // Function to find out minimum steps Knight needs to reach the target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
        
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        
        int startX = KnightPos[0] - 1;
        int startY = KnightPos[1] - 1;
        int targetX = TargetPos[0] - 1;
        int targetY = TargetPos[1] - 1;
        
        visited[startX][startY] = true;
        queue.add(new int[]{startX,startY,0});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];
            
            // if target is meeted then return
            if(x == targetX && y == targetY){
                return steps;
            }
            
            for(int i = 0; i < 8; i++){
                // move x and y for knight next moves
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(isValidMove(newX,newY,N,visited)){
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX,newY,steps + 1});
                }
            }
        }
        return -1;
    }

    private static boolean isValidMove(int x, int y, int N, boolean[][] visited) {
        return x >= 0 && x < N && y >= 0 && y < N && !visited[x][y];
    }
}
// make connection which are needed using graphs
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] connection : connections) {
            int root1 = find(connection[0], parent);
            int root2 = find(connection[1], parent);

            if (root1 != root2) {
                union(root1, root2, parent, rank);
            }
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                components++;
            }
        }

        return components - 1;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private void union(int x, int y, int[] parent, int[] rank) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
// using proper graph above que is solved


class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                components++;
            }
        }

        return components - 1;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}
// topological sort

class Solution {
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSortUtil(i, adj, visited, stack);
            }
        }

        int[] result = new int[V];
        int index = 0;

        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }

        return result;
    }

    private static void topoSortUtil(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                topoSortUtil(neighbor, adj, visited, stack);
            }
        }

        stack.push(v);
    }
}
