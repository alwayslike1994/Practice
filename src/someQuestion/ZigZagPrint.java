package someQuestion;

public class ZigZagPrint {
    public static void zigzagPrint(int[][] arr) {
        int row = arr.length - 1;
        int column = arr[0].length - 1;
        boolean flag = true;
        int aRow = 0;
        int aColumn = 0;
        int bRow = 0;
        int bColumn = 0;
        while (aRow != row + 1) {
            printNum(arr, aRow, aColumn, bRow, bColumn, flag);
            aRow = aColumn == column ? aRow + 1 : aRow;
            aColumn = aColumn == column ? aColumn : aColumn + 1;
//bcolumn要放在brow前面变化，因为，bcolumn要根据brow变化，
// 但是brow放前面变化完了，当前bcolumn会受到影响。同理a的也是这样。
            bColumn = bRow == row ? bColumn + 1 : bColumn;
            bRow = bRow == row ? bRow : bRow + 1;
            flag = !flag;
            System.out.println();
        }
    }

    public static void printNum(int[][] arr, int arow, int acolumn, int brow, int bcolumn, boolean flag) {
        if (flag) {
            while (arow != brow + 1) {
                System.out.print(arr[arow++][acolumn--] + " ");
            }
        } else {
            while (brow != arow - 1) {
                System.out.print(arr[brow--][bcolumn++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int r=(int)(Math.random()*15)+1;
        int c=(int)(Math.random()*15)+1;
//        int r = 3;
//        int c = 5;
        int[][] test = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                test[i][j] = (int) (Math.random() * 100);
                System.out.print(test[i][j] + " ");
            }
            System.out.println();
        }
        zigzagPrint(test);
    }
}
