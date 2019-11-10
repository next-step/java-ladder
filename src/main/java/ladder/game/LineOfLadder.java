package ladder.game;

import java.util.ArrayList;

public class LineOfLadder {
    private ArrayList<Boolean> connection;

    public LineOfLadder(int ladderWidth) {
        this.connection = new ArrayList<>();
        drawLine(ladderWidth);
    }

    private void drawLine(int ladderWidth) {
        for (int width = 0; width < ladderWidth; width++) {
            connection.add(ladderDraw());
        }
    }

    private boolean ladderDraw() {
        int connectedCount = connection.size();
        if (connectedCount != 0 && connection.get(connectedCount - 1)) {
            return false;
        }
        return random(() -> Math.random() * 10 < 5);
    }

    private boolean random(DrawLineStrategy drawLineStrategy) {
        return drawLineStrategy.draw();
    }

    public ArrayList<Boolean> getLineConnection() {
        return this.connection;
    }
}


