package ladder.domain;

public class Player {
    private final String name;

    public Player(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("이름의 최대길이는 5자입니다.");
        }
    }

    @Override
    public String toString() {
        return String.format("%6s", this.name);
    }
}
