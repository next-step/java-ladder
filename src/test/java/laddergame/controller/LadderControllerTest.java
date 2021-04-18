package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Result;
import laddergame.domain.ladder.Results;
import laddergame.domain.ladder.Size;
import laddergame.domain.player.Name;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static laddergame.controller.LadderController.makeLadder;
import static laddergame.domain.ladder.LadderTest.makeTestLadder;
import static laddergame.domain.player.PlayersTest.makeTestPlayers;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderControllerTest {
    private static final int MATCH_NUM = -1;
    private Results results;
    private List<Result> resultList;
    private List<Integer> moveIndexList;
    private int numbers = 4;
    private int height = 5;

    @BeforeEach
    void setUp() {
        Ladder ladder = makeTestLadder(new Size(height, numbers));
        moveIndexList = Arrays.asList(2, 3, 0, 1);
        resultList = Arrays.asList(new Result("꽝"), new Result("1000"), new Result("2000"), new Result("3000"));
        results = new Results(resultList);
        LadderController.statistics(ladder, results);
    }

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
        Ladder ladder = makeLadder(size, () -> true);

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
        Players players = makeTestPlayers(numbers);
        int index = 3;
        Map<Player, Result> predict = new HashMap<>();
        predict.put(players.getOne(index), resultList.get(moveIndexList.get(index)));

        Map<Player, Result> result = LadderController.matchPlayer(players, "이름" + index);

        assertThat(result).isEqualTo(predict);
    }

    @Test
    @DisplayName("모든 이름과 매치해야할때는 MATCH_ALL를 반환한다.")
    void all찾기() {
        Players players = makeTestPlayers(numbers);
        Map<Player, Result> predict = new HashMap<>();
        for (int i = 0; i < numbers; i++) {
            predict.put(players.getOne(i), resultList.get(moveIndexList.get(i)));
        }

        Map<Player, Result> result = LadderController.matchPlayer(players, "all");

        assertThat(result).isEqualTo(predict);
    }

}
