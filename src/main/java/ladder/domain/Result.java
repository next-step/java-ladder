package ladder.domain;

public class Result {
    private final String name;

    private Result(String name) {
        this.name = name;
    }

    public static Result name(String resultName) {
        return new Result(resultName);
    }

    public String getName() {
        return name;
    }
}
