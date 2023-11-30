package ladder.model;

public class Prize {

    private final String value;

    public Prize(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("사다리 게임 결과를 입력해주세요");
        }
    }

    public String getValue() {
        return this.value;
    }
}
