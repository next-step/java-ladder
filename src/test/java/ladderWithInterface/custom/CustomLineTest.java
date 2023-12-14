package ladderWithInterface.custom;

import ladderWithInterface.engin.CoordinateGenerator;
import ladderWithInterface.engin.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomLineTest {

    public static final CustomLineCreator CUSTOM_LINE_CREATOR = new CustomLineCreator();
    private static final CoordinateGenerator COORDINATE_GENERATION = new ManualCoordinateGenerator();
    private static final int COUNT = 4;
    private Line line;

    @BeforeEach
    void create() {
        line = CUSTOM_LINE_CREATOR.create(COUNT, COORDINATE_GENERATION);
    }

    @Test
    @DisplayName("사다리 한줄이 인원과 전략에 맞게 생성되는지 확인")
    void 사다리_라인생성_확인() {
        Direction direction = Direction.first(true);
        List<Direction> result = new ArrayList<>() {{
            add(direction);
            add(direction.next(false));
            add(direction.next(false).next(true));
            add(direction.end());
        }};
        Line line = CUSTOM_LINE_CREATOR.create(COUNT, COORDINATE_GENERATION);

        Assertions.assertThat(line).isEqualTo(new CustomLine(result));

    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2"}, delimiter = ':')
    @DisplayName("참여자의 사다리 전체 이동 결과를 리턴")
    void move_결과확인(int start, int result) {

        Line line = CUSTOM_LINE_CREATOR.create(COUNT, COORDINATE_GENERATION);

        assertThat(line.move(start)).isEqualTo(result);

    }
}
