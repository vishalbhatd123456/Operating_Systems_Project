import java.util.*;
public class Req {
	public static void validateRequest(int req[],int lr[],int rr[])
	{
		//comparison between the request process size and the limit size in lr
		for(int i=0;i<rr.length;i++)
		{
			if(req[i]>lr[i])
			{
				System.out.println("Process number:"+i);
				System.out.println("Illegal Access\n");
				continue;
			}
			else
			{
				System.out.println("the process number is"+i);
				System.out.println("The fetch address is   "+(rr[i]+req[i]));
			}
		}
	}
	public static void main(String[] args) {
		int rr[] = {1200,550,880,1400,200};
		int lr[]={500,275,212,420,118};
		int req[] = {450,300,210,450,200};
		validateRequest(req, lr, rr);
	}

}
