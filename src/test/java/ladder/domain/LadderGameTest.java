package ladder.domain;

import ladder.service.LadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.MemberTest.m1;
import static ladder.domain.MemberTest.m2;
import static ladder.domain.MembersTest.ms1;
import static ladder.domain.RewordTest.r1;
import static ladder.domain.RewordTest.r2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    @Test
    @DisplayName("멤버와 보상의 수가 다를 때 예외를 발생시킨다.")
    void 사다리게임_예외() {
        LadderGame game = LadderGame.getInstance();
        List<Reword> rewords = List.of(r1);
        List<Line> ladders = game.createLadders(ms1, 3, () -> true);
        assertThatThrownBy(() -> game.playLadders(ladders, ms1, rewords))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("사다리 게임을 진행한다.")
    void 사다리게임_진행() {
        LadderGame game = LadderGame.getInstance();
        List<Reword> rewords = List.of(r1, r2);
        List<Line> ladders = game.createLadders(ms1, 3, () -> true);
        LadderResult results = game.playLadders(ladders, ms1, rewords);
        assertThat(results.getSize()).isEqualTo(2);
        assertThat(results.getReword(m1)).isEqualTo(r2);
        assertThat(results.getReword(m2)).isEqualTo(r1);
    }

    @Test
    @DisplayName("참여자와 높이를 입력하면 그에 맞는 사다리를 생성한다.")
    void 사다리_생성() {
        List<Line> ladders = LadderGame.getInstance().createLadders(ms1, 5, () -> true);
        assertThat(ladders).hasSize(5);
        assertThat(ladders.get(0).getSize()).isEqualTo(2);
    }
}
