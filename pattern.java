public class pattern {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for (int j = 0; j < n; j++) {
                    System.out.print("* ");
                }
            } else {
                System.out.print("* ");
                for (int j = 0; j < n - 2; j++) {
                    System.out.print("  ");
                }
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            System.out.print(" ".repeat(n - i));
            for (int j = 0; j < i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            System.out.print(" ".repeat(n - i));
            for (int j = 0; j < i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(j + 1 + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = n; i > 0; i--) {
            for (int j = i; j > 1; j--) {
                System.out.print(i - j + 1 + " ");
            }
            System.out.println();
        }
        System.out.println();

        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(count + " ");
                count += 1;
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (i % 2 == 0) {
                    System.out.print("");
                } else {
                    System.out.print("");
                }
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = n; i >= 0; i--) {
            System.out.print(" ".repeat(n - i));
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            if (i != 0) {
                System.out.println();
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (i == 1) {
                    continue;
                } else {
                    System.out.print("* ");

                }
            }
            if (i != 1 && i != 0) {
                System.out.println();
            }
        }
        System.out.println();

        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(j + 1 + " ");
            }
            if (i != 0) {
                System.out.println();
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (i == 1) {
                    continue;
                } else {
                    System.out.print(j + 1 + " ");

                }
            }
            if (i != 1 && i != 0) {
                System.out.println();
            }
        }
        System.out.println();

        for (int i = 0; i < n + 1; i++) {
            System.out.print(" ".repeat(i));
            for (int j = 0; j < n + 1; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(" ".repeat(n - i));
            for (int j = 1; j <= i; j++) {
                System.out.print(i - j + 1);
            }
            for (int k = 1; k < i; k++) {
                System.out.print(k + 1);
            }
            System.out.println();
        }
        System.out.println();

    }
}
