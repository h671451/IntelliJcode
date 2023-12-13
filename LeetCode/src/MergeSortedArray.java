class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums1R = nums1;
        nums1 = new int[m + n];
        int indexA = 0;
        int i1 = 0;
        int i2 = 0;

        while( i1 < nums1R.length && i2 < nums2.length){
            if(nums1R[i1] < nums1R[0]){

            } else if(nums1R[i1] < nums2[i2]){
                nums1[indexA] = nums1R[i1];
                indexA++;
                i1++;

            } else {
                nums1[indexA] = nums2[i2];
                indexA++;
                i2++;
            }
        }

        while(i1 < nums1R.length){
            nums1[indexA] = nums1R[i1];
            indexA++;
            i1++;
        }

        while(i2 < nums2.length){
            nums1[indexA] = nums2[i2];
            indexA++;
            i2++;
        }




    }
}