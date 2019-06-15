package coll.Matrix;
import java.lang.reflect.Array;
import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Supplier;

/**
 * A generic 2D-matrix.
 * @param <E> the cell type.
 */
public class Matrix<E> implements Iterable {

    private int rows;
    private int columns;
    private E data[][];

    /**
     * Constructs a Matrix.
     *
     * @param rows - the number of rows.
     * @param columns - the number of columns.
     */
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        E[][] array = (E[][])new Object[rows][columns];
        data = array;
    }

    /**
     * Assigns a value to a given cell, specified by its row, column coordinates.
     *
     * @param row - the row index with 0-based indexing.
     * @param column - the column index with 0-based indexing.
     * @param value - the value to be assigned to the given cell.
     */
    public void insert(int row, int column, E value) {
        data[row][column] = value;
    }

    /**
     * Gets the value at a given cell, specified by its row, column coordinates.
     *
     * @param row - the row index with 0-based indexing.
     * @param column - the column index with 0-based indexing.
     * @return the value located at the given cell.
     */
    public E get(int row, int column) {
        return data[row][column];
    }

    /**
     * Gets the total number of cells in the matrix.
     *
     * @return an int equal to the total number of cells in the matrix.
     */
    public int size() {
         return this.columns * this.rows;
    }

    /**
     * Converts the matrix to String format.
     *
     * @return a String representation of the matrix.
     */
    public String toString() {
        String str = "";
        for (E[] list: this.data) {
            for (int a = 0; a < this.columns; a++){
                if (a == this.columns - 1){
                    if(list[a] == null){
                        str = str + "\t" + "\n";
                    }
                    else{
                        str = str + list[a] + "\n";
                    }
                }
                else{
                    if(list[a] == null){
                        str = str + "\t";
                    }
                    else {
                        str = str + list[a] + "\t";
                    }
                }
            }
        }

        return str;
    }

    /**
     * Gets an iterator for the matrix. The iterator follows column-major order.
     *
     * @return an iterator for the matrix.
     */
    @Override
    public Iterator iterator() {
        Iterator iterator = new Iterator() {
            private int currentrowIndex = 0;
            private int currentcolumnIndex = 0;
            int counter = 0;
            @Override
            public boolean hasNext() {
                if(currentrowIndex < rows || currentcolumnIndex < columns){
                    return true;
                }
                return false;
            }

            @Override
            public Object next() {
                if(currentrowIndex == rows){
                    currentrowIndex = 1;
                    currentcolumnIndex++;
                }
                else if(currentcolumnIndex == 0 && currentrowIndex == 0 && counter == 0){
                    counter++;
                    currentcolumnIndex++;
                    currentrowIndex++;
                    return data[0][0];
                }
                else {
                    currentrowIndex++;
                }
                return data[currentrowIndex - 1][currentcolumnIndex - 1];

            }
        };
        return iterator;
    }
}