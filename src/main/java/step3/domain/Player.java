package step3.domain;

public class Player {
    private static final int LENGTH = 5;
    private final String name;

    public Player(String name) {
        validatePlayer(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validatePlayer(String name) {
        if (name.length() > LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 5자를 초과하거나 공백일 수 없습니다. (입력값: " + name + ")");
        }
    }
}
