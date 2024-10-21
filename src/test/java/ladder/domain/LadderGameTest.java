package ladder.domain;

import ladder.service.LadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("사다리 게임을 진행한다.")
    void 사다리게임_진행() {
        LadderGame game = LadderGame.getInstance();
        List<Member> members = List.of(new Member("asd"), new Member("hee"));
        List<Reword> rewords = List.of(new Reword("5000"), new Reword("4000"));
        List<Line> ladders = game.createLadders(members, 3, () -> true);
        LadderResult results = game.playLadders(ladders, members, rewords);
        assertThat(results.getSize()).isEqualTo(2);
        assertThat(results.getReword(new Member("asd"))).isEqualTo(new Reword("4000"));
        assertThat(results.getReword(new Member("hee"))).isEqualTo(new Reword("5000"));
    }

    @Test
    @DisplayName("참여자와 높이를 입력하면 그에 맞는 사다리를 생성한다.")
    void 사다리_생성() {
        List<Line> ladders = LadderGame.getInstance().createLadders(List.of(new Member("asd"), new Member("hee")), 5, () -> true);
        assertThat(ladders).hasSize(5);
        assertThat(ladders.get(0).getSize()).isEqualTo(2);
    }
}
