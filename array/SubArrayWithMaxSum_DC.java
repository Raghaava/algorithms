package org.interview.preperation.array;

public class SubArrayWithMaxSum_DC {
    public static void main(String args[]){
       int[] arr = new int[]{-2, -5, 6, -2, -3, 1, 5, -6};

        System.out.println(findSubArrayWithMaxSum(arr,0,arr.length-1));
    }

    //O(nlogn)
    private static int findSubArrayWithMaxSum(int[] arr,int left,int right){

        if(left==right)
        {
            return arr[left];
        }

        int mid = (left+right)/2;

        int left_MSS = findSubArrayWithMaxSum(arr,left,mid);
        int right_MSS = findSubArrayWithMaxSum(arr,mid+1,right);

        int leftsum = Integer.MIN_VALUE;
        int rightsum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=mid;i>=0;i--){
            sum += arr[i];
            leftsum = Math.max(leftsum,sum);
        }

        sum = 0;
        for(int i=mid+1;i<=right;i++){
            sum += arr[i];
            rightsum = Math.max(rightsum,sum);
        }

        int ans = Math.max(left_MSS,right_MSS);
        return Math.max(ans,leftsum+rightsum);
    }
}
