package study2.domain;

public class Height {

	private int height;
	
	public Height(int height) {
		heightLimitation(height);		
		this.height = height;
	}
	private void heightLimitation(int height) {
		if(height < 1) {
			throw new IllegalArgumentException("사다리의 높이가 1보다 커야합니다.");
		}
	}
	
	public int getHeight() {
		return height;
	}
		
	// Question 	
	// 이클립스를 사용중입니다.
	// hashCode와 equals 메소드를 자동완성하면
	// Intelli J와 코드가 조금 다른거같은데 혹시 아시나요?
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)	return true;
		if (obj == null)	return false;
		if (getClass() != obj.getClass())	return false;
		Height other = (Height) obj;
		if (height != other.height)		return false;
		return true;
	}
	
	
	
}
