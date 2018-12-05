public class Height {
	private int value;
	
	public Height(int valu) {
		if(value < 0) {
			throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
		}
		
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
