package HW2;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Memory_Allocation memo=new Memory_Allocation(1000000);
		Scanner sc=new Scanner(System.in);
		
		System.out.print("�Է¿���:\n"
				+ "�޸� �Ҵ�� +�Է�(����)���ϴ� ��� number(����)���ϴ� ũ��\n"
				+ "�޸� ������ -�Է�(����)���ϴ� ��� number");
		String line=sc.nextLine();

		while(!line.equals("Q")) {

			//Get the input

			String[] input=line.split(" ");

			if(input.length == 3) 
					memo.myMalloc("+",input[1],Integer.parseInt(input[2]));
			else if(input.length == 2)
				memo.myFree("-" , input[1]);
							
			memo.printMemoryList();
			System.out.print("���Ḧ ���ϸ� Q�� �ƴ϶�� ���� ���ô�� ��� �Է��ϼ���: ");
			line=sc.nextLine();
			
			if(line.equals("Q"))
				System.out.println("����");
			}
		}
}