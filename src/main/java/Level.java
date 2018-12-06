import java.util.Arrays;

public enum Level {
    상("상", new Positive(22), new Positive(60)),
    중("중", new Positive(11), new Positive(30)),
    하("하", new Positive(5), new Positive(15));

    Level(String level, Positive height, Positive probability) {
        this.level = level;
        this.height = height;
        this.probability = probability;
    }

    private String level;
    private Positive height;
    private Positive probability;
    public String getLevel() {
        return level;
    }

    public Positive getHeight() {
        return height;
    }

    public Positive getProbability() {
        return probability;
    }

    public static Level getLevel(String level) {
        return Arrays.stream(Level.values())
                .filter(l -> l.getLevel().equals(level))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
