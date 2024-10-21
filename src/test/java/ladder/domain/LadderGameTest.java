package ladder.domain;

import ladder.service.LadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("참여자와 높이를 입력하면 그에 맞는 사다리를 생성한다.")
    void 사다리_생성() {
        List<Line> ladders = LadderGame.getInstance().createLadders(List.of(new Member("asd"), new Member("hee")), 5);
        assertThat(ladders).hasSize(5);
        assertThat(ladders.get(0).getSize()).isEqualTo(2);
    }
}
