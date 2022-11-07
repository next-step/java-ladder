package ladder.domain.line;

public class Bar {

    private final boolean available;

    public Bar(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return this.available;
    }
}
