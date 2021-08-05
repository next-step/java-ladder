package ladder.domain.line;

import ladder.core.LadderLine;
import ladder.core.LadderLineGenerator;
import ladder.domain.point.LadderPoint;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicLadderLineGenerator implements LadderLineGenerator {
    @Override
    public LadderLine generate(final int pointSize) {
        List<LadderPoint> points =
                Stream.iterate(LadderPoint.first(), LadderPoint::next)
                        .limit(pointSize - 1)
                        .collect(Collectors.toList());
        points.add( // 마지막에 last를 추가해준다.
                points.get(pointSize - 2).last()
        );

        return new BasicLadderLine(points);
    }
}
