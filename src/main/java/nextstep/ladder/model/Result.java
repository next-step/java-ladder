package nextstep.ladder.model;

public class Result {
    private final int position;
    private final String resultName;

    public Result(int position, String resultName) {
        this.position = position;
        this.resultName = resultName;
    }

    public String getResultName() {
        return resultName;
    }

}
