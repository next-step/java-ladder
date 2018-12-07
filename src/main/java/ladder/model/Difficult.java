package ladder.model;

import java.util.Arrays;
import java.util.Random;

public enum Difficult {
    HIGH("상", 20, 0.7),
    MIDDLE("중", 10, 0.5),
    LOW("하", 5, 0.2);

    private String level;
    private int height;
    private double lineRatio;

    Difficult(String level, int height, double lineRatio) {
        this.level = level;
        this.height = height;
        this.lineRatio = lineRatio;
    }

    public static Difficult of(String level) {
        return Arrays.stream(Difficult.values())
                .filter(difficult -> difficult.level.equals(level))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public String getLevel() {
        return level;
    }

    public int getHeight() {
        return height;
    }

    public double getLineRatio() {
        return lineRatio;
    }

    public boolean generatePoint() {
        Random random = new Random();

        double randomValue = random.nextDouble();
        if(randomValue < this.lineRatio) {
            return true;
        }
        return false;
    }
}
