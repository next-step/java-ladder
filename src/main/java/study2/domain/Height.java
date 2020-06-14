package study2.domain;

public class Height {

	private int height;
	
	private Height(int height) {
		heightLimitation(height);		
		this.height = height;
	}
	private void heightLimitation(int height) {
		if(height < 1) {
			throw new IllegalArgumentException("사다리의 높이가 1보다 커야합니다.");
		}
	}
}
