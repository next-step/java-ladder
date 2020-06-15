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
