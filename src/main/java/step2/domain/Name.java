package step2.domain;

public class Name {
    private static final int NAME_MAX_SIZE=5;
    private static final int NAME_MIN_SIZE=1;
    private final String name;

    public Name(String name) {
        if (name.length() >= NAME_MAX_SIZE || name.length() <= NAME_MIN_SIZE) {
            throw new IllegalArgumentException("이름은 최소 1글자 최대 5글자까지 부여할 수 있습니다.");
        }
        this.name = name;
    }
}
