package domain;

public enum DifficultyLevel {
    상(10, 0.8),
    중(7, 0.6),
    하(4, 0.4);

    private int height;
    private double probability;

    DifficultyLevel(int height, double probability) {
        this.height = height;
        this.probability = probability;
    }

    public Movable generateMovableFrom(Boolean currentMovable) {
        if (currentMovable) {
            return Movable.FALSE;
        }

        if (Math.random() <= probability) {
            return Movable.TRUE;
        }

        return Movable.FALSE;
    }

    public int getHeight() {
        return height;
    }
}
