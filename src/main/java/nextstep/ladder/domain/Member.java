package nextstep.ladder.domain;

public class Member {
    private final String name;

    public Member(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }


    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(name + " : 이름은 5자를 초과할수 없습니다");
        }
    }
}
