package step2.domain;

import java.util.ArrayList;

public class Ladder {
    private final int height;
    private final int width;

    private final ArrayList<Line> lines = new ArrayList<>();

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
        for (int i = 0; i < width; i++) {
            lines.add(new Line(height));
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public Ladder buildBridges(BridgeBuildStrategy bridgeBuildStrategy) {
        for (int lineNumber = 0; lineNumber < width - 1; lineNumber++) {
            buildBridge(lineNumber, height, bridgeBuildStrategy);
        }
        return this;
    }

    private ArrayList<Line> buildBridge(int lineNumber, int height, BridgeBuildStrategy bridgeBuildStrategy) {
        for (int position = 0; position < height; position++) {
            if (areLinesOverlapping(lines, lineNumber, position) || !bridgeBuildStrategy.canBuild()) continue;
            lines.get(lineNumber).addBridge(position);
        }
        return lines;
    }

    private boolean areLinesOverlapping(ArrayList<Line> lines, int lineNumber, int position) {
        if (lineNumber - 1 < 0) return false;
        return lines.get(lineNumber - 1).isPresent(position);
    }
}
