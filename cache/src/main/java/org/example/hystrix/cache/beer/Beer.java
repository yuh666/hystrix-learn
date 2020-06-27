package org.example.hystrix.cache.beer;

public class Beer {


    public static int sum(int i) {
        int all = i;
        int rt = 0;

        while (all > 0) {
            rt++;
            all--;
            if (rt % 3 == 0) {
                all++;
            }
        }
        return rt;
    }

    public static int sum(int all, int rt) {
        if (all == 0) {
            return rt;
        }
        if ((rt + 1) % 3 == 0) {
            return sum(all, rt + 1);
        } else {
            return sum(all - 1, rt + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(sum(9));
        System.out.println(sum(9, 0));
    }
}
