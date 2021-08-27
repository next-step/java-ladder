package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.utils.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    @DisplayName("Player 리스트와 Line 리스트를 매개변수로 게임을 생성한다.")
    @Test
    void create() {
        String playerNames = "pobi,honux,crong,jk";
        List<Line> lines = Lists.list(Line.from(true, false, true), Line.from(true, false, true));
        assertThat(Game.of(playerNames, lines)).isEqualTo(Game.of(playerNames, lines));
    }

    @DisplayName("게임에 참가하지 않은 Player 입력시 에러가 발생한다.")
    @Test
    void validPlayerForResult() {
        String playerNames = "pobi,honux,crong,jk";
        List<Line> lines = Lists.list(Line.from(true, false, true), Line.from(true, false, true));
        Game game = Game.of(playerNames, lines);

        assertThatThrownBy(() -> game.play(Collections.singletonList(Player.from("hello"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("play함수 매개변수로 player list를 입력하면 결과위치 리스트를 출력한다.")
    @Test
    void play() {
        List<Player> playerList = StringUtils.splitWithComma("pobi,honux,crong,jk").stream()
                .map(Player::from)
                .collect(Collectors.toList());

        List<Line> lines = Lists.list(
                Line.from(false, true, false, true),
                Line.from(false, false, true, false),
                Line.from(false, true, false, false),
                Line.from(false, false, true, false),
                Line.from(false, true, false, true));
        Game game = Game.of(playerList, lines);

        List<Integer> result_pobi = game.play(Collections.singletonList(Player.from("pobi")));
        assertThat(result_pobi).containsExactly(0);

        List<Integer> result_all = game.play(playerList);
        assertThat(result_all).containsExactly(0, 3, 2, 1);
    }
}
