package ladder.game;

public class Ladder {
    private boolean[][] ladder;

    public Ladder(int personCount, int ladderHeight) {
        ladder = new boolean[ladderHeight][personCount - 1];
        createLadder();
    }

    public boolean[][] getLadder() {
        return this.ladder;
    }

    private void createLadder() {
        for (boolean[] line : ladder) {
            drawLine(line);
        }
    }

    private void drawLine(boolean[] line) {
        int ladderWidth = line.length;
        for (int width = 0; width < ladderWidth; width++) {
            line[width] = ladderDraw(line, width);
        }
    }

    private boolean ladderDraw(boolean[] line, int width) {
        if (width != 0 && line[width - 1]) {
            return false;
        }
        return random(() -> Math.random() * 10 < 5);
    }

    private boolean random(DrawLineStrategy drawLineStrategy) {
        return drawLineStrategy.draw();
    }
}
