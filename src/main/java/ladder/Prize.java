package ladder;

public class Prize {

    private final String name;

    public Prize(String name) {
        this.name = name;
    }

    public static Prize of(String name) {
        return new Prize(name);
    }
}
