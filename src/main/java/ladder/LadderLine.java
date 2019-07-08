package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLine {
    private final List<LadderPosition> ladderPositions;

    private LadderLine(List<LadderPosition> ladderPositions) {
        this.ladderPositions = ladderPositions;
    }

    public static LadderLine of(int countOfPerson) {
        List<LadderPosition> ladderPositions = createLadderPositions(countOfPerson);
        return new LadderLine(ladderPositions);
    }

    private static List<LadderPosition> createLadderPositions(int countOfPerson) {
        List<LadderPosition> results = new ArrayList<>(countOfPerson);

        LadderPosition firstPosition = LadderPosition.first();
        results.add(firstPosition);

        int countOfNextPositions = countOfPerson - 2;
        results.addAll(createNextLadderPositions(firstPosition, countOfNextPositions));

        LadderPosition lastNextPosition = results.get(results.size() -1);
        LadderPosition lastPosition = lastNextPosition.moveToLast();
        results.add(lastPosition);

        return results;
    }

    private static List<LadderPosition> createNextLadderPositions(LadderPosition firstPosition, int countOfPositions) {
        List<LadderPosition> nextPositions = new ArrayList<>();
        LadderPosition previousPosition = firstPosition;

        while (countOfPositions -- > 0) {
            LadderPosition nextPosition = previousPosition.moveToNext();
            nextPositions.add(nextPosition);
            previousPosition = nextPosition;
        }

        return nextPositions;
    }

    public List<Boolean> getColumnResultsOfLadderLine() {
        int sizeOfExcludesLastPosition = ladderPositions.size() - 1;

        return ladderPositions.stream()
                              .limit(sizeOfExcludesLastPosition)
                              .map(LadderPosition::isCanMoveRight)
                              .collect(Collectors.toList());
    }

    public int computeNextPosition(int beginPosition) {
        return this.ladderPositions
                        .get(beginPosition)
                        .computeNextPosition();
    }
}
