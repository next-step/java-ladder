package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        Boolean array[] = new Boolean[]{false};
        List<Boolean> booleans = Arrays.asList(array);
        points.addAll(booleans);
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
