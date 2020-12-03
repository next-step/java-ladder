package nextstep.ladder.domain;

public class IndexedName {
    public static final int MAX_NAME_LENGTH = 5;
    private final int index;
    private final String name;

    public IndexedName(int index, String name) {
        ensureValidParameter(index, name);
        ensureNameLength(name);
        this.index = index;
        this.name = name;
    }

    private void ensureValidParameter(int index, String name) {
        if (index < 0 || name == null) {
            throw new IllegalArgumentException("이름/인덱스가 올바르지 않습니다");
        }
    }

    private void ensureNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 %d자 이하여야 합니다.", MAX_NAME_LENGTH));
        }
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return name;
    }
}
