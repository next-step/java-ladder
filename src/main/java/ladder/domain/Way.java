package ladder.domain;

public enum Way {
    DOWN("     "),
    LEFT("     "),
    RIGHT("-----");

    private final String load;

    Way(String load) {
        this.load = load;
    }

    public void print() {
        System.out.print(this.load);
    }
}
