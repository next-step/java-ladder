package nextstep.domain;

public class Bonus {
    private static final Integer MAX_NAME_LENGTH = 5;
    private final String bonusName;
    private final Integer position;

    public Bonus(String bonusName, Integer position) {
        validate(bonusName);
        this.bonusName = bonusName;
        this.position = position;
    }

    public static Bonus of(String bonusName) {
        return new Bonus(bonusName, 0);
    }

    public static Bonus of(String bonusName, int position) {
        return new Bonus(bonusName, position);
    }

    private void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 빈 문자열이 될 수 없습니다.");
        }
        if (input.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 " + MAX_NAME_LENGTH + "자까지 허용됩니다.");
        }
    }

    public int position() {
        return position;
    }

    public boolean isMatch(int index){
        return position.equals(index);
    }

    public String getName() {
        return bonusName;
    }
}
