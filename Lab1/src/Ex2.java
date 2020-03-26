public class Ex2 {
    private static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1)
                    System.out.print('\u25A0' + " ");
                else
                    System.out.print('\u25A1' + " ");
            }
            System.out.print("\n");
        }
    }

    private static void dfs(int i, int[][] matrix, boolean[] visited) {
        if (!visited[i]) {
            visited[i] = true;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && !visited[j]) {
                    dfs(j, matrix, visited);
                }
            }
        }
    }

    private static boolean isAllTrue(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[][] G;
        int m = 0, n = Integer.parseInt(args[0]);
        if (n % 2 == 1) {
            System.out.println("The number is invalid \n");
            return;
        }
        G = new int[n][n];
        String graphType = args[1];
        if (graphType.equals("complete")) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    G[i][j] = 1;
                    G[j][i] = 1;
                    m++;
                }
            }
            printMatrix(G);
            System.out.println("Number of Edges is " + m);
            System.out.println("\u0394(G) = " + (n - 1));
            System.out.println("\u03B4(G) = " + (n - 1));
            System.out.println("The Graph is Regular");
            System.out.println("sum of degrees equals the value 2 * m");


        }
        if (graphType.equals("cycle")) {
            for (int i = 0; i < n - 1; i++) {
                G[i][i + 1] = 1;
                G[i + 1][i] = 1;
                m++;
            }
            G[0][n - 1] = 1;
            G[n - 1][0] = 1;
            m++;
            printMatrix(G);
            System.out.println("Number of Edges is " + m);
            System.out.println("\u0394(G) = 2");
            System.out.println("\u03B4(G) = 2");
            System.out.println("The Graph is Regular");
            System.out.println("the sum of the degrees equals the value 2 * m");

        }
        if (graphType.equals("random")) {
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (i != j) {
                        int isConn = (int) (Math.random() * 2);
                        G[i][j] = isConn;
                        G[j][i] = isConn;
                        m = m + G[i][j];
                    }
                }

            }
            int delta = 0, gama = n, gradNodPred = 0, ok = 1, sumDegrees = 0;
            for (int i = 0; i < n; i++) {
                int gradNodCurent = 0;
                for (int j = 0; j < n; j++) {
                    gradNodCurent += G[i][j];
                }
                if (delta < gradNodCurent) {
                    delta = gradNodCurent;
                }
                if (gama > gradNodCurent) {
                    gama = gradNodCurent;
                }
                if (i > 0) {
                    if (gradNodPred != gradNodCurent)
                        ok = 0;
                }
                gradNodPred = gradNodCurent;
                sumDegrees += gradNodCurent;
            }
            if (n < 100)
                printMatrix(G);
            System.out.println("Number of Edges is " + m);
            System.out.println("\u0394(G) = " + delta);
            System.out.println("\u03B4(G) = " + gama);
            if (ok == 1) {
                System.out.println("The Graph is Regular");
            } else {
                System.out.println("The Graph is not Regular");
            }
            if (sumDegrees == 2 * m) {
                System.out.println("the sum of the degrees equals the value 2 * m");
            } else {
                System.out.println("the sum of the degrees not equals the value 2 * m");
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i, G, visited);
                    ++count;
                }
            }
            if (count == 1) {
                System.out.println("The Graph is connected ");
            } else {
                System.out.println("The Graph is not connected . It have " + count + " components");
            }
        }
        if (graphType.equals("randomTree")) {
            boolean[] usedNodes = new boolean[n];
            usedNodes[0] = true;
            while (!isAllTrue(usedNodes)) {
                for (int i = 0; i < n - 1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (!usedNodes[j]) {
                            int isConn = (int) (Math.random() * 2);
                            G[i][j] = isConn;
                            G[j][i] = isConn;
                            if (G[i][j] == 1)
                                usedNodes[j] = true;
                        }

                    }
                }
            }
            printMatrix(G);
        }
        long endTime = System.nanoTime();
        double totalTime = (double) (endTime - startTime) / 1000000000;
        System.out.println(totalTime + " seconds");
    }
}
