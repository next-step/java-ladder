package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderPointGeneratorTest {
    @DisplayName("Line을 위한 랜덤 Boolean 값 정상 생성")
    @Test
    void createBranchRandomlyTest() {
        assertThat(Arrays.asList(true, false)).contains(LadderPointGenerator.generatePoint());
    }
}
