import java.util.Arrays;

public class ShoppingCart<MyType> implements BagInterfaceMyType<MyType> { //cart implements interface
    
	//fields
	private MyType[] myBag;
    private int numberOfProducts;
    private static final int DEFAULT_CAPACITY = 15;  //carts default cap is 15

    // constructors for myBag initialization 
    @SuppressWarnings("unchecked")
	public ShoppingCart() {
        myBag = (MyType[]) new Object[DEFAULT_CAPACITY];
        numberOfProducts = 0; //starts cart with 0 products inside
    }

    //methods
    @Override
    public void add(MyType newEntry) {
        myBag[numberOfProducts] = newEntry;
        numberOfProducts++;
    }
    
	@Override
	public int getCurrentSize() {
		return numberOfProducts;
	}

	@Override
	public MyType remove() {
		MyType result = null;
		if (!isEmpty()) {
			result = myBag[numberOfProducts - 1];
			myBag[numberOfProducts] = null;
			numberOfProducts--;
		}
		return result;
	}

	@Override
	public void clear() {
		while (!isEmpty())
			remove();	
	}

    @Override
    public MyType[] toArray() {
        return Arrays.copyOf(myBag, numberOfProducts);
    }

    @Override
    public boolean isFull() {  //checks if cart is at max cap by checking length of array
        return numberOfProducts >= myBag.length;
    }
    
   //main program
    public static void main(String[] args) {
        BagDemo(); //calls test demo
    }

    //BagDemo 
    public static void BagDemo() {
        ShoppingCart<String> cartTest = new ShoppingCart<>();
        
        // tests by adding a few new items to bag
        cartTest.testAdd();
        cartTest.add("Hot Dogs");
        cartTest.add("Bread");
        cartTest.add("Water Bottles");
        cartTest.add("Chips");
        cartTest.add("Milk");
        cartTest.add("Soda");
        
        // display method in demo
        cartTest.displayBag();
    }
    
    //Test method
    public void testAdd() {
    	System.out.println("Adding Items to cart");
    	System.out.println("--------------------------");
    }
	// Method to display the contents of the bag
    public void displayBag() {
        MyType[] data = toArray(); //to array method
        System.out.println("Products currently in cart:");
        for (MyType products:data) {
            System.out.println(products);
        }
        System.out.println("--------------------------");
    }


}
