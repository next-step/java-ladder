package ladder.domain;

public class ResultValue {
    private String value;

    private ResultValue(String value) {
        this.value = value;
    }

    public static ResultValue getInstance(String value) {
        return new ResultValue(value);
    }

    public static ResultValue getNewInstance(ResultValue resultValue) {
        return new ResultValue(resultValue.value);
    }

    public static String valueOf(ResultValue resultValue) {
        return resultValue.value;
    }
}
