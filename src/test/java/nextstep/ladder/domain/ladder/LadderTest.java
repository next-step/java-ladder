package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.user.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

    @Test
    @DisplayName("참여자 및 높이 정보를 가지고 사다리를 생성한다.")
    void test01() {
        Participants participants = Participants.of("pobi,honux,crong,jk");
        LadderHeight ladderHeight = LadderHeight.from(5);

        Ladder ladder = new Ladder(Lines.create(ladderHeight.getHeight(), participants.count()));
        Lines lines = ladder.getLineColumns();

        assertThat(lines.getRows()).hasSize(ladderHeight.getHeight());
    }

    @Test
    @DisplayName("참여자 위치를 입력하면 실행결과를 반환한다.")
    void test02() {
        Points points = Points.initialize(2, () -> true);
        Lines lines = new Lines(List.of(points));
        Ladder ladder = new Ladder(lines);

        assertAll(
                () -> assertThat(ladder.getResult(0)).isEqualTo(1),
                () -> assertThat(ladder.getResult(1)).isEqualTo(0)
        );
    }

}
