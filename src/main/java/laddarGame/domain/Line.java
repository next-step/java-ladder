package laddarGame.domain;

import laddarGame.dto.LineDto;
import laddarGame.exception.ContinuousLadderCreateException;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Line {

    private final List<Point> line;

    public static final int ONE = 1;
    public static final int ZERO = 0;

    public Line(int playerCount) {
        this(createLine(playerCount));
    }

    public Line(List<Boolean> line) {
        valid(line);
        this.line = line.stream().
                map(Point::of).
                collect(toList());
    }

    private void valid(List<Boolean> line) {
        IntStream.range(ZERO, line.size() - ONE)
                .forEach(index -> isContinueTrue(line.get(index), line.get(index + ONE)));
    }

    private void isContinueTrue(Boolean point, Boolean otherPoint) {
        if (point && otherPoint) {
            throw new ContinuousLadderCreateException("이동하는 부분이 연속적으로 생성되면 안됩니다.");
        }
    }

    public static List<Boolean> createLine(int playerCount) {
        LadderCreateStrategy conditional = LadderGame.createStrategy();
        final boolean[] lastPoint = new boolean[playerCount];
        return IntStream.range(ONE, playerCount)
                .mapToObj(i -> lastPoint[i] = conditional.test(lastPoint[i - ONE]))
                .collect(toList());
    }

    public LineDto lineDto() {
        return new LineDto(line);
    }

    public List<Point> getPoint(int index) {
        if (index == ZERO) {
            return List.of(line.get(index), line.get(index));
        }
        if (index == line.size()) {
            return List.of(line.get(index - ONE), line.get(index - ONE));
        }
        return List.of(line.get(index - ONE), line.get(index));
    }

    public Players play(Players players) {
        return IntStream.range(ZERO, players.playerCount())
                .mapToObj(i -> players.getPlayer(i).move(getPoint(i), players.playerCount() - ONE))
                .sorted(Player::compare)
                .collect(collectingAndThen(toList(), Players::new));
    }

}

