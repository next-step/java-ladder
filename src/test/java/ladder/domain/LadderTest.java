package ladder.domain;

import ladder.domain.strategy.CoordinateGeneration;
import ladder.domain.strategy.ManualCoordinateGeneration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private static final CoordinateGeneration COORDINATE_GENERATION = new ManualCoordinateGeneration();

    @Test
    @DisplayName("원하는 사다리 길이 만큼 사다리가 생성되는지 확인")
    void 사다리_길이_확인() {
        List<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        People people = new People(nameList);
        Height heightCount = new Height(5);

        Ladder ladder = Ladder.of(people, heightCount, COORDINATE_GENERATION);

        assertThat(ladder.draw()).hasSize(5);

    }
}
