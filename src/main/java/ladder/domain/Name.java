package ladder.domain;

public class Name {
    public static final int MAX_LENGTH = 5;
    private final String name;

    private Name(String name) {
        if(name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("참여할 사람의 이름은 최대 5글자까지만 입력가능합니다.");
        }
        this.name = name;
    }

    public static Name from(String name) {
        return new Name(name);
    }
}
