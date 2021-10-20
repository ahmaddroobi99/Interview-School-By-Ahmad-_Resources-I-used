class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        
        int low = 0;
        int high = matrix.length - 1;
        int targetRowIndex = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][matrix[0].length - 1] == target) {
                return true;
            } else if (target > matrix[mid][matrix[0].length-1]) {
                low = mid + 1;
            } else {
                targetRowIndex = mid;
                high = mid - 1;
            }
        }
        
        if (targetRowIndex == -1) {
            return false;
        }
        
        low = 0;
        high = matrix[0].length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[targetRowIndex][mid] == target) {
                return true;
            } else if (target > matrix[targetRowIndex][mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
        
    }
}
