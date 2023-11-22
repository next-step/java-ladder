package nextstep.ladder.domain;

import nextstep.ladder.controller.dto.GameInfo;
import nextstep.ladder.domain.wrapper.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LadderGameTest {

    @DisplayName("인자로 GameInfo를 전달받아 사다리 게임을 생성한다.")
    @Test
    void createLottoGame() {
        // given
        String[] names = {"홍길동", "전창길", "코난"};
        Ladder ladder = new Ladder(List.of(
            new Bridges(List.of(true, false, true)),
            new Bridges(List.of(true, false, true)),
            new Bridges(List.of(true, false, false)),
            new Bridges(List.of(false, false, false)),
            new Bridges(List.of(false, true, false))
            ));
        Players players = new Players(IntStream.range(0, names.length)
            .mapToObj(i -> Player.PlayerBuilder.builder()
                .name(names[i])
                .widthPosition(i)
                .heightPosition(1)
                .build())
            .collect(Collectors.toUnmodifiableList()));

        // when & then
        assertThat(new LadderGame(players, ladder)).isEqualTo(new LadderGame(players, ladder));
    }
}
