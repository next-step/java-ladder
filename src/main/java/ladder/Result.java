package ladder;

public class Result {
    private String result;

    private Result(String result) {
        this.result = result;
    }

    public static Result of(String result) {
        return new Result(result);
    }

    public String getResult() {
        return result;
    }

    public String getResultPad() {
        this.result += "     ";
        return this.result.substring(0, 6);
    }
}
