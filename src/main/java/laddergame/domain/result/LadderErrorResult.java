package laddergame.domain.result;

public class LadderErrorResult implements Printable {

	private String message;

	public LadderErrorResult(String message) {
		this.message = message;
	}

	@Override
	public String print() {
		return message;
	}
}
