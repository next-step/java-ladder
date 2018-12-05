public class Positive {
	private int value;
	
	public Positive(int value) {
		if(value < 0) {
			throw new IllegalArgumentException();
		}
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
