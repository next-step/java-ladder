package domain;

public enum Level {
    하(5),
    중(10),
    상(20);

    private int depthOfLadders;

    private Level(int depthOfLadders) {
        this.depthOfLadders = depthOfLadders;
    }

    public int getDepthOfLadders() {
        return depthOfLadders;
    }

}
