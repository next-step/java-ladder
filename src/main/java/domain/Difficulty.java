package domain;

import java.util.Arrays;
import java.util.Random;

public enum Difficulty {
    HARD("상", 20, 5),
    NORMAL("중", 15, 10),
    EASY("하", 5, 15);

    private final String level;
    private final int height;
    private final int probability;

    Difficulty(String level, int height, int probability) {
        this.level = level;
        this.height = height;
        this.probability = probability;
    }

    public String getLevel() {
        return level;
    }

    public int getHeight() {
        return height;
    }

    public int getProbability() {
        return probability;
    }

    public static Difficulty from(String level) {
        return Arrays.stream(Difficulty.values()).filter(d -> d.level.equals(level)).findAny().orElseThrow(IllegalArgumentException::new);
    }

    public boolean generatePoint() {
        Random rand = new Random();
        if(rand.nextInt(30) > probability) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Difficulty{" +
                "level='" + level + '\'' +
                ", height=" + height +
                ", probability=" + probability +
                '}';
    }
}
