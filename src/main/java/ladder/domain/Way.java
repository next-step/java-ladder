package ladder.domain;

public enum Way {
    DOWN("     ", 0),
    LEFT("     ", -1),
    RIGHT("-----", 1);

    private final String load;
    private final int destination;

    Way(String load, int destination) {
        this.load = load;
        this.destination = destination;
    }

    public String getLoad() {
        return load;
    }

    public int getDestination() {
        return destination;
    }
}
