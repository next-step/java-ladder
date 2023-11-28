package ladder.domain;

import ladder.domain.strategy.CoordinateGenerator;
import ladder.domain.strategy.ManualCoordinateGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        List<Direction> result = new ArrayList<>() {{
            add(Direction.first(true));
            add(Direction.of(true, false));
            add(Direction.of(false, true));
            add(Direction.end(true));
        }};

        LadderLine ladderLine = LadderLine.of(people, COORDINATE_GENERATION);

        assertThat(ladderLine.draw()).hasSize(people.count()).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("한 좌표 위치에 있는 참여자가 이동할 수 있는 위치를 리턴하는지 확인")
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2"}, delimiter = ':')
    void move_확인(int current, int result) {
        List<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        People people = new People(nameList);

        LadderLine ladderLine = LadderLine.of(people, COORDINATE_GENERATION);

        assertThat(ladderLine.move(current)).isEqualTo(result);


    }
}
