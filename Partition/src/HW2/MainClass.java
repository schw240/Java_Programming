package HW2;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Memory_Allocation memo=new Memory_Allocation(1000000);
		Scanner sc=new Scanner(System.in);
		
		System.out.print("입력예시:\n"
				+ "메모리 할당시 +입력(공백)원하는 블록 number(공백)원하는 크기\n"
				+ "메모리 해제시 -입력(공백)원하는 블록 number");
		String line=sc.nextLine();

		while(!line.equals("Q")) {

			//Get the input

			String[] input=line.split(" ");

			if(input.length == 3) 
					memo.myMalloc("+",input[1],Integer.parseInt(input[2]));
			else if(input.length == 2)
				memo.myFree("-" , input[1]);
							
			memo.printMemoryList();
			System.out.print("종료를 원하면 Q를 아니라면 위의 예시대로 계속 입력하세요: ");
			line=sc.nextLine();
			
			if(line.equals("Q"))
				System.out.println("종료");
			}
		}
}