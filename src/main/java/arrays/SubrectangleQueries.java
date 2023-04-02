package arrays;

class SubrectangleQueries {

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    private int[][] rectangle;

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int rowC = 0; rowC < rectangle.length; rowC++) {
            for (int colC = 0; colC < rectangle[rowC].length; colC++) {
                if (rowC >= row1 && rowC <= row2) {
                    if (colC >= col1 && colC <= col2) {
                        rectangle[rowC][colC] = newValue;
                    }
                }
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}