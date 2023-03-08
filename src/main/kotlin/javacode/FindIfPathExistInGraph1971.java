package javacode;

class FindIfPathExistInGraph1971 {
    public static void union(int p, int q, int[] nums) {
        //if (nums[p] != nums[q]) {
        int pid = nums[p];
        int qid = nums[q];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pid) {
                nums[i] = qid;
            }
        }
        //}
    }

    public static boolean isConnected(int p, int q, int[] nums) {
        return nums[p] == nums[q];
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int[] r = edges[i];
            //System.out.println(Arrays.toString(r)); 
            union(r[0], r[1], nums);
        }

        for (int i = 0; i < n; i++) {
            System.out.println("val: " + i + " id: " + nums[i]);

        }

        return isConnected(source, destination, nums);

    }

    public static void main(String[] args) {
        int[][] x = {{4, 3}, {1, 4}, {4, 8}, {1, 7}, {6, 4}, {4, 2}, {7, 4}, {4, 0}, {0, 9}, {5, 4}};
        boolean r = validPath(10, x, 5, 9);
        System.out.println(r);
    }
}