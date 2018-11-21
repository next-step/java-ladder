package domain;

public enum Difficult {
    상(20,12),
    중(10,5),
    하(5,2);

    private int height;
    private int random;

    Difficult(int height, int random) {
        this.height = height;
        this.random = random;
    }

    public int getHeight() {
        return height;
    }

    public int getRandom() {
        return random;
    }
}
