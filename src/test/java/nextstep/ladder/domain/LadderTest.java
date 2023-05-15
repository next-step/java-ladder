package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {

    @Test
    void 높이와_참여자가_주어졌을때_높이와_참여자에_따른_크기의_리스트를_생성한다() {
        List<String> participants = List.of("pobi", "honux", "crong", "jk");
        int ladderHeight = 5;

        List<Line> ladder = Ladder.of(participants, ladderHeight);

        assertAll(
                () -> assertThat(ladder).hasSize(ladderHeight),
                () -> assertThat(ladder.get(0).size()).isEqualTo(participants.size() - 1)
        );
    }
}
