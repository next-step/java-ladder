package nextstep.ladder.exception;

import nextstep.ladder.domain.Point;

public class InvalidMidPointException extends RuntimeException {

	private static final String MESSAGE = "유효하지 않은 연결이 존재합니다. (현재: %s, 다음: %s)";

	public InvalidMidPointException(Point current, Point next) {
		super(String.format(MESSAGE, current.direction(), next.direction()));
	}
}
