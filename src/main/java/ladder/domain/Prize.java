package ladder.domain;

public class Prize {
    private final String name;

    private Prize(String name) {
        this.name = name;
    }

    public static Prize from(String name) {
        return new Prize(name);
    }

    public long length() {
        return name.length();
    }

    public String value() {
        return name;
    }
}
