package ladder.domain;

public class Target {
    private final String name;

    public Target(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isContinue() {
        return !name.equals("all");
    }
}
