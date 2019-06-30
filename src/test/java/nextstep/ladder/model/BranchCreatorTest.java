package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BranchCreatorTest {
    @DisplayName("Line을 위한 랜덤 Boolean 값 정상 생성")
    @Test
    void createBranchRandomlyTest() {
        assertThat(new Line(5).getPoints()).contains(true, false);
    }
}
