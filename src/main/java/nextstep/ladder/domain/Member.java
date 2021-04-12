package nextstep.ladder.domain;

public class Member {

    public static final int NAME_MAX_LENGTH = 5;
    public final String name;

    private Member(String name) {
        this.name = name;
    }

    public static Member of(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new NameLengthExceededException("참여자 이름은 " + NAME_MAX_LENGTH + "글자 이하여야 합니다.");
        }
        return new Member(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
