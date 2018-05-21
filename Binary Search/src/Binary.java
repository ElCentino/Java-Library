import java.util.Random;

public class Binary {
	
	static int counter = 0;
	
	static int[] memo;
	
	static boolean[][] paths = {	
			{true, true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true, true, true, true, true, true}	
	};
	
	public Binary() {
		
		int[] intArray = new int[20];
		
		for(int i = 0; i < intArray.length; i++) {
			
			intArray[i] = new Random().nextInt(intArray.length) + 1;
		}
		
	}
	
	public static void quicksort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}
	
	public static void quicksort(int[] array, int low, int high) {
		
		if(low >= high) {
			return;
		}
		
		int pivot = array[(low + high) / 2];
		
		int index = partition(array, low, high, pivot);
		
		quicksort(array, low, index - 1);
		quicksort(array, index, high);
	}
	
	public static int partition(int[] array, int low, int high, int pivot) {
		
		while(low <= high) {
			
			while(array[low] < pivot) {
				low++;
			}
			
			while(array[high] > pivot) {
				high--;
			}
			
			if(low <= high) {
				
				swap(array, low, high);
				
				low++;
				high--;
			}
		}
		
		return low;
		
	}
	
	public static void swap(int[] array, int left, int right) {
		
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
		
	}
	
	public static int fib(int n, int[] memo) {
		
		if(n <= 0) {
			
			return 0;
		
		} else if(n == 1) {
			
			return 1;
			
		} else if(memo[n] == 0){
			
			Binary.counter++;
			
			memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
		}
		
		return memo[n];
	}
	
	public static void mergesort(int[] array) {
		mergesort(array, 0, array.length - 1);
	}
	
	public static void mergesort(int[] array, int leftStart, int rightEnd) {
		
		if(leftStart >= rightEnd) {
			return;
		}
		
		int midpoint = (leftStart + rightEnd) / 2;
		
		mergesort(array, leftStart, midpoint);
		mergesort(array, midpoint + 1, rightEnd);
		mergeHalves(array, new int[array.length], leftStart, rightEnd);
	}
	
	public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
		
		int leftEnd = (leftStart + rightEnd) / 2;
		
		int rightStart = leftEnd + 1;
		
		int size = rightEnd - leftStart + 1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while(left <= leftEnd && right <= rightEnd) {
			
			if(array[left] <= array[right]) {
				
				temp[index] = array[left];
				left++;
				
			} else {
				
				temp[index] = array[right];
				right++;
				
			}
			
			index++;
		}
		
		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, array, leftStart, size);
		
	}
	
	public static int paths(boolean[][] grid, int row, int column) {
		
		if(!isValidPath(grid, row, column)) return 0;
		
		if(isAtEnd(grid, row, column)) return 1;
		
		return paths(grid, row + 1, column) + paths(grid, row, column + 1);
		
	}
	
	public static boolean isValidPath(boolean[][] grid, int row, int column) {
		return true;
	}
	
	public static boolean isAtEnd(boolean[][] grid, int row, int column) {
		
		if(row == 9 && column == 9) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		int arraysize = 12;
		
		int[] array = new int[arraysize];
		
		for(int i = 0; i < arraysize; i++) {
		
			array[i] = new Random().nextInt(arraysize) + 1;
		}
		
		double nStart = (double) System.currentTimeMillis();
		
		mergesort(array);
		
		double nStop = (double) System.currentTimeMillis();
		
		
		
		for(int x: array) {
			
			System.out.println(x);
		}
		
		System.out.println("Time taken to execute is : " + (nStop - nStart) + "ms");
		
		System.out.println("Calling Fib series of 5");
		
		System.out.println("it is " + fib(6, new int[6 +1]));
		
		System.out.println("It took " + counter + " counts");

		
	}
}
