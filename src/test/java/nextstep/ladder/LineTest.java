package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class LineTest {

    @Test
    @DisplayName("사다리 라인 생성 테스트: 길이 양쪽에 생길 수 없다.")
    void createTest() {
        var playerCount = 5;
        var trueLine = new Line(playerCount, new TrueRandom());

        Assertions.assertThat(trueLine.getPoints()).isEqualTo(List.of(true, false, true, false, true));
    }

    static class TrueRandom extends Random {
        @Override
        public boolean nextBoolean() {
            return true;
        }
    }
}
