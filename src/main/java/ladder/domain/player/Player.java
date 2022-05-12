package ladder.domain.player;

public class Player {
    private final Name name;

    public Player(String name) {
        this(Name.valueOf(name));
    }

    public Player(Name name) {
        validate(name);
        this.name = name;
    }

    private void validate(Name name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null 일 수 없습니다.");
        }
    }

    public String getName() {
        return name.getName();
    }
}
