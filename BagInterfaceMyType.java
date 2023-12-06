
public interface BagInterfaceMyType<MyType> {
	//Implemented methods into Shopping Cart
	
	public void add(MyType anEntry);
	
	public int getCurrentSize();
	
	public MyType remove();
	
	public boolean isEmpty();
	
	public void clear();
	
	public MyType[] toArray();
	
	public boolean isFull();
	
}
