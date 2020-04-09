package ladder.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LadderMap {

    List<Line> ladderMap;

    public LadderMap(Users uesrs, int highest, MoveStrategy moveStrategy) {
        this.ladderMap = createMap(uesrs.toList().size(), highest, moveStrategy);
    }

    public static LadderMap of(Users uesrs, int highest, MoveStrategy moveStrategy) {
        return new LadderMap(uesrs, highest, moveStrategy);
    }

    private List<Line> createMap(int usersCount, int highest, MoveStrategy moveStrategy) {
        List<Line> newMap = new ArrayList<>();
        for (int i = 0; i < highest; i++) {
            newMap.add(Line.of(usersCount, moveStrategy));
        }
        return newMap;
    }

    public List<Line> toList() {
        return Collections.unmodifiableList(ladderMap);
    }
}
