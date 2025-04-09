package nextstep.ladder.domain.user;

public class LadderUser {

    private static final int MIN_WIDTH = 5;
    private final String value;

    public LadderUser(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5자를 넘을 수 없습니다.");
        }
        this.value = name;
    }

    @Override
    public String toString() {
        if (value.length() >= MIN_WIDTH) {
            return value;
        }
        int leftPadding = (MIN_WIDTH - value.length()) / 2;
        int rightPadding = MIN_WIDTH - value.length() - leftPadding;
        return " ".repeat(leftPadding) + value + " ".repeat(rightPadding);
    }
}
