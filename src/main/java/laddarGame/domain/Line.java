package laddarGame.domain;

import laddarGame.dto.LineDto;
import laddarGame.exception.ContinuousLadderCreateException;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Line {

    private final List<Boolean> line;

    public static final int ONE = 1;
    public static final int ZERO = 0;

    public Line(int playerCount) {
        this(createLine(playerCount));
    }

    public Line(List<Boolean> line) {
        if (valid(line)) {
            throw new ContinuousLadderCreateException("이동하는 부분이 연속적으로 생성되면 안됩니다.");
        }
        this.line = line;
    }

    private boolean valid(List<Boolean> line) {
        return IntStream.range(ZERO, line.size() - ONE)
                .filter(index -> isContinueTrue(line.get(index), line.get(index + ONE)))
                .boxed()
                .findFirst()
                .isPresent();
    }

    private boolean isContinueTrue(Boolean point, Boolean otherPoint) {
        return point && otherPoint;
    }

    public static List<Boolean> createLine(int playerCount) {
        LadderCreateStrategy conditional = LadderGame.createStrategy();
        final boolean[] lastPoint = new boolean[playerCount];
        return IntStream.rangeClosed(ONE, playerCount - ONE)
                .mapToObj(i -> lastPoint[i] = conditional.test(lastPoint[i - ONE]))
                .collect(toList());
    }

    public LineDto lineDto() {
        return new LineDto(line);
    }
}

