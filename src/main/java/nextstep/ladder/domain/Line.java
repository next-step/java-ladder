package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import nextstep.ladder.exception.HorizontalLineException;

public class Line {

    private List<Boolean> points;

    private Predicate<List> isOneLine = e -> e.size() == 1;
    private Predicate<Integer> isFinalLine = e -> e == points.size() - 1;


    public Line(int countOfPerson) {
        points = new ArrayList<>(Arrays.asList(new Boolean[countOfPerson]));
        Collections.fill(points, Boolean.FALSE);
    }


    public void drawHorizontalLine(int startPointIndex) {
        if (isOneLine.test(points)) {
            throw new HorizontalLineException("열이 한줄밖에 없을때는 가로라인을 그릴수 없습니다.");
        }
        if (hasHorizontalLine(startPointIndex)) {
            throw new HorizontalLineException(String.format("가로라인은 중복되게 그릴수 없습니다."));
        }

        if (checkttt1(startPointIndex) && checkttt2(startPointIndex)) {

            points.set(startPointIndex, true);
            points.set(startPointIndex + 1, true);
        } else {
            throw new HorizontalLineException(String.format("오묘한 에러!"));
        }
    }

    public boolean hasHorizontalLine(int pointIndex) {
        return points.get(pointIndex);
    }

    private boolean checkttt1(int pintIndex) {
        return Optional.ofNullable(points.get(pintIndex - 1))
            .filter(e -> e == false)
            .isPresent();
    }

    private boolean checkttt2(int pintIndex) {
        return Optional.ofNullable(points.get(pintIndex + 2))
            .filter(e -> e == false)
            .isPresent();
    }

    public int verticalLineCount() {
        return points.size();
    }

}
