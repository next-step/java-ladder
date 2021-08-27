package nextstep.step4;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {

    private Map<Integer, Integer> arriveResult = new HashMap<>();

    public void put(int startPoint, int endPoint) {
        arriveResult.put(startPoint, endPoint);
    }

    public int getEndPoint(int startPoint) {
        return arriveResult.get(startPoint);
    }

    public static LadderResult of() {
        return new LadderResult();
    }

}
