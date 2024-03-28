package ladder2.domain;

public class Prize {

    private final int index;
    private final String name;

    public Prize(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int index() {
        return index;
    }

    public String name() {
        return name;
    }
}
