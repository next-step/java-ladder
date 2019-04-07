package ladder.domain.ladder.generator;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Lines;
import ladder.domain.ladder.Point;
import ladder.domain.member.MemberGroup;
import ladder.vo.Length;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {
    private static final int FIRST_INDEX = 0;

    private final PointGenerator pointGenerator;

    public LadderGenerator(PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
    }


    Ladder generateLadder(MemberGroup memberGroup, Length height) {
        return new Ladder(generateLines(memberGroup, height));
    }

    Lines generateLines(MemberGroup memberGroup, Length height) {
        List<Line> lines = IntStream.range(FIRST_INDEX, height.getValue())
                .mapToObj(i -> generateLine(memberGroup))
                .collect(Collectors.toList());

        return new Lines(lines);
    }

    Line generateLine(MemberGroup memberGroup) {
        int numberOfMembers = memberGroup.getNumberOfMembers();
        int lastIndex = numberOfMembers - 1;
        List<Point> points = new ArrayList<>(numberOfMembers);

        for (int i = 0; i < numberOfMembers; i++) {
            points.add(getPoint(i, lastIndex, points));
        }

        return new Line(points);
    }

    private Point getPoint(int currentIndex, int lastIndex, List<Point> points) {
        if (FIRST_INDEX == currentIndex) {
            return this.pointGenerator.generateLeftmost();
        }

        Point previousPoint = points.get(currentIndex - 1);

        if (lastIndex == currentIndex) {
            return this.pointGenerator.generateRightmost(previousPoint);
        }

        return this.pointGenerator.generate(previousPoint);
    }
}
