package nextstep.ladder.domain.result;

public class Result {
    private final String value;

    public Result(String value) {
        assertNotBlank(value);

        this.value = value;
    }

    private void assertNotBlank(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("사다리 게임 결과를 입력해주세요.");
        }
    }
}
