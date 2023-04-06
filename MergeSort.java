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

        int count = 0; //Keeps track of the position to add the next element
        int i = 0; //Keep track of the index of the firstArray
        int j = 0; //Keep track of the index of the secondArr
        
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
                }
                 //If the second Array still has element yet to be added, but first Array has already added all of it's elements.
                 //Prevents an index out of bounds error, as i can become larger than firstArray before the while condition is checked.
                else {
                    returnArr[count] = secondArr[j];
                    count++;
                    j++;
                } 
            }
            //If the first Array still has element yet to be added, but second Array has already added all of it's elements.
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
