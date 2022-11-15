package ladder.domain;

public class Result
{
    private String result;

    private Result(String result)
    {
        this.result = result;
    }

    public static Result from(String result) {
        return new Result(result);
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return result;
    }
}
