package nextstep.ladder.domain;

import nextstep.ladder.domain.step.Step;
import nextstep.ladder.vo.Height;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int ONE = 1;
    private static final int FIRST_PERSON = 0;
    private static final int MINIMUM_LINE_SIZE = 2;

    private final List<Line> lines;
    private final Height heightOfLadder;

    private Ladder(List<Line> lines, int heightOfLadder) {
        validateLine(lines);

        this.lines = Collections.unmodifiableList(lines);
        this.heightOfLadder = new Height(heightOfLadder);
    }

    private void validateLine(List<Line> lines) {
        if (lines.size() < MINIMUM_LINE_SIZE) {
            throw new IllegalArgumentException("라인은 두개 이상이여야 합니다.");
        }
    }

    public static Ladder of(List<Person> persons, int heightOfLadder) {
        List<Line> lines = new ArrayList<>();
        Line previousLine = Line.firstLine(persons.get(FIRST_PERSON), heightOfLadder);
        lines.add(previousLine);

        for (int lineIndex = 1; lineIndex < persons.size(); lineIndex++) {
            previousLine = newLine(persons, previousLine, lineIndex);
            lines.add(previousLine);
        }
        return new Ladder(lines, heightOfLadder);
    }

    private static Line newLine(List<Person> persons, Line previousLine, int lineIndex) {
        if (isLastLine(persons, lineIndex)) {
            return Line.lastLine(persons.get(lineIndex), previousLine.getSteps());
        }
        return Line.middleLine(persons.get(lineIndex), previousLine.getSteps());
    }

    private static boolean isLastLine(List<Person> persons, int lineIndex) {
        return lineIndex == lastPersonsIndex(persons);
    }

    private static int lastPersonsIndex(List<Person> persons) {
        return persons.size() - ONE;
    }

    public int getHeightOfLadder() {
        return heightOfLadder.getHeight();
    }

    public List<Line> getLines() {
        return lines;
    }

    public Step start(String name) {
        Line startLine = findLine(name);
        Step step = startLine.move(0);

        for (int i = 1; i < heightOfLadder.getHeight(); i++) {
            Line line = lines.get(step.getLine());
            step = line.move(step.getStep());
        }
        return step;
    }

    private Line findLine(String name) {
        return lines.stream()
                .filter(line -> line.getPerson().equals(new Person(name)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을수 없습니다."));
    }

    public void all(String results) {
        lines.stream()
                .forEach(line -> {
                    Step step = line.move(0);
                    for (int i = 1; i < heightOfLadder.getHeight(); i++) {
                        Line findline = lines.get(step.getLine());
                        step = findline.move(step.getStep());
                    }
                    String[] split = results.split(",");
                    System.out.println(line.getPerson().getName() + " : " +split[step.getLine()]);
                });
    }
}
