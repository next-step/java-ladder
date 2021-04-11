package nextstep.ladder.domain;

public class Member {
    public final String name;

    private Member(String name) {
        this.name = name;
    }

    public static Member from(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("참여자 이름은 5글자 이하여야 합니다.");
        }
        return new Member(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
