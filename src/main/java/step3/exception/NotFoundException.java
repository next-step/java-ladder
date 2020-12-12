package step3.exception;

public class NotFoundException extends IllegalArgumentException {
    public NotFoundException(String name) {
        super(String.format("입력하신 참여자를 찾을 수 없습니다. (입력한 참여자 이름: %s)", name));
    }
}
