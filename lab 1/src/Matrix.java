import java.util.Arrays;

public class Matrix {
    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] C = new long[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                long sum = 0;
                for (int k = 0; k < b.length; k++) {
                    if (a[i][k] > 0 && b[k][j] > 0 && a[i][k] > Long.MAX_VALUE / b[k][j]) {
                        System.out.println("Overflow by multiplication");
                        return null;
                    }
                    else if (a[i][k] > 0 && b[k][j] < 0 && b[k][j] < Long.MIN_VALUE / a[i][k]) {
                        System.out.println("Overflow by multiplication");
                        return null;
                    }
                    else if (a[i][k] < 0 && b[k][j] > 0 && a[i][k] < Long.MIN_VALUE / b[k][j]) {
                        System.out.println("Overflow by multiplication");
                        return null;
                    }
                    else if (a[i][k] < 0 && b[k][j] < 0 && a[i][k] < Long.MAX_VALUE / b[k][j]) {
                        System.out.println("Overflow by multiplication");
                        return null;
                    }
                    else if (a[i][k] > 0 && b[k][j] > 0 && a[i][k] > Long.MAX_VALUE - b[k][j]) {
                        System.out.println("Overflow by addition");
                        return null;
                    }
                    else if (a[i][k] < 0 && b[k][j] < 0 && a[i][k] < Long.MIN_VALUE - b[k][j]) {
                        System.out.println("Overflow by addition");
                        return null;
                    }
                    sum = sum + a[i][k] * b[k][j];
                }
                C[i][j] = sum;
            }
        }
        return C;
    }
    public static void add(long[][] c) {
        long sum = 0;
        for (int i = 0; i < c.length; i++) {
            long valueToAdd;

            if (i % 2 == 0) {
                valueToAdd = Arrays.stream(c[i]).min().getAsLong();
            } else {
                valueToAdd = Arrays.stream(c[i]).max().getAsLong();
            }

            if (sum > 0 && valueToAdd > 0 && sum > Long.MAX_VALUE - valueToAdd) {
                System.out.println("Overflow by addition");
                return;
            }

            if (sum < 0 && valueToAdd < 0 && sum < Long.MIN_VALUE - valueToAdd) {
                System.out.println("Overflow by addition");
                return;
            }

            sum = sum + valueToAdd;
        }
        System.out.println("Sum: "+sum);
    }

    public static void showMatrix (long[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

}
