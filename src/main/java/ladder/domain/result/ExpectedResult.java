package ladder.domain.result;

public class ExpectedResult {

    private final String result;

    public ExpectedResult(String result) {
        this.result = result;
    }

    public int getResultSize() {
        return result.length();
    }

    @Override
    public String toString() {
        return result;
    }
}
