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

public class LadderLinesTest {
    private static final CoordinateGenerator COORDINATE_GENERATION = new ManualCoordinateGenerator();

    @Test
    @DisplayName("원하는 사다리 길이 만큼 사다리가 생성되는지 확인")
    void 사다리_길이_확인() {
        List<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        People people = new People(nameList);
        Height heightCount = new Height(5);

        LadderLines ladder = LadderLines.of(people, heightCount, COORDINATE_GENERATION);

        assertThat(ladder.draw()).hasSize(5);

    }

    @ParameterizedTest
    @CsvSource(value = {"0:1","1:0","2:3","3:2"},delimiter = ':')
    @DisplayName("참여자의 사다리 전체 이동 결과를 리턴")
    void move_결과확인(int start, int result) {
        List<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        People people = new People(nameList);
        Height heightCount = new Height(11);

        LadderLines ladderLines = LadderLines.of(people, heightCount, COORDINATE_GENERATION);

        assertThat(ladderLines.move(start)).isEqualTo(result);

    }
}
