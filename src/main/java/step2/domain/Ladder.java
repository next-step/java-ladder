package step2.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ladder implements Iterable<Line>{

    private List<Line> lineList;

    private Ladder(List<Line> lineList) {
        this.lineList = lineList;
    }

    public static Ladder create(int depth, int countOfPerson) {
        if (depth < 1) {
            throw new IllegalArgumentException("사다리의 깊이는 최소 1이상이여야 합니다.");
        }

        if (countOfPerson < 1) {
            throw new IllegalArgumentException("최소 한명 이상의 게임 참여자가 필요 합니다.");
        }

        List<Line> lineList = new ArrayList<>();

        for (int i = 0; i < depth; i++) {
            lineList.add(Line.create(countOfPerson));
        }

        return new Ladder(lineList);
    }

    @Override
    public Iterator<Line> iterator() {
        return lineList.iterator();
    }
}
