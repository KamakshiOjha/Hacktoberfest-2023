//leetcode - Candy
//There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
// You are giving candies to these children subjected to the following requirements:
// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
// Return the minimum number of candies you need to have to distribute the candies to the children.

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,2,2,4,78,87,2};
        System.out.println(candy(ratings));
    }
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int [] left = new int[n];
        int [] right = new int[n];
        for(int i = 0;i<n;i++){
            left[i] = 1;
            right[i] = 1;
        }

        for(int i = 1;i<n;i++){
            if(ratings[i-1]< ratings[i]){
                left[i] = left[i-1] + 1;
            }
        }
        for(int i = n-2;i>=0;i--){
            if(ratings[i+1]< ratings[i] && right[i] <= right[i + 1]){
                right[i] = right[i+1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}
