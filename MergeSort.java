public class MergeSort {
    public MergeSort() {

    }

    public int[] recursive(int[] array) {
        if(array.length <= 1) {
            //Base case
            return array;
        }

        //Split the array into two
        int[] firstHalf = new int[(array.length + 1) / 2];
        int[] secondHalf = new int[array.length - firstHalf.length];

        for(int i = 0; i < array.length; i++) {
            if(i < firstHalf.length) {
                firstHalf[i] = array[i];
            } else {
                secondHalf[i - firstHalf.length] = array[i];
            }
        }

        int[] firstArr = recursive(firstHalf);
        int[] secondArr = recursive(secondHalf);
        int[] returnArr = new int[firstArr.length + secondArr.length];

        int count = 0;
        int i = 0;
        int j = 0;
        while (i < firstArr.length) {
            while(j < secondArr.length) {
                if(i < firstArr.length) {
                    if(firstArr[i] < secondArr[j]){
                        returnArr[count] = firstArr[i];
                        count++;
                        i++;
                    } else {
                        returnArr[count] = secondArr[j];
                        count++;
                        j++;
                    }
                } else {
                    returnArr[count] = secondArr[j];
                    count++;
                    j++;
                } 
            } 
            if(j >= secondArr.length && i < firstArr.length) {
                returnArr[count] = firstArr[i];
                count++;
                i++;
            }
        }
        return returnArr;
    }

   


    public long sort(int[] array) {
        long startTime = System.nanoTime();

        recursive(array);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
