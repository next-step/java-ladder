package nextstep.ladder.domain;

public class LadderResult {
    private String result;

    public LadderResult(String result) {
        validResult (result);
        this.result = result;
    }

    private void validResult(String result) {
        if(result == null || result.isEmpty()) {
            throw new IllegalArgumentException("결과 값이 비어있습니다.");
        }
    }

    public String getResult() {
        return result;
    }
}
