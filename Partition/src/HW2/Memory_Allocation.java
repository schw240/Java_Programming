package HW2;

public class Memory_Allocation{

	MemBlock block;
	int total_memory;

	public Memory_Allocation(int total_memory){

		this.total_memory=total_memory;
		block=new MemBlock("+","Initial",total_memory);

	}


	//allocates memory to a process

	public void myMalloc(String allocOrFree, String bID, int bSize){
		
		MemBlock cur=this.block;
		MemBlock bestfit=new MemBlock("+", "bestfit",this.total_memory);
					
	
		
		while(cur!=null){

			if(cur.hole==true){
					int free_memory=(cur.end+1)-cur.start;
					cur.bSize=(cur.end+1)-cur.start;
	
					if(free_memory >= bSize && free_memory <= bestfit.bSize){
						//finds the bestfit
						bestfit=cur;
						bestfit.bSize=cur.bSize;
					}
				}
			cur=cur.next;
		}
		
		//if process size > space in memory
		if(bestfit.bID=="bestfit")
			System.out.println("Not enough space for new process "+bID+" size: "+bSize);
		else{	
			MemBlock new_process =new MemBlock("+", bID, bSize);
			
			if(new_process.next.bID == bID)
				System.out.println("Hi");
			
			new_process.next=bestfit.next;
			bestfit.next=new_process;
			new_process.end=bestfit.end;
			bestfit.end=bestfit.start+bSize-1;
			new_process.start=bestfit.end+1;
			bestfit.bID=bID;
			bestfit.hole=false;	
		}
	

	}
	


	//free the memory in block

	public void myFree(String allocOrFree, String bID){

		MemBlock cur=this.block;


		while(cur!=null && !cur.bID.equals(bID))
			cur=cur.next;

		if(cur==null)
			System.out.println("There is no such process. Please enter a valid process ID");
		else{
			cur.hole=true;
			cur.bID= "Hole";
		}

		MemBlock current=this.block;


		//merge
		while(current.next!=null){

			if(current.hole==true && current.next.hole==true){
				current.end=current.next.end;
				current.next=current.next.next;
				continue;
			}
			else
				current=current.next;
		}
	}


	//print the memorylist

	public void printMemoryList(){

		System.out.println("\nMemory state:");
		MemBlock cur=this.block;
		System.out.println();

		while(cur!=null){

			if(cur.hole==true && cur.start<cur.end)
					System.out.println("Free space: " + "<" + cur.start + " - " + cur.end + ">" + " Size: " + (cur.end-cur.start+1) + " bytes");
			else if (cur.start<cur.end)
				System.out.println("Process: " + cur.bID + " <" + cur.start + " - " + cur.end + ">" + " Size: " + (cur.end-cur.start+1) + " bytes");

			cur=cur.next;
		}
	}
}