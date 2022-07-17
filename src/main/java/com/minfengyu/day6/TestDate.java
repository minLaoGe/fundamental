package com.minfengyu.day6;

public class TestDate {
    public static void main(String[] args) throws InterruptedException {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        int i = numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(i);
        String sdf="sdf";
        for (int j = 0; j < sdf.length(); j++) {
            char c = sdf.charAt(i);

        }
    }

}
class NumMatrix {


    int[][] mat=null;
    public NumMatrix(int[][] matrix) {
        mat=matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int lowrow= Math.min(row1, row2);
        int highrow= Math.max(row1, row2);
        int lowcol= Math.min(col1, col2);
        int highcol= Math.max(col1, col2);

        int sum=0;
        int upleft=0;
        int up=0;
        int down=0;
        for(int i=0;i<=highrow;i++){
//            int[] arr2=mat[i];

            for(int j=0;j<=highcol;j++){
                sum+=mat[i][j];
                if(i<lowrow){
                    up+=mat[i][j];
                }
                if(j<lowcol-1){
                    down+=mat[i][j];
                }
                if(i<lowrow-1&&j<lowcol-1){
                    upleft+=mat[i][j];
                }
            }
        }

        return sum-(up+down-upleft);

    }
}