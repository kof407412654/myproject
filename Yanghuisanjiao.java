package Chapter9;

import java.util.Scanner;

public class Yanghui {

	public static void main(String[] args) {
		// yanghui
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the line number：");
		int rows = input.nextInt();
		int[] a = new int[rows+2];
		a[1] = 1;
		int[] b = new int[rows+2];
		
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= rows+1-i; j++) {
				System.out.print("  ");
			}
			
			for (int j = 0; j < i; j++) {
				if (i==1) {
					System.out.print(a[1]);
					b[1]=a[1];
					break;
				}
				b[j+1] = a[j] + a[j+1];
				System.out.print(b[j+1] + "   ");
			}
			for (int j = 0; j < 2+i; j++) {
				a[j] = b[j];
				b[j]=0;
			}
			System.out.println();
		}
		
	}

}
