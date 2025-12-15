package Seatss;

public class Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][5];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				arr[i][j] = (int)(Math.random() * 15) + 1;
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println();
			
		}
		System.out.println(detectEquivalentAdjacentPairs(arr));
		checkDuplicates(arr);
		shiftRight(arr, 2, 3);
		System.out.println();
		shiftUp(arr, 3, 1);
		System.out.println();
		reverseRow(arr, 2);
		System.out.println();
		reverseCol(arr, 2);
	}
	public static int detectEquivalentAdjacentPairs(int[][] arr) {
		int count = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5 - 1; j++) {
				if(i < 5) {
					if(arr[i][j] == arr[i][j+1]) {
						count++;
					}
				}
			}
		}
		return count;
	}
	public static void checkDuplicates(int[][] arr) {
		int[] tempArrary = new int[16];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				tempArrary[arr[i][j]]++;
				
			}
		}
		for(int i = 1; i < 16; i++) {
			if(tempArrary[i] > 0) {
				System.out.println(i + ": " + tempArrary[i]);
			}
		}
	}
	public static void shiftRight(int[][] arr, int shift, int row) {
		int[] newArr = new int[arr.length];
		for(int j = 0; j < 5; j++) {
			int amountLeft = (j + shift) % arr.length;
			newArr[amountLeft] = arr[row][j];
			
			
		}
		for(int i = 0; i < 5; i++) {
			System.out.print(newArr[i] + ", ");
		}
		
	}
	public static void shiftUp(int[][] arr, int shift, int col) {
		int[] newArr = new int[arr.length];
		for(int i = 0; i < 5; i++) {
			int amountLeft = ( i + shift + 4) % 5;
			newArr[amountLeft] = arr[i][col];
		}
		for(int i = 0; i < 5; i++) {
			System.out.print(newArr[i] + ", ");
		}
		
	}
	public static void reverseRow(int[][] arr, int row) {
		int temp;
		for(int i = 0; i < (5 / 2) + 1; i++) {
			temp = arr[row][i];
			arr[row][i] = arr[row][arr.length - i - 1];
			arr[row][arr.length - i - 1] = temp;
			
		}
		for(int i = 0; i < 5; i++) {
			System.out.print(arr[row][i] + ", ");
		}
	}
	public static void reverseCol(int[][] arr, int col) {
		int temp;
		for(int i = 0; i < (5 / 2) + 1; i++) {
			temp = arr[i][col];
			arr[i][col] = arr[arr.length - i - 1][col];
			arr[arr.length - i - 1][col] = temp;
			
		}
		for(int i = 0; i < 5; i++) {
			System.out.print(arr[i][col] + ", ");
		}
	}
}
