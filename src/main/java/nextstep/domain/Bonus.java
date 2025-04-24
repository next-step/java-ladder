package nextstep.domain;

public class Bonus {
    private static final Integer MAX_NAME_LENGTH = 5;
    private final String bonusName;

    public Bonus(String bonusName) {
        validate(bonusName);
        this.bonusName = bonusName;
    }

    public static Bonus of(String bonusName) {
        return new Bonus(bonusName);
    }

    private void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 빈 문자열이 될 수 없습니다.");
        }
        if (input.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 " + MAX_NAME_LENGTH + "자까지 허용됩니다.");
        }
    }

    @Override
    public String toString() {
        return bonusName;
    }
}
