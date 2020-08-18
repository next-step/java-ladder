package ladder.ui.result;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class MovableLineDisplayResult implements DisplayResult {
    private final List<Boolean> linkLines;

    public MovableLineDisplayResult(List<Boolean> linkLines) {
        this.linkLines = linkLines;
    }

    @Override
    public String toDisplay() {
        final String line = linkLines.stream()
                                  .map(MovableLineDisplayResult::generateLinkShape)
                                  .collect(joining(""));
        return String.format("     %s", line);
    }

    static String generateLinkShape(boolean linkFlag){
        if (linkFlag) {
            return "|-----";
        }
        return "|     ";
    }
}
