package nextstep.ladder.domain;

public class PersonName {
    public static final int MAX_NAME_LENGTH = 5;

    private String name;

    public PersonName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Name is too long");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat((9 - name.length()) / 2));
        sb.append(name);
        sb.append(" ".repeat(9 - sb.length()));
        return sb.toString();
    }
}
