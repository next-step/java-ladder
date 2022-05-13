package ladder.domain.reward;

public class Reward {
    private final String name;

    public Reward(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null 일 수 없습니다.");
        }
    }
}
