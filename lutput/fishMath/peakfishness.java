package lutput.fishMath;

public class peakfishness {

    public static void main(String[] args) {
        int baseNumber = 5;
        int upToNumber = 10;
        int[][] table = generateMultiplicationTable(baseNumber, upToNumber);
        displayMultiplicationTable(table);
    }

    public static int[][] generateMultiplicationTable(int baseNumber, int upToNumber) {
        if (upToNumber < baseNumber) {
            throw new IllegalArgumentException("Invalid input: upToNumber should be greater than or equal to baseNumber.");
        }

        int numRows = upToNumber - baseNumber + 1;
        int numCols = 10;

        int[][] table = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                table[i][j] = (baseNumber + i) * (j + 1);
            }
        }

        return table;
    }
    public static void displayMultiplicationTable(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%4d", table[i][j]);
            }
            System.out.println();
        }
    }
}

