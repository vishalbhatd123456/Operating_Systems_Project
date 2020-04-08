import java.util.*;
public class LimitRegSimpleWorking {
	public static void LimitReg(int size[],int ProcessSize,int n)
	{
		//access a particular address of the process, the limit register shall kepp track of the access size
		for(int i=0;i<n;i++)
		{
			if(size[i]>ProcessSize)
			{
				System.out.println("----------------------------Illegal memory access in memory --------------------");break;
			}
			else
			{
				System.out.println("Can access the instruction of present");
			}
		}
		
		
	}
	public static void main(String[] args) {
		System.out.println("Enter the number of processes");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println("Enter the mex size of the process");
		int pSize = scan.nextInt();
		
		int isize[] = new int[n];
		System.out.println("Enter the instruction to be accessed");
		for(int i=0;i<n;i++)
			isize[i] = scan.nextInt();
		LimitReg(isize,pSize,n);
		scan.close();
		
	}

}
