class Counter implements Runnable
{

	private int c = 0;
	public void increment()
	{
		try
		{
			Thread.sleep(10);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		c++;
	}
	public void decrement()
	{
		c--;
	}
	public int getValue()
	{
		return c;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.increment();
		System.out.println("Value for the Thread after increment:"+Thread.currentThread().getName()+" "+this.getValue());
		//decrement method call
		this.decrement();
		System.out.println("Value of the Thread at the last:"+Thread.currentThread()+" "+this.getValue());
		
		
	}
	
}
public class RaceConditionDemo {
public static void main(String[] args) {
	Counter c1 = new Counter();
	Thread t1 = new Thread(c1,"thread-1");
	Thread t2 = new Thread(c1,"thread-2");
	Thread t3 = new Thread(c1, "Thread-3");
	t1.start();
	t2.start();
	t3.start();
}
}
