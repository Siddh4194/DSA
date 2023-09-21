//find the elemment in the matrix
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] arr: matrix)
        {
            for(int i:arr)
            {
                if(i==target) return true;
            }
        }
        return false;
    }
}
