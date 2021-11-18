package nextstep.ladder.exception;

@SuppressWarnings("serial")
public class UtilCreationException extends RuntimeException {
	public UtilCreationException() {
		super("유틸리티 클래스는 인스턴스를 생성할 수 없습니다.");
	}
}
