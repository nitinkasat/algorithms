package com.nitink.algorithm;

public class MatrixRotator {

	enum DIRECTION {
		ROW_INCREASING, COLUMN_INCREASING, ROW_DECREASING, COLUMN_DECREASING
	}

	public static void main(String[] args) {
		rotateMatrixBy90Degree(getMatrix(8));
	}

	private static int[][] getMatrix(int i) {
		int counter = 1;
		int[][] matrix = new int[i][i];
		for (int k = 0; k < i; k++) {
			int[] subArray = new int[i];
			for (int l = 0; l < i; l++) {
				subArray[l] = counter++;
			}
			matrix[k] = subArray;
		}
		return matrix;
	}

	private static int[][] rotateMatrixBy90Degree(int[][] matrix) {
		System.out.println("Input matrix:-");
		printMatrix(matrix);
		for (int layer = 0; layer < matrix.length / 2; layer++) {
			int first = layer;
			int last = matrix.length - 1 - layer;
			for (int m = 0; m < last - first; m++) {
				shift(matrix, DIRECTION.ROW_INCREASING, first, first, first, last, matrix[first][first]);
			}
			printMatrix(matrix);
		}
		System.out.println("Matrix After Rotating 90 degrees:-");
		printMatrix(matrix);
		return matrix;
	}

	private static void shift(int[][] matrix, DIRECTION direction, int currentRow, int currentColumn, int start,
			int end, int firstValue) {
		switch (direction) {
		case ROW_INCREASING:
			if (currentRow == end) {
				shift(matrix, DIRECTION.COLUMN_INCREASING, currentRow, currentColumn, start, end, firstValue);
			} else {
				matrix[currentRow][currentColumn] = matrix[currentRow + 1][currentColumn];
				shift(matrix, direction, currentRow + 1, currentColumn, start, end, firstValue);
			}
			break;
		case COLUMN_INCREASING:
			if (currentColumn == end) {
				shift(matrix, DIRECTION.ROW_DECREASING, currentRow, currentColumn, start, end, firstValue);
			} else {
				matrix[currentRow][currentColumn] = matrix[currentRow][currentColumn + 1];
				shift(matrix, direction, currentRow, currentColumn + 1, start, end, firstValue);
			}
			break;
		case ROW_DECREASING:
			if (currentRow == start) {
				shift(matrix, DIRECTION.COLUMN_DECREASING, currentRow, currentColumn, start, end, firstValue);
			} else {
				matrix[currentRow][currentColumn] = matrix[currentRow - 1][currentColumn];
				shift(matrix, direction, currentRow - 1, currentColumn, start, end, firstValue);
			}
			break;
		case COLUMN_DECREASING:
			if (currentColumn == start) {
				matrix[start][start + 1] = firstValue;
				break;
			}
			matrix[currentRow][currentColumn] = matrix[currentRow][currentColumn - 1];
			shift(matrix, direction, currentRow, currentColumn - 1, start, end, firstValue);
			break;
		}
	}

	private static void printMatrix(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print("\t" + matrix[i][j]);
			}
			System.out.println();
		}
	}

}
