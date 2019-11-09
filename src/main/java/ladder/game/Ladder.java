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

    public int getHeight() {
        return ladder.length;
    }

    public int getWidth() {
        return ladder[0].length;
    }

    private void createLadder() {
        for (boolean[] line : ladder) {
            drawLine(line);
            System.out.println();
        }
    }

    private void drawLine(boolean[] line) {
        int ladderWidth = line.length;
        line[0] = random();
        for (int width = 1; width < ladderWidth; width++) {
            line[width] = ladderDraw(line[width - 1]);
        }
    }

    private boolean ladderDraw(boolean left) {
        if (left) {
            return false;
        }
        return random();
    }

    private boolean random() {
        return Math.random() * 10 > 5;
    }
}
