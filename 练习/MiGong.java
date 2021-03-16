package code_2021_0314;

public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟地图
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for(int i = 0;i < 7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for(int i = 0;i < 8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
        //输出地图
        for(int i = 0;i < 8;i++){
            for(int j = 0;j < 7;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }



    }
    //使用递归回溯来给小球找路
    //map表示地图
    //如果小球可以找到map[6][5]位置，则说明通路找到
    //当map[i][j]为0表示该点没有走过，当为1表示墙，2表示通路可以走；3表示该点已经走过，但是走不通
    //确定策略： 下->右->上->左，如果该点走不通，再回溯
    public static boolean setWay(int[][] map,int i,int j ){
        if(map[6][5] == 2){//通路已找到ok
            return true;
        }else{
            if(map[i][j] == 0){//如果当前这个点还没有走过
                //按照策略 下->右->上->左->走
                map[i][j] = 2;//嘉定该点是可以走通的
                if(setWay(map,i,j+1)){//向下走
                    return true;
                }else if(setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,i,j-1)){
                    return true;
                }else{
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
