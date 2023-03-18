public class BinarySearch {
    //The method should return the index of the element toFind if it is in the array or -1 if it is not in the array.
    public static int binarySearchDescending(int[] vals, int toFind) {
        return binarySearchDescendingHelper(vals, toFind, 0, vals.length-1);
    }

    public static int binarySearchDescendingHelper(int[] vals, int toFind, int start, int end) {
        if(end - start < 0) {
            return -1;
        }
      

        int halfway = (int) (((double)(end - start) / 2) + start + .5);

        if(vals[halfway] < toFind) { //If the value we are looking for is less then the halfway
            return binarySearchDescendingHelper(vals, toFind, start, halfway - 1);
        } else if(vals[halfway] > toFind) {
            return binarySearchDescendingHelper(vals, toFind, halfway + 1, end);
        } else {
            return halfway;
        }

    }

    //[20,18,17,12,10,8,9,6,1]:

    //calling binarySearch on this array with 17 for toFind should return 2 (the index of element 17)
    //calling binarySearch on this array with 11 for toFind should return -1 (as the desired element is not in the array)
    public static void main(String[] args) {
      
        int[] vals = {20, 18, 17, 12, 10, 8, 9, 6, 1};
        System.out.println("Expected: 2 Got: " + binarySearchDescending(vals, 17));
        System.out.println("Expected: -1 Got: " + binarySearchDescending(vals, 11));

    }
}