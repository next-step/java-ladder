package ladder.model;

public class LadderResult {
    private final String result;

    LadderResult(String result) {
        validateNotEmpty(result);
        this.result = result;
    }

    private void validateNotEmpty(String result) {
        if (result == null || result.trim().isEmpty()) {
            throw new IllegalArgumentException("사다리 결과가 비었습니다.");
        }
    }
}
