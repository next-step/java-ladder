package ladder.dto;

public class HeightDto {

	private final int height;

	private HeightDto(int height) {
		this.height = height;
	}

	public static HeightDto of(int height) {
		return new HeightDto(height);
	}

	public int value() {
		return height;
	}

}
