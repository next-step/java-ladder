package nextstep.entity;

public class Entry {

    private final String name;

    private Entry(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) throws IllegalArgumentException {
        int length = name.length();
        if (length < 1 || length > 5) {
            throw new IllegalArgumentException("이름은 최소 1 글자, 최대 5 글자 까지 부여할 수 있어요.");
        }
    }

    public static Entry of(String name) {
        return new Entry(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        return name.equals(entry.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
