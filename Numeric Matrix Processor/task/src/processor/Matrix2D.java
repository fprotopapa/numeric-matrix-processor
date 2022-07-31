package processor;

public class Matrix2D {

    private int rows;
    private int cols;
    private double[][] matrix;

    public Matrix2D(int rows, int cols) {
        this.matrix = new double[rows][cols];
        this.setCols(cols);
        this.setRows(rows);
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
        setRows(matrix.length);
        setCols(matrix[0].length);
    }

    public void fillMatrix(double[] numbers) {
        int ind_num = 0;
        for (int i = 0; i < this.rows && ind_num < numbers.length; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.matrix[i][j] = numbers[ind_num];
                ind_num++;
            }
        }
    }

    public void printMatrix() {
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.cols; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
