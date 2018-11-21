package ladder.domain;

public class Result {

    private String result;

    public Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Result otherResult = (Result)obj;
        return this.result.equals(otherResult.getResult());
    }
}
