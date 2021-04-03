package step4_ladderGame.domain;

public class Name {

    private final String name;

    private Name(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("플레이어 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    public String toString() {
        return name;
    }
}
