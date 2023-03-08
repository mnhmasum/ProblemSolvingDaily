package javacode;

class FindIfPathExistInGraph1971 {
    public static void union(int p, int q, int[] nums) {
        int root_p = root(p, nums);
        int root_q = root(q, nums);
        nums[root_p] = root_q;
    }

    public static boolean isConnected(int p, int q, int[] nums) {
        return root(p, nums) == root(q, nums);
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }

        for (int[] r : edges) {
            union(r[0], r[1], nums);
        }

        return isConnected(source, destination, nums);

    }

    public static int root(int q, int[] nums) {
        while (nums[q] != q) {
            q = nums[q];
        }
        return q;
    }

    public static void main(String[] args) {
        int[][] x = {{4, 3}, {1, 4}, {1, 7}};
        boolean r = validPath(10, x, 4, 6);
        System.out.println(r);
    }
}