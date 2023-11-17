/**
 * @Description 实现稀疏数组
 * @Create by hqx
 * @Date 2023/9/15 1:03
 */
public class SparseArray {
    public static void main(String[] args) {

        // 原始数组
        int[][] chessArray = new int[11][11];

        chessArray[0][1] = 1;
        chessArray[1][2] = 2;
        chessArray[2][3] = 3;

        System.out.println("原始数组~~~~");
        // 打印显示
        for (int[] row : chessArray) {
            for (int col : row) {
                System.out.printf("%d\t", col);
            }
            System.out.println();
        }

        // 统计原始数组有效数据个数
        int sum = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 原始数组转稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }
        // 打印显示
        System.out.println();
        System.out.println("稀疏数组~~~~~~");
        for (int[] row : sparseArray) {
            for (int col : row) {
                System.out.printf("%d\t", col);
            }
            System.out.println();
        }

        // 稀疏数组转原始数组
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i< sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        // 打印显示
        System.out.println();
        System.out.println("稀疏数组转原始数组~~~~~~");
        for (int[] row : chessArray2) {
            for (int col : row) {
                System.out.printf("%d\t", col);
            }
            System.out.println();
        }

    }
}
