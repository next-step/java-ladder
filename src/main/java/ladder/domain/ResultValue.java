package ladder.domain;

public class ResultValue {
    private String value;

    private ResultValue(String value) {
        this.value = value;
    }

    public static ResultValue getInstance(String value) {
        return new ResultValue(value);
    }
}
