package HW2;

public class MemBlock {
	
	String allocOrFree;
	String bID;
	int bSize;
	int start;
	int end;
	boolean hole;
	MemBlock next;
	
	public MemBlock(String allocOrFree, String bID, int bSize) {
		this.allocOrFree = allocOrFree;
		this.bID = bID;
		this.bSize = bSize;
		this.start = 0;
		this.end = this.start + this.bSize - 1;
		this.hole = true;
		this.next = null;
	}
}
