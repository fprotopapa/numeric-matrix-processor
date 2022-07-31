package processor;

import java.util.Scanner;

public class Cmd {
    static final int ADD = 1;
    static final int SCALAR = 2;
    static final int MULTIPLY = 3;
    static final int TRANSPOSE = 4;
    static final int EXIT = 0;
    static final int MAIN = 1;
    static final int SIDE = 2;
    static final int VERTICAL = 3;
    static final int HORIZONTAL = 4;

    public static void menu() {
        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case ADD:
                    add(scanner);
                    break;
                case SCALAR:
                    multiplyScalar(scanner);
                    break;
                case MULTIPLY:
                    multiply(scanner);
                    break;
                case TRANSPOSE:
                    printMenuTranspose();
                    transposeMatrices(scanner);
                    break;
                case EXIT:
                    return;
            }
        }
    }

    public static void transposeMatrices(Scanner scanner) {
        int direction = scanner.nextInt();
        Matrix2D A = createMatrix(scanner, "Enter matrix:");
        Matrix2D T = new Matrix2D(A.getRows(), A.getCols());
        switch (direction) {
            case MAIN:
                Matrix2DOperation.transposeMain(T, A);
                break;
            case SIDE:
                Matrix2DOperation.transposeSide(T, A);
                break;
            case VERTICAL:
                Matrix2DOperation.transposeVert(T, A);
                break;
            case HORIZONTAL:
                Matrix2DOperation.transposeHoriz(T, A);
                break;
        }
        System.out.println("The result is:");
        T.printMatrix();
    }
    private static int[] getMatrixDimensions(Scanner scanner) {
        int[] dimensions = new int[2];
        System.out.print("Enter size of matrix: ");
        dimensions[0] = scanner.nextInt();
        dimensions[1] = scanner.nextInt();
        return dimensions;
    }

    private static Matrix2D createMatrix(Scanner scanner, String text) {
        int[] dimensions = getMatrixDimensions(scanner);
        int arr_len = dimensions[0] * dimensions[1];
        Matrix2D Mat = new Matrix2D(dimensions[0], dimensions[1]);
        double[] numbers = new double[arr_len];
        System.out.println(text);
        for (int i = 0; i < arr_len; i++) {
            numbers[i] = scanner.nextDouble();
        }
        Mat.fillMatrix(numbers);
        return Mat;
    }

    private static void multiply(Scanner scanner) {
        Matrix2D A = createMatrix(scanner, "Enter first matrix:");
        Matrix2D B = createMatrix(scanner, "Enter second matrix:");
        if (Matrix2DOperation.multiplyMatrices(A, B) == 0) {
            System.out.println("The result is:");
            A.printMatrix();
        } else {
            System.out.println("ERROR");
        }
    }
    private static void multiplyScalar(Scanner scanner) {
        Matrix2D A = createMatrix(scanner, "Enter matrix:");
        System.out.print("Enter constant: ");
        int scalar = scanner.nextInt();
        Matrix2DOperation.multiplyMatrixByScalar(A, scalar);
        System.out.println("The result is:");
        A.printMatrix();
    }
    private static void add(Scanner scanner) {
        Matrix2D A = createMatrix(scanner, "Enter first matrix:");
        Matrix2D B = createMatrix(scanner, "Enter second matrix:");
        if (Matrix2DOperation.addMatrices(A, B) == 0) {
            System.out.println("The result is:");
            A.printMatrix();
        } else {
            System.out.println("ERROR");
        }
    }
    private static void printMenu() {
        System.out.println(
                "1. Add matrices\n" +
                "2. Multiply matrix by a constant\n" +
                "3. Multiply matrices\n" +
                "4. Transpose matrix\n" +
                "0. Exit");
        System.out.print("Your choice: ");
    }

    private static void printMenuTranspose() {
        System.out.println(
                "1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line");
        System.out.print("Your choice: ");
    }
}
