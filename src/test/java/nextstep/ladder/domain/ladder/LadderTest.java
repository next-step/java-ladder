package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.user.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

    @Test
    @DisplayName("참여자 및 높이 정보를 가지고 사다리를 생성한다.")
    void test01() {
        Participants participants = Participants.of("pobi,honux,crong,jk");
        LadderHeight ladderHeight = LadderHeight.from(5);

        assertThatNoException()
                .isThrownBy(() -> Ladder.create(ladderHeight.getHeight(), participants.count()));
    }

    @Test
    @DisplayName("참여자 위치를 입력하면 실행결과를 반환한다.")
    void test02() {
        Row row = Row.initialize(2, () -> true);
        Ladder ladder = new Ladder(List.of(row));

        assertAll(
                () -> assertThat(ladder.getLeaf(0).getCurrentPosition()).isEqualTo(1),
                () -> assertThat(ladder.getLeaf(1).getCurrentPosition()).isZero()
        );
    }

}
