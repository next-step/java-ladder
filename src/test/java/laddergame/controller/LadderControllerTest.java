package laddergame.controller;

import laddergame.domain.ladder.*;
import laddergame.domain.player.Name;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static laddergame.domain.player.PlayersTest.makeTestPlayers;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderControllerTest {
    private static final int MATCH_NUM = -1;

    @Test
    void 참여자여러명생성() {
        List<String> names = Arrays.asList("참여1", "참여2", "참여3", "참여4");
        List<Player> playerList = names.stream()
                .map(name -> new Player(new Name(name)))
                .collect(Collectors.toList());

        Players players = LadderController.enroll(names);

        assertThat(players).isEqualTo(new Players(playerList));
    }

    @Test
    void 사다리생성() {
        Size size = new Size(5, 6);
        Ladder ladder = LadderController.makeLadder(size, () -> true);

        assertThat(ladder.getLines().size()).isEqualTo(5);
        ladder.getLines()
                .forEach(line ->
                        assertThat(line.isConnect()).containsAll(Collections.singleton(true)));
    }

    @Test
    @DisplayName("문자열로 이루어진 결과들의 목록을 생성한다.")
    void 결과생성() {
        List<String> resultList = Arrays.asList("꽝", "1000", "2000", "3000");
        Results results = LadderController.makeResults(resultList);

        for (int i = 0; i < resultList.size(); i++) {
            assertThat(results.getOne(i)).isEqualTo(new Result(resultList.get(i)));
        }
    }

    @Test
    @DisplayName("주어진 이름과 일치하는 플레이어의 인덱스를 반환한다.")
    void 이름한명찾기() {
        Players players = makeTestPlayers(5);
        int predict = 3;
        int index = LadderController.matchPlayer(players, "이름" + predict);

        assertThat(index).isEqualTo(predict);
    }

    @Test
    @DisplayName("모든 이름과 매치해야할때는 MATCH_ALL를 반환한다.")
    void all찾기() {
        Players players = makeTestPlayers(5);
        int index = LadderController.matchPlayer(players, "all");

        assertThat(index).isEqualTo(MATCH_NUM);
    }
}
