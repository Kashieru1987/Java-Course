public class Item {
	final String name;
	final int numberStored;
	final double price;

	public Item(String name, int numberStored, double price) {
		this.name = name;
		this.numberStored = numberStored;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item{" +
				"name='" + name + '\'' +
				", numberStored=" + numberStored +
				", price=" + price +
				'}';
	}
}
