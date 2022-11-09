package ladder.backEnd.domain;

public class Name {

    private static final int MAX_SIZE = 5;

    private String value;

    public Name(String name) {
        checkSize(name);
        this.value = name;
    }

    private void checkSize(String name) {
        if (name.length() > MAX_SIZE) {
            throw new IllegalArgumentException("이름의 길이는 5글자를 넘길 수 없습니다.");
        }
    }

    public String getName() {
        return value;
    }
}
