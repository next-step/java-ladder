package ladder.domain;

public class LadderResult {

    private final String result;

    private LadderResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }

    public static LadderResult from(String result) {
        return new LadderResult(result);
    }

}
