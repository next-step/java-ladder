package nextstep.ladder.domain;

/**
 * @author han
 */
public class Name {

    private static final int MAXIMUM_SIZE = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        valid(name);
        return new Name(name);
    }

    private static void valid(String name) {
        if (name == null || name.isEmpty() || name.length() > MAXIMUM_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(name);
        return sb.toString();
    }
}
