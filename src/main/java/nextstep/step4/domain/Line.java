package nextstep.step4.domain;

import java.util.ArrayList;
import java.util.List;

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

        Point point = null;
        for(int i = ZERO; i < numberOfUsers; i++) {
            if(i == ZERO) {
                point = Point.setFirst(moveStrategy);
                indexList.add(Index.of(i, point));
            }

            if(i != ZERO && i != numberOfUsers - ONE) {
                point = point.setNext(moveStrategy);
                indexList.add(Index.of(i, point));
            }

            if(i == numberOfUsers - ONE) {
                indexList.add(Index.of(i, point.setLast()));
            }
        }

        return new Line(indexList);
    }

    public static Line from(List<Index> indexList) {
        return new Line(indexList);
    }

    public int move(int position) {
        return indexList.get(position).move();
    }

    public List<Index> getIndexList() {
        return indexList;
    }
}
