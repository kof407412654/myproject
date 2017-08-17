package myproject;
/**
 * 二维数组转置
 * @author devuser
 *
 */
public class Transposition_Arrays2D {

	public static void main(String[] args) {
		int[][] a = new int[3][4];
		int num=1;
		for (int i = 0; i < 3; i++) {	//3行4列的二位数组，值为1-12
			for (int j = 0; j < 4; j++) {
				a[i][j]=num++;
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		int[][] b = new int[4][3];
		System.out.println();
		for (int i = 0; i < 4; i++) {	
			for (int j = 0; j < 3; j++) {
				b[i][j]=a[j][i];
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
