package myproject;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = 0;
		String x = "";
		while(true){
			System.out.print("请输入一个整数，输入非整数退出：");
			try {
				x="";
				num = input.nextInt();
			} catch (Exception e) {
				System.err.println("非整数，退出！");
				break;
			}
			
			do {
				x=num%2+x;
				num/=2;
			} while (num!=0);
			System.out.printf("二进制数为：%s\n",x);
		}
	}

}
