package nextstep.ladder.domain.laddergame.position;

import java.util.HashMap;
import java.util.Map;

public class ResultPosition {
    private final Map<Integer, Integer> positionMap;

    public ResultPosition() {
        this(new HashMap<>());
    }

    public ResultPosition(Map<Integer, Integer> positionMap) {
        this.positionMap = positionMap;
    }

    public void add(int start, int finish) {
        positionMap.put(start, finish);
    }

    public int getFinishPosition(int startPosition) {
        return positionMap.get(startPosition);
    }

}
