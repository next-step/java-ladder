package nextstep.ladder.model;

public class Prize {
    private String value;

    public Prize(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("Prize value cannot be blank");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
