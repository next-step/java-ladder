package nextstep.ladder.domain.member;

public class Member {
    private final MemberName name;
    private final int position;

    public Member(MemberName name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Member of(String name, int position) {
        return new Member(MemberName.of(name), position);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public boolean hasName(MemberName name) {
        return this.name.equals(name);
    }
}
