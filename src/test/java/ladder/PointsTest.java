package ladder;

import ladder.domain.Points;
import ladder.domain.PointsShuffleGenerator;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest {

    @Test
    void 포인트테스트_테스트하기_어려운_코드() {
        int countOfPerson = 4;
        List<Boolean> points = new ArrayList<>();
        points.add(true);
        for (int i = 1; i < countOfPerson - 1; i++) {
            boolean a = points.stream()
                    .min(Comparator.naturalOrder())
                    .map(this::generatePoints)
                    .orElseThrow(() -> new IllegalArgumentException("초기값 에러"));
            points.add(a);
        }
    }

    boolean generatePoints(boolean currentBoolean) {
        if (currentBoolean) {
            return false;
        }
        return generateShufflePoint();
    }

    boolean generateShufflePoint() {
        List<Boolean> booleans = Arrays.asList(true, false);
        Collections.shuffle(booleans);
        return booleans.get(0);
    }

    @Test
    void 일급컬렉션테스트() {
        Points points = new Points(5, new PointsShuffleGenerator());
        assertThat(points.getPoints()).hasSize(4);
    }

    @Test
    void 테스트하기어려운거_테스트해보기() {
        Points points = new Points(5, countOfPerson -> Arrays.asList(true,false,false,false,true));
        assertThat(points.getPoints()).containsExactly(true,false,false,false,true);
    }
}
