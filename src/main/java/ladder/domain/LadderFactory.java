package ladder.domain;

import ladder.dto.LineGenerateDto;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {


    private static List<HorizontalLine> horizontalLines(LineGenerateDto lineGenerateDto, LineGenerator generator) {
        return generator.generate(lineGenerateDto);
    }

    private static List<VerticalLine> verticalLines(List<HorizontalLine> horizontalLine, int userNumber) {
        horizontalLine.forEach((line) -> line.validate(userNumber));
        List<VerticalLine> verticalLines = new ArrayList<>();
        for (int userIndex = 0; userIndex < userNumber; userIndex++) {
            verticalLines.add(mapHorizontalLineToVertical(horizontalLine, userIndex));
        }
        return verticalLines;
    }

    private static VerticalLine mapHorizontalLineToVertical(List<HorizontalLine> horizontalLine, int userIndex) {
        List<Direction> verticalLine = new ArrayList<>();
        for (int lineIndex = 0; lineIndex < horizontalLine.size(); lineIndex++) {
            HorizontalLine line = horizontalLine.get(lineIndex);
            Direction direction = line.getUnits().get(userIndex);
            verticalLine.add(direction);
        }
        return new VerticalLine(verticalLine, new Position(userIndex));
    }

    public static Ladder getLadder(int numberOfUser, LadderLength ladderLength, LineGenerator lineGenerator) {
        List<HorizontalLine> horizontalLines = LadderFactory.horizontalLines(new LineGenerateDto(numberOfUser, ladderLength.getLength()), lineGenerator);
        List<VerticalLine> verticalLines = LadderFactory.verticalLines(horizontalLines, numberOfUser);
        return new Ladder(verticalLines, ladderLength);
    }
}
