package ladder.factory;

import ladder.domain.HorizontalLine;
import ladder.domain.LineGenerator;
import ladder.domain.RandomLineGenerator;
import ladder.domain.VerticalLine;
import ladder.dto.LineGenerateDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderFactory {

    private static final LineGenerator generator = new RandomLineGenerator();

    public static List<HorizontalLine> horizontalLines(LineGenerateDto lineGenerateDto){
        Random random = new Random();
        return generator.generate(lineGenerateDto , random::nextBoolean);
    }

    public static List<VerticalLine> verticalLines(List<HorizontalLine> horizontalLine, int userNumber) {
        horizontalLine.forEach((line) -> line.validate(userNumber));
        List<VerticalLine> verticalLines = new ArrayList<>();
        for (int userIndex = 0; userIndex < userNumber; userIndex++) {
            verticalLines.add(VerticalLine.mapHorizontalLineToVertical(horizontalLine, userIndex));
        }
        return verticalLines;
    }

}
