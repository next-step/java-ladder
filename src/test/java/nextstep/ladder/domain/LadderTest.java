package nextstep.ladder.domain;

import nextstep.ladder.view.ReviewView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @DisplayName("사다리 생성 테스트")
    @Test
    public void createLadder() throws Exception {
        Ladder ladder = new Ladder(new PersonNames(List.of("1", "2", "3")), 3);
        ReviewView.printLadder(ladder);

        assertThat(ladder.getPersonNames().getPersonNames())
                .containsExactly(new PersonName("1"), new PersonName("2"), new PersonName("3"));

        assertThat(ladder.getLadderLines().size())
                .isEqualTo(3);

        assertThat(ladder.getLadderLines().getLadderLines().get(0).size())
                .isEqualTo(2);
    }

}