class Solution {
/*
	Explanation video: https://youtu.be/6SohPBdwU94
*/

	/*
	[1,2,3],
	[4,5,6],
	[7,8,9]

	mirror around secondary diagonal   

	[9, 6, 3],
	[8, 5, 2],
	[7, 4, 1]

	mirror horizontally around middle line

	[7, 4, 1],
	[8, 5, 2],
	[9, 6, 3]
	*/

	/*
	[ 5, 1, 9,11],
	[ 2, 4, 8,10],
	[13, 3, 6, 7],
	[15,14,12,16]

	mirror around secondary diagonal 

	[16, 7, 10, 11],
	[12, 6,  8,  9],
	[14, 3,  4,  1],
	[15, 13, 2,  5]

	mirror horizontally around middle line

	...
	
	*/

	public void rotate(int[][] matrix) {
		mirrorSecondaryDiagonal(matrix);
		mirrorHorizontally(matrix);
	}

	private static void mirrorSecondaryDiagonal(int[][] matrix) {
        // flip second diagonaly
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length - i - 1; j++) {
				int current = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - j - 1][matrix.length - i - 1];
				matrix[matrix.length - j - 1][matrix.length - i - 1] = current;
			}
		}
	}
    // flip horizontally
	private static void mirrorHorizontally(int[][] matrix) {
		for(int i = 0; i < matrix.length / 2; i++) {
			for(int j = 0; j < matrix.length; j++) {
				int current = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - i - 1][j];
				matrix[matrix.length - i - 1][j] = current;
			}
		}

	}
}
