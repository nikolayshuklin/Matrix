import javax.swing.*;
import java.awt.print.PrinterException;


public class Matrix {
    public int[][] matrix = new int[3][3]; //взял 3 на 3, чтобы можно было умножать

    public Matrix () {

    }
    public Matrix (int[][] matrix) {
        this.matrix = matrix;
    }

    public static void main(String[] args) {
        int[][] array1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] array2 = {{0,0,0},{0,5,8},{0,18,59}};
        Matrix matrix1 = new Matrix(array1);
        Matrix matrix2 = new Matrix(array2);

        System.out.println("Сложение матриц");
        matrix1.printMatrixToConsole(matrix1.summ(matrix2)); // Сложение матрицы 1 с матрицей 2 и вывод её на консоль
        System.out.println("Умножение матрицы на число");
        matrix1.printMatrixToConsole(matrix1.multiNumber(3)); // Умножение матрицы на число;
        System.out.println("Умножение матриц");
        matrix1.printMatrixToConsole(matrix1.multiMatrix(matrix2)); // Умножение матриц;


    }

    public Matrix summ (Matrix other) { // Сложение с другой матрицей
        Matrix summ = new Matrix();
        int[][] summary = new int[3][3];
        for (int i = 0; i < 3; i++){
            for (int n = 0; n < 3; n++){
                summ.matrix[i][n] = this.matrix[i][n] + other.matrix[i][n];
            }
        }
        return summ;

    }

    public Matrix multiNumber (int number) { // умножение матрицы на число
        Matrix multi = new Matrix();
        for (int i = 0; i < 3; i++){
            for (int n = 0; n < 3; n++){
                multi.matrix[i][n] = this.matrix[i][n] * number;
            }
        }
        return multi;
    }

    public void printMatrixToConsole (Matrix matrix) {
        System.out.println(stringMatrix(matrix));
    }

    public void printMatrix (Matrix matrix) throws PrinterException { // Распечатать на принтере матрицу
        String YourString = matrix.stringMatrix(matrix);
        JTextArea YourTextArea = new JTextArea();
        YourTextArea.setLineWrap(true);
        YourTextArea.append(YourString);
        YourTextArea.print();
    }

    public String stringMatrix (Matrix matrix) { // Вывод матрицы в виде String? сделано отдельно, чтобы можно было использовать в печати
        String string = new String();
        for (int i = 0; i < 3; i++) {
            for (int n = 0; n < 3; n++) {
               string += matrix.matrix[i][n] + " ";
            }
            string+="\n";
        }
        return string;
    }


    public Matrix multiMatrix(Matrix other) { // перемножение матриц
        Matrix multiMatrix = new Matrix();
        for (int i = 0; i < 3; i++) {
            for (int n = 0; n < 3; n++) {
                for (int k = 0; k < 3; k++){
                    multiMatrix.matrix [i][n] = multiMatrix.matrix [i][n] + this.matrix [i][k] * other.matrix [k][n];
                }
            }
        }
        return multiMatrix;
    }
}
