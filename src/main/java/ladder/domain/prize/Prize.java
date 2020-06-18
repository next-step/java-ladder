package ladder.domain.prize;

public class Prize {

    private final String name;

    public Prize(String name) {
        this.name = name;
    }

    public static Prize of(String name) {
        return new Prize(name);
    }

    public String getName() {
        return name;
    }
}
