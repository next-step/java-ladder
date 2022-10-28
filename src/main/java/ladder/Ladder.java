package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ladder.exception.EmptyNamesException;
import ladder.exception.InvalidHeightException;
import ladder.exception.InvalidLinesException;
import ladder.exception.InvalidNameLengthException;
import ladder.exception.NullNamesException;
import ladder.line.Line;

public class Ladder {

    private final List<Line> lines;
    private final List<String> names;
    private final int height;
    private final int maxNameLength;

    public Ladder(List<String> names, int height) {
        this.names = validateNames(names);
        this.maxNameLength = getMaxNameLength(names);

        if (height <= 0) {
            throw new InvalidHeightException();
        }
        this.height = height;

        this.lines = new ArrayList<>();
    }

    public void addLines(List<Line> lines) {
        validateLines(lines);

        this.lines.addAll(lines);
    }

    public Line getLine(int index) {
        return this.lines.get(index);
    }

    public int getHeight() {
        return this.height;
    }

    public List<String> getNames() {
        return this.names;
    }

    public int getMaxNameLength() {
        return this.maxNameLength;
    }

    private void validateLines(List<Line> lines) {
        long barCount = lines.stream()
                .filter(this::validateLine)
                .count();
        if (barCount != height) {
            throw new InvalidLinesException();
        }
    }

    private boolean validateLine(Line line) {
        List<Boolean> bars = line.getBars();
        if (bars.size() != names.size()) {
            return false;
        }

        return line.validate();
    }

    private List<String> validateNames(List<String> names) {
        long count = Optional.ofNullable(names)
                .orElseThrow(NullNamesException::new)
                .size();
        if (count == 0) {
            throw new EmptyNamesException();
        }
        return names;
    }

    private int getMaxNameLength(List<String> names) {
        List<String> sortedNames = names.stream()
                .sorted((left, right) -> right.length() - left.length())
                .collect(Collectors.toUnmodifiableList());

        validateNameLength(sortedNames);
        return sortedNames.get(0).length();
    }

    private void validateNameLength(List<String> sortedNames) {
        if (sortedNames.stream()
                .anyMatch(name -> name.length() == 0 || name.length() > 5)) {
            throw new InvalidNameLengthException();
        }
    }

}
