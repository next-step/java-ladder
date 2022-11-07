package ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import ladder.domain.exception.InvalidHeightException;
import ladder.domain.exception.MismatchHeightLinesException;
import ladder.domain.exception.NullLinesException;

public class Lines {

    private final List<Line> lines;
    private final int height;

    public Lines(int height) {
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

    public List<Line> getLines() {
        return this.lines;
    }

    private void validateLines(List<Line> lines) {
        if (Optional.ofNullable(lines)
                .orElseThrow(NullLinesException::new)
                .size() != height) {
            throw new MismatchHeightLinesException();
        }
    }

}
