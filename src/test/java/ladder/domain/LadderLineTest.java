package ladder.domain;

import ladder.domain.strategy.CoordinateGenerator;
import ladder.domain.strategy.ManualCoordinateGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderLineTest {

    private static final CoordinateGenerator COORDINATE_GENERATION = new ManualCoordinateGenerator();

    @Test
    @DisplayName("사다리가 사람수만큼 전략에 맞취 생성되는지 확인")
    void 사다리_한줄_생성확인() {
        List<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        People people = new People(nameList);
        List<Coordinate> result = new ArrayList<>() {{
            add(Coordinate.valueOf(false));
            add(Coordinate.valueOf(true));
            add(Coordinate.valueOf(false));
            add(Coordinate.valueOf(true));
        }};

        LadderLine ladderLine = LadderLine.of(people, COORDINATE_GENERATION);

        assertThat(ladderLine.draw()).hasSize(people.count()).isEqualTo(result);
    }
}
