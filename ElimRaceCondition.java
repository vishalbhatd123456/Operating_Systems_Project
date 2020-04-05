class Counter1 implements Runnable{
	private int c=0;
	public void increment(){
		try{
			Thread.sleep(100);
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
		synchronized (this) {
			//incrementing
			this.increment();
			System.out.println("The value during increment is"+Thread.currentThread().getName()+"  "+this.getValue());
			this.decrement();
			System.out.println("The value during decrement is"+Thread.currentThread().getName()+"  "+this.getValue());
			
		}
		
	}
	
}
public class ElimRaceCondition {
public static void main(String[] args) {
	Counter1 c = new Counter1();
	Thread t1 = new Thread(c,"Thread-1");
	Thread t2 = new Thread(c, "Thread-2");
	Thread t3 = new Thread(c, "Thread-3");
	t1.start();
	t2.start();
	t3.start();
}
}
