package ladder.domain;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class RandomLadderPointGenerator implements LadderPointGenerator {

    @Override
    public void generate(Ladder ladder, int lineCount) {
        Random random = new Random();
        for (int i = 0; i < lineCount; i++) {
            int lineNumber = random.nextInt(ladder.getLineSize() - 1);
            Line line = ladder.getLine(lineNumber);
            Line rightLine = ladder.getLine(lineNumber + 1);

            Optional<Integer> pointIndex = getAvailablePoint(line, rightLine);
            if (pointIndex.isEmpty()) {
                // TODO: 좀더 나은 처리
                continue;
            }

            ladder.connectLine(line, rightLine, pointIndex.get());
        }
    }

    private Optional<Integer> getAvailablePoint(Line line, Line rightLine) {
        List<Integer> lineEmptyPoints = line.emptyPoints();
        List<Integer> rightLineEmptyPoints = rightLine.emptyPoints();

        return lineEmptyPoints.stream()
                .filter(rightLineEmptyPoints::contains)
                .findFirst();
    }
}
