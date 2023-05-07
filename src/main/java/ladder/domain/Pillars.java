package ladder.domain;

public class Pillars {
    private final int height;
    private final int count;

    public Pillars(int height, int count) {
        this.height = height;
        this.count = count;
    }

    public String pillarRender() {
        return "|".repeat(height);
    }

    public int getCount() {
        return count;
    }
}
