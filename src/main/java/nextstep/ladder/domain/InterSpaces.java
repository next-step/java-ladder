package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.strategy.DrawLineStrategy;

public class InterSpaces {

    private List<InterSpace> interSpaces;

    public InterSpaces(LadderDrawingSettings settings) {
        this.interSpaces = new ArrayList<>();
        drawCrossLinesBySettings(settings);
    }

    private void drawCrossLinesBySettings(LadderDrawingSettings settings) {

        final DrawLineStrategy strategy = settings.getStrategy();

        // 사다리의 첫줄부터 마지막줄 직전까지의 가로라인 처리.
        for (int i = 0; i < settings.getLadderWidth() - 1; i++) {
            addCrossLinesWithPreviousLineCheck(strategy);
        }
        // 마지막 사다리줄의 가로라인은 항상 공백처리.
        addBlankInterSpace();
    }

    private void addCrossLinesWithPreviousLineCheck(DrawLineStrategy strategy) {
        if (!hasPreviousCrossLine()) {
            addOneCrossLine(strategy);
        } else {
            addBlankInterSpace();
        }
    }

    private void addBlankInterSpace() {
        interSpaces.add(InterSpace.getBlankInterSpace());
    }

    private boolean hasPreviousCrossLine() {
        return getLatestInterSpace().hasCrossLine();
    }

    private void addOneCrossLine(DrawLineStrategy strategy) {
        interSpaces.add(InterSpace.draw(strategy));
    }

    private InterSpace getLatestInterSpace() {
        int latestIndex = interSpaces.size() - 1;
        if (latestIndex < 0) {
            return InterSpace.getBlankInterSpace();
        }
        return interSpaces.get(latestIndex);
    }

    public boolean hasCrossLineAt(int index) {
        return value().get(index).hasCrossLine();
    }

    public List<InterSpace> value() {
        return interSpaces;
    }

    public int count() {
        return value().size();
    }
}
