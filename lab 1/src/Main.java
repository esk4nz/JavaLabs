public class Main {
    public static void main(String[] args) {

////         Матриця А з більш великими даними
//        long[][] A = {
//                {1000L, 2700L, -5435345L, -66456L, -435352L},
//                {4363463L, 36456L, 3253245L, -63645L, 3765753L},
//                {2346L, -1345145L, 645646L, 236465L, 73756L},
//                {35342523L, 6346456L, -3253245L, 123412L, 5546436L}
//        };
////         Матриця В з більш великими даними
//        long[][] B = {
//                {13454325L, 6245624L, 31543153L, 6452642L, 13513L, 6425624L, 2345432L},
//                {6462456L, 1345L, 2L, 42L, 53L, 53653L, 235L},
//                {63423L, 543L, 345L, 642L, 645L, 645L, 36L},
//                {23624L, 3L, 5132L, 5534L, 36L, 645L, 346L},
//                {346L, 45L, 64L, 34L, 65L, 35L, 65L}
//        };

//         Матриця А з більш малими даними
        long[][] A = {
                {12, 45, -67, -89, 23},
                {34, 56, 78, -90, 11},
                {22, 33, 44, -55, 66},
                {77, 88, 99, 20, 21}
        };

        // Матриця В з більш малими даними
        long[][] B = {
                {10, 21, 32},
                {43, 54, 65},
                {-76, 87, 98},
                {29, -30, 31},
                {99, 88, 77}
        };
        System.out.println("A length " + A.length + " " + A[0].length);
        System.out.println("B length " + B.length + " " + B[0].length);
        if (A.length == 0 || B.length == 0) {
            System.out.println("There is invalid matrix");
            return;
        }
        else if (A[0].length != B.length) {
            System.out.println("Invalid sizes of matrixes");
            return;
        }
        System.out.println("The A matrix is:");
        Matrix.showMatrix(A);
        System.out.println();
        System.out.println("The B matrix is:");
        Matrix.showMatrix(B);

        // Результуюча матриця
        long[][] result = Matrix.multiply(A, B);
        if (result != null) {
            System.out.println("The result matrix is:");
            Matrix.showMatrix(result);
            // Рахую суму як сума найбільших значень парних рядків додати до найменших значень непарних рядків
            // Парні рядки, тобто ті, які є непапарними з точки зору масиву, оскільки нумерація масиву з 0 починається
            // І навпаки для непарних, ті які в масиві позначені як 0, 2, бо у масиві нумерація йде як [0, 1, 2...], тому непарні для нас будуть 0 та 2
            Matrix.add(result);
        }
    }
}