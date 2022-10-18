package ladder.factory;

import ladder.domain.*;
import ladder.dto.LineGenerateDto;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {


    public static List<HorizontalLine> horizontalLines(LineGenerateDto lineGenerateDto, LineGenerator generator) {
        return generator.generate(lineGenerateDto);
    }

    public static List<VerticalLine> verticalLines(List<HorizontalLine> horizontalLine, int userNumber) {
        horizontalLine.forEach((line) -> line.validate(userNumber));
        List<VerticalLine> verticalLines = new ArrayList<>();
        for (int userIndex = 0; userIndex < userNumber; userIndex++) {
            verticalLines.add(mapHorizontalLineToVertical(horizontalLine, userIndex));
        }
        return verticalLines;
    }

    private static VerticalLine mapHorizontalLineToVertical(List<HorizontalLine> horizontalLine, int userIndex) {
        List<LineUnit> verticalLine = new ArrayList<>();
        for (int lineIndex = 0; lineIndex < horizontalLine.size(); lineIndex++) {
            HorizontalLine line = horizontalLine.get(lineIndex);
            LineUnit lineUnit = line.getUnits().get(userIndex);
            verticalLine.add(lineUnit);
        }
        return new VerticalLine(verticalLine, new HorizontalPosition(userIndex));
    }

}
