package ladder.domain.line;

public class LineCountException extends RuntimeException {

	private static final String DEFAULT_MESSAGE = "라인은 1개 이상 생성 가능합니다.";

	public LineCountException() {
		super(DEFAULT_MESSAGE);
	}

}
