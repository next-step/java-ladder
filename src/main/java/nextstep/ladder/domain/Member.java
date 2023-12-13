package nextstep.ladder.domain;

public class Member {
    private String name;

    public Member(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5 || name.length() <= 0) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 부여할 수 있다.");
        }
    }

    public String getName() {
        return name;
    }
}
