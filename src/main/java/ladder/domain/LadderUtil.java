package ladder.domain;

public enum LadderUtil {
    SEPARATOR_REST(",");

    private String value;

    LadderUtil(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    public static String[] splitName(String names) {
        return names.split(SEPARATOR_REST.getValue());
    }
}
