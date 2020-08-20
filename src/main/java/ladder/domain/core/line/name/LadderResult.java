package ladder.domain.core.line.name;

final class LadderResult extends BaseName {
    private static final int MAX_LEN = 5;
    static final String ERROR_MESSAGE_MAX_LEN_NAME = String.format("지정된 이름의 최대 길이는 %d자 입니다.", MAX_LEN);

    public LadderResult(String name) {
        super(name);
        verifyMaxLength();
    }

    private void verifyMaxLength() {
        if (MAX_LEN < getName().length()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MAX_LEN_NAME);
        }
    }
}
