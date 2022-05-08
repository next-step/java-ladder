package nextstep.ladder.domain;

import static nextstep.ladder.domain.Height.MINIMUM_LADDER_HEIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    private final List<String> names = Arrays.asList("pobi", "honux", "crong", "jk");
    private final int height = 5;

    @Test
    void createTest_1() {
        Ladder ladder = Ladder.of(names, height);

        assertThat(ladder.lineCount()).isEqualTo(names.size() + names.size()-1);
        assertThat(ladder.lineHeight()).isEqualTo(height);
        assertThat(ladder.getLineNames()).containsExactly("pobi", "honux", "crong", "jk");
    }

    @DisplayName("사다리 생성 후 각 라인이 모두 하나라도 연결되어 있다.")
    @Test
    void createTest_2() {
        Ladder ladder = Ladder.of(names, height);

        assertThat(ladder.isAllLineConnected()).isTrue();
    }

    @DisplayName("최소길이 사다리 생성 후 각 라인이 모두 하나라도 연결되어 있다.")
    @Test
    void createTest_3() {
        Ladder ladder = Ladder.of(names, MINIMUM_LADDER_HEIGHT);

        assertThat(ladder.isAllLineConnected()).isTrue();
    }

}