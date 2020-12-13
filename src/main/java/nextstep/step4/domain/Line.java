package nextstep.step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private final List<Index> indexList;

    private Line(List<Index> indexList) {
        this.indexList = indexList;
    }

    public static Line init(int numberOfUsers) {
        List<Index> indexList = new ArrayList<>(numberOfUsers);
        MoveStrategy moveStrategy = new RandomMoveImpl();

        Point point = Point.setFirst(moveStrategy);
        indexList.add(Index.of(ZERO, point));

        IntStream.range(ONE, numberOfUsers - ONE)
                .forEach(position -> indexList.add(Index.of(position, point.setNext(moveStrategy))));
        indexList.add(Index.of(numberOfUsers - ONE, point.setLast()));

        return new Line(indexList);
    }

    public List<Index> getIndexList() {
        return indexList;
    }
}
