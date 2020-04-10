package nextstep.ladder.domain;

import nextstep.ladder.domain.step.Step;
import nextstep.ladder.vo.Height;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final int ONE = 1;
    private static final int FIRST_PERSON = 0;
    private static final int MINIMUM_LINE_SIZE = 2;
    private static final int STRAT_INDEX = 0;

    private final List<LadderLine> ladderLines;
    private final Height heightOfLadder;

    private Ladder(List<LadderLine> ladderLines, int heightOfLadder) {
        validateLine(ladderLines);

        this.ladderLines = Collections.unmodifiableList(ladderLines);
        this.heightOfLadder = new Height(heightOfLadder);
    }

    private void validateLine(List<LadderLine> ladderLines) {
        if (ladderLines.size() < MINIMUM_LINE_SIZE) {
            throw new IllegalArgumentException("라인은 두개 이상이여야 합니다.");
        }
    }

    public static Ladder of(List<Person> persons, int heightOfLadder) {
        List<LadderLine> ladderLines = new ArrayList<>();
        LadderLine previousLadderLine = LadderLine.firstLine(persons.get(FIRST_PERSON), heightOfLadder);
        ladderLines.add(previousLadderLine);

        for (int lineIndex = 1; lineIndex < persons.size(); lineIndex++) {
            previousLadderLine = newLine(persons, previousLadderLine, lineIndex);
            ladderLines.add(previousLadderLine);
        }
        return new Ladder(ladderLines, heightOfLadder);
    }

    private static LadderLine newLine(List<Person> persons, LadderLine previousLadderLine, int lineIndex) {
        if (isLastLine(persons, lineIndex)) {
            return LadderLine.lastLine(persons.get(lineIndex), previousLadderLine.getSteps());
        }
        return LadderLine.middleLine(persons.get(lineIndex), previousLadderLine.getSteps());
    }

    private static boolean isLastLine(List<Person> persons, int lineIndex) {
        return lineIndex == lastPersonsIndex(persons);
    }

    private static int lastPersonsIndex(List<Person> persons) {
        return persons.size() - ONE;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    private LadderLine findLine(String name) {
        return ladderLines.stream()
                .filter(ladderLine -> ladderLine.getPerson().equals(new Person(name)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을수 없습니다."));
    }

    public List<Step> findResults(List<String> names) {
        return names.stream()
                .map(name -> findResults(name))
                .collect(Collectors.toList());
    }

    private Step findResults(String name) {
        LadderLine startLadderLine = findLine(name);
        Step step = startLadderLine.findNextStep(STRAT_INDEX);

        for (int i = 1, end = heightOfLadder.getHeight(); i < end; i++) {
            LadderLine ladderLine = ladderLines.get(step.getLinePosition());
            step = ladderLine.findNextStep(step.getStepPosition());
        }
        return step;
    }
}
