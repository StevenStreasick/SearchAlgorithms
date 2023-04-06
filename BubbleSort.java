public class BubbleSort {
    public BubbleSort() {

    }

    /**
     * Determines if the elements need to be swapped, and if they do, it swaps them
     * @param array
     * @param i
     */
    private void compareAndSwap(int[] array, int i) {
        if(array[i] > array[i + 1]) {
            int temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
    }

    /**
     * Performs a BubbleSort on the inputted array and returns the time that it 
     * took to sort in nanoSeconds.
     * 
     * Time complexity:
     * Worse case: O(n ^ 2)
     * Best case: O(n)
     * 
     * Space complexity: 1
     * 
     * @param array
     * @return long
     */
    public long sort(int[] array) {
        long startTime = System.nanoTime();

        for(int i = 0; i <= array.length; i++ ) {
            for( int j = 0; j < array.length - 1; j ++) {
                compareAndSwap(array, j);
            }
        }      

        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
