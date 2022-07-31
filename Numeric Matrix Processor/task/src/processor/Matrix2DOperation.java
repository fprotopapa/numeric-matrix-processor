package processor;

public class Matrix2DOperation {
    public static int addMatrices(Matrix2D MatA, Matrix2D MatB) {
        if (MatA.getRows() != MatB.getRows() || MatA.getCols() != MatB.getCols()) {
            return -1;
        }
        double[][] A = MatA.getMatrix();
        double[][] B = MatB.getMatrix();
        for (int i = 0; i < MatA.getRows(); i++) {
            for (int j = 0; j < MatA.getCols(); j++) {
                A[i][j] += B[i][j];
            }
        }
        MatA.setMatrix(A);
        return 0;
    }

    public static void multiplyMatrixByScalar(Matrix2D MatA, int scalar) {
        double[][] A = MatA.getMatrix();
        for (int i = 0; i < MatA.getRows(); i++) {
            for (int j = 0; j < MatA.getCols(); j++) {
                A[i][j] *= scalar;
            }
        }
    }

    public static int multiplyMatrices(Matrix2D MatA, Matrix2D MatB) {
        int rows_A = MatA.getRows();
        int rows_B = MatB.getRows();
        int cols_B = MatB.getCols();
        int cols_A = MatA.getCols();
        if (cols_A != rows_B) {
            return -1;
        }
        double[][] A = MatA.getMatrix();
        double[][] B = MatB.getMatrix();
        double[][] C = new double[rows_A][cols_B];
        for (int i = 0; i < rows_A; i++) {
            for (int j = 0; j < cols_B; j++) {
                for (int k = 0; k < cols_A; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        MatA.setMatrix(C);
        return 0;
    }

    public static void transposeMain(Matrix2D MatT, Matrix2D MatA) {
        double[][] A = MatA.getMatrix();
        double[][] T = MatT.getMatrix();
        for(int i = 0; i < MatA.getRows(); i++) {
            for(int j = 0; j < MatA.getCols(); j++) {
                T[i][j] = A[j][i];
            }
        }
    }

    public static void transposeSide(Matrix2D MatT, Matrix2D MatA) {
        double[][] A = MatA.getMatrix();
        double[][] T = MatT.getMatrix();
        int rows = MatA.getRows();
        int cols = MatA.getCols();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int indRow = (rows - 1) - i;
                int indCol = (cols - 1) - j;
                T[i][j] = A[indCol][indRow];
            }
        }
    }

    public static void transposeVert(Matrix2D MatT, Matrix2D MatA) {
        double[][] A = MatA.getMatrix();
        double[][] T = MatT.getMatrix();
        int cols = MatA.getCols();
        for(int i = 0; i < MatA.getRows(); i++) {
            for(int j = 0; j < cols; j++) {
                int indCol = (cols - 1) -j;
                T[i][j] = A[i][indCol];
            }
        }
    }

    public static void transposeHoriz(Matrix2D MatT, Matrix2D MatA) {
        double[][] A = MatA.getMatrix();
        double[][] T = MatT.getMatrix();
        int rows = MatA.getRows();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < MatA.getCols(); j++) {
                int indRow = (rows - 1) -i;
                T[i][j] = A[indRow][j];
            }
        }
    }
}
