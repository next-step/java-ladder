package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void createLadderTest() {
        List<String> names = List.of("a,b,c".split(","));
        Participants participants = Participants.from(names);
        Ladder ladder = Ladder.from(new Heights(5), participants, (index, previous) -> true);

        assertThat(ladder.getLadderHeights())
                .isEqualTo(5);
    }

}
