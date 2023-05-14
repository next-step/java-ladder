package nextstep.ladder.domain;

public class LadderResult {
    private final String result;

    public LadderResult(String result) {
        validateResult(result);

        this.result = result;
    }

    public String getResult() {
        return result;
    }

    private void validateResult(String result) {
        if (result == null || result.isEmpty()) {
            throw new IllegalArgumentException("결과가 입력되지 않았습니다.");
        }
    }

}