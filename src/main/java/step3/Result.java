package step3;

public class Result {
    private final String value;

    public Result(String value) {
        this.value = value;
    }

    public String toOutputString() {
        return this.value;
    }
}
