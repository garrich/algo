package arrays;

public class ShiftedArr {

    public int shifterArrSearch(int[] shiftedArr, int num) {

        int pivot = getPivot(shiftedArr);
        int start,end;
        if(num<shiftedArr[shiftedArr.length-1]){
            //in the right size
            start = pivot+1;
            end = shiftedArr.length-1;
        }else{
            start = 0;
            end = pivot;
        }

        return binarySearch(shiftedArr,num, start, end);
    }

    private int helper(int[] shiftedArr, int pivot, int num) {
        int anw  = binarySearch(shiftedArr, num,0, pivot);
        return anw==-1?binarySearch(shiftedArr, num, pivot-1, shiftedArr.length-1):anw;
    }

    private int binarySearch(int[] shiftedArr, int num, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (shiftedArr[mid] == num)
                return mid;

            if (shiftedArr[mid] > num) {
                //go left
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }

    private int getPivot(int[] shiftArr) {
        int start = 0, end = shiftArr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            System.out.println(mid);
            if (mid == shiftArr.length-1 || shiftArr[mid] > shiftArr[mid + 1]) return mid;

            if (shiftArr[mid] > shiftArr[0]) {
                //go right
                start = mid + 1;
            } else {
                //go left
                end = mid;
            }
        }
        return 0;
    }
    /*

    [3,4,5,1,2]
     num = 2
     length = 5
     mid = 3

     [2,3,4,5,1]
     length = 5
     mid = 3

     [4, 5, 1, 2, 3]
     length = 5
     mid 2



     */
}
