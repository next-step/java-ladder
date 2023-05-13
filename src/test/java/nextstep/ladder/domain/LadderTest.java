package nextstep.ladder.domain;

import nextstep.ladder.domain.util.RandomStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void initLadderTest() {
        List<String> names = List.of("a,b,c,".split(","));
        LadderInputs participants = LadderInputs.from(names);
        Ladder ladder = Ladder.from(new Heights(5), participants, new RandomStrategy());

        assertThat(ladder.getLadderHeights())
                .isEqualTo(5);
    }
}
