package laddergame.domain;

public class Result {

	private String value;

	public Result(String value) {
		this.value = value;
	}

	public String getFormattedValue() {
		return String.format("%" + Player.MAX_NAME_LENGTH + "s", value);
	}

	@Override
	public String toString() {
		return value;
	}
}
