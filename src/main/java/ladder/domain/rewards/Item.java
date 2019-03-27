package ladder.domain.rewards;

public class Item {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Item(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException();
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    private static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    public String value() {
        return this.name;
    }
    @Override
    public String toString() {
        return beautify();
    }

    private String beautify() {
        return String.format("%" + (MAX_NAME_LENGTH + 1) + "s", name);
    }
}
