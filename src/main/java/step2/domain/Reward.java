package step2.domain;

public class Reward {

    final String name;

    private Reward(String name) {
        this.name = name;
    }

    public static Reward of(String name) {
        return new Reward(name);
    }

    public String getName() {
        return name;
    }
}
