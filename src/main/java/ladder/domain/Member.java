package ladder.domain;

public class Member {
    private final String name;

    public Member(String name) {
        if (isOutOfBoundLength(name)) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean isOutOfBoundLength(String name) {
        return name.length() > 5;
    }

}
