
public class FirstFit {
	static void FirstFit(int blockSize[], int p, int processSize[], int s)
	{
		//code to store the block id for the block allocation
		int allocate[] = new int[s];
		//no block assigned in the beginning
		for(int i=0;i<allocate.length;i++)
			allocate[i] = -1;
		//pick every provess and look for a suitable block
		for(int i=0;i<s;i++)
		{
			for(int j=0;j<p;j++)
			{
				if(blockSize[j] >= processSize[i])
				{
					//allocation of block j to the p[i] process
					allocate[i] = j;
					//update the available memory in the system
					blockSize[j] = blockSize[j] - processSize[i];
					break;
				}
			}
		}//end of for loop
		System.out.println("\nProcess Number\t Process Size\t Block Size.");
		for(int i=0;i<s;i++)
		{
			System.out.print(" "+(i+1)+"\t\t"+processSize[i]+"\t\t");
			if(allocate[i] != -1)
				System.out.println(allocate[i]+1);
			else
				System.out.print("Not Allocatted Process");
			System.out.println();
		}
	}
	//driver code
	public static void main(String[] args) {
		int blockSize[] = {100,500,200,300,600};
		int processSize[] = {212,417,112,426};
		int p = blockSize.length;
		int s = processSize.length;
		FirstFit(blockSize, p, processSize, s);
		}
	}


