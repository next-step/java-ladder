package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("참여자 및 높이 정보를 가지고 사다리를 생성한다.")
    void test01() {
        Participants participants = Participants.of("pobi,honux,crong,jk");
        LadderHeight ladderHeight = LadderHeight.from(5);

        Ladder ladder = new Ladder(LineColumns.create(ladderHeight.getHeight(), participants.count()));
        LineColumns lineColumns = ladder.getLineColumns();

        assertThat(lineColumns.getColumns()).hasSize(ladderHeight.getHeight());
    }

}
