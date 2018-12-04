package util;

import domain.Line;
import domain.Point;
import org.junit.Test;

/**
 * 테스트를 위해서 GenerateLine 인터페이스 구현
 */
class TestGenerateLadderLine implements GenerateLine {

    @Override
    public Point fromRandom() {
        return Point.EXIST;
    }

    @Override
    public Point fromMiddle(final Line line, final int sequence) {
        return Point.EXIST;
    }

    @Override
    public Point fromLast() {
        return Point.NONE;
    }

}

@SuppressWarnings("NonAsciiCharacters")
public class GenerateLadderLineTest {

    /**
     * TODO: 이렇게 구현체를 검증하는 것이 올바른 테스트인지 모르겠습니다.
     */
    @Test
    public void 연속된_사다리가_만들어_질_수_없음을_검증_천번_실행() {
        final Line firstLine = Line.fromFirst(3, new TestGenerateLadderLine());
        final GenerateLine generateLine = new GenerateLadderLine();
        for (int i = 0; i < 1000; i++) {
            Line.fromMiddle(3, firstLine, generateLine);
        }
    }

    @Test
    public void 마지막_사다리인_경우_무조건_연결되지_않음을_검증_천번_실행() {
        final GenerateLine generateLine = new GenerateLadderLine();
        for (int i = 0; i < 1000; i++) {
            final Line lastLine = Line.fromLast(3, generateLine);
            for (Point point : lastLine.getPoints()) {
                if (point.isExistence()) {
                    throw new IllegalStateException();
                }
            }
        }
    }

}