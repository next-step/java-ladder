package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<VerticalLine> lines;
    private final LadderLength ladderLength;

    public Ladder(List<VerticalLine> lines, LadderLength ladderLength) {
        this.lines = lines;
        this.ladderLength = ladderLength;
    }

    public List<HorizontalPosition> play(List<User> users) {
        return users.stream()
                .map(this::move)
                .collect(Collectors.toList());
    }

    HorizontalPosition move(User user) {
        LadderPosition ladderPosition = LadderPosition.startWithUserPosition(user.getPosition());
        while (!ladderPosition.isArrived(this.ladderLength)) {
            VerticalLine verticalLine = findVerticalLineByPosition(ladderPosition.getHorizontalPosition());
            verticalLine.move(ladderPosition, this.ladderLength);
        }
        return ladderPosition.getHorizontalPosition();
    }

    private VerticalLine findVerticalLineByPosition(HorizontalPosition position) {
        return this.lines.stream()
                .filter((line)->line.isSamePosition(position))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    public List<VerticalLine> getLines() {
        return lines;
    }

    public LadderLength getLadderLength() {
        return ladderLength;
    }


}
