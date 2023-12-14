package nextstep.ladder.domain;

public class LadderInfo {
    private int height;
    private int numberOfLines;

    public LadderInfo(int height, int numberOfLines) {
        this.height = height;
        this.numberOfLines = numberOfLines;
    }

    public int getHeight() {
        return height;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    @Override
    public String toString() {
        return "LadderInfo{" +
                "height=" + height +
                ", numberOfLines=" + numberOfLines +
                '}';
    }
}
