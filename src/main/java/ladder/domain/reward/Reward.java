package ladder.domain.reward;

import ladder.domain.player.Name;

public class Reward {
    private final Name name;

    public Reward(String name) {
        this(Name.valueOf(name));
    }

    public Reward(Name name) {
        validate(name);
        this.name = name;
    }

    private void validate(Name name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null 일 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
