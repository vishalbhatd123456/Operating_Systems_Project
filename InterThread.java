class MyClass
{
	int n;
	boolean flag = false;
	
	synchronized int get()
	{
		//read & write is performed using the toggle
		if(!flag)
		
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		
			System.out.println("Consumer consuming:"+n);
			flag = false; //this indicates that the given consumer has not updated the contents of the flag
			notify();
			return n;
		
	}

		synchronized void put(int n)
		{
			if(flag)
			
				try
				{
					wait();
				}
				catch(InterruptedException e)
				{
					System.out.println("interrupted Exception");
				}
				this.n = n;
				flag = true;
				System.out.println("Product producing:"+n);
				notify();
			
		}
}
		
	class Producer implements Runnable
	{
		MyClass obj;
		public Producer(MyClass obj) {
			// TODO Auto-generated constructor stub
			this.obj = obj;
			new Thread(this,"Producer").start();
		}
		public void run()
		{
			for(int i =0;i<10;i++)
			{
				obj.put(i);
			}
		}
	}
	class Consumer implements Runnable
	{
		MyClass obj;
		public Consumer(MyClass obj) {
			// TODO Auto-generated constructor stub
			this.obj = obj;
			new Thread(this,"Consumer").start();
		}
		public void run()
		{
			for(int i =0;i<10;i++)
			{
				obj.get();
			}
		}
	}
public class InterThread {
	public static void main(String[] args) {
		MyClass TObj = new MyClass();
		
		new Producer(TObj);
		new Consumer(TObj);
		
	}
}


