package nextstep.ladder.domain.member;

public class Member {
    private final MemberName name;

    public Member(MemberName name) {
        this.name = name;
    }

    public static Member of(String name) {
        return new Member(MemberName.of(name));
    }

    public String getName() {
        return name.getName();
    }
}
