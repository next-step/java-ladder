package nextstep.ladder.step2.domain;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;
    private String name;

    public Name(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자만 허용 합니다.");
        }
        this.name = name;
    }
}
