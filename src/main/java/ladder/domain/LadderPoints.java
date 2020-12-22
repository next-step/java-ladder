package ladder.domain;

import java.util.List;

/**
 * 생성된 사다리를 출력할 수 있도록 point 들로 구성한 data 집합 입니다.
 */
public class LadderPoints {

    List<List<LadderItem>> points;

    public LadderPoints(List<List<LadderItem>> points) {
        this.points = points;
    }
}
