package Jian;
//剑指Offer04.二维数组中查找
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int r = 0,c = matrix[0].length - 1;
        while(r < matrix.length && c >= 0){
            if(target == matrix[r][c]){
                return true;
            }else if(target > matrix[r][c]){
                r++;
            }else{
                c--;
            }
        }
        return false;
    }
}
