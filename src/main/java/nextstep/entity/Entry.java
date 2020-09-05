package nextstep.entity;

public class Entry {

    private final String name;

    public Entry(String name) {
        int length = name.length();
        if (length < 1 || length > 5) {
            throw new IllegalArgumentException("이름은 최소 1 글자, 최대 5 글자 까지 부여할 수 있어요.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
