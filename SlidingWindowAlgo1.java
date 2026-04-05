public class SlidingWindowAlgo1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 3;
        int maxSum = findMaxSum(arr, k);
        System.out.println("Maximum sum of " + k + " consecutive elements is: " + maxSum);
    }

    public static int findMaxSum(int[] arr, int k) {
        if (arr.length < k) {
            throw new IllegalArgumentException("Array length must be greater than or equal to k");
        }

        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int currentSum = maxSum;
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
