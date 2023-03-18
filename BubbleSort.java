public class BubbleSort {
    public BubbleSort() {

    }
    public long sort(int[] array) {
        long startTime = System.nanoTime();
        
        for(int i_ = 0; i_ < array.length; i_++ ) {
            for( int i = 0; i < array.length - 1; i ++) {
                if(array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
      
        

        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
