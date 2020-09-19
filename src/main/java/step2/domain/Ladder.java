package step2.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder implements Iterable<Line> {

    private List<Line> lineList;

    private Ladder(List<Line> lineList) {
        this.lineList = lineList;
    }

    public static Ladder create(int depth, int countOfPerson) {
        validLadderCreate(depth, countOfPerson);

        List<Line> lineList = IntStream.range(0, depth)
                .mapToObj(line -> Line.create(countOfPerson))
                .collect(Collectors.toList());

        return new Ladder(lineList);
    }

    private static void validLadderCreate(int depth, int countOfPerson) {
        if (depth < 1) {
            throw new IllegalArgumentException("사다리의 깊이는 최소 1이상이여야 합니다.");
        }

        if (countOfPerson < 1) {
            throw new IllegalArgumentException("최소 한명 이상의 게임 참여자가 필요 합니다.");
        }
    }

    @Override
    public Iterator<Line> iterator() {
        return lineList.iterator();
    }
}
