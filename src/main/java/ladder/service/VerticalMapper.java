package ladder.service;

import ladder.model.HorizontalLine;
import ladder.model.VerticalLine;

import java.util.ArrayList;
import java.util.List;

public abstract class VerticalMapper {

    public static List<VerticalLine> map(List<HorizontalLine> horizontalLine, int userNumber) {
        horizontalLine.forEach((line) -> line.validate(userNumber));
        List<VerticalLine> verticalLines = new ArrayList<>();
        for (int userIndex = 0; userIndex < userNumber; userIndex++) {
            verticalLines.add(VerticalLine.mapHorizontalLineToVertical(horizontalLine, userIndex));
        }
        return verticalLines;
    }
}
