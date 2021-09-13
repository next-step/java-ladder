package nextstep.ladder.model;

public class Name {
    public static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름 길이는 5자를 넘을 수 없습니다!");
        }

        this.name = name;
    }

    public int length() {
        return name.length();
    }

    @Override
    public String toString() {
        return name;
    }
}
