package nextstep.ladder;

public class Result {
    private Username username;
    private String resultValue;

    public Result(Username username, String resultValue) {
        this.username = username;
        this.resultValue = resultValue;
    }

    public String getResultValue() {
        return this.resultValue;
    }
}
