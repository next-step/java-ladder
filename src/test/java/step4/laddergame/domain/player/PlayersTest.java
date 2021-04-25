package step4.laddergame.domain.player;

import com.google.common.collect.Streams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step4.laddergame.domain.ladder.Result;

import java.util.*;
import java.util.stream.IntStream;

import static laddergame.util.StringUtils.fitSpace;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    private List<Player> playerList = new ArrayList<>();
    private Players players;

    @BeforeEach
    void setUp() {
        List<String> names = Arrays.asList("이름0", "이름1", "이름2");
        players = Players.of(names);
        IntStream.range(0, 3)
                .forEach(i -> playerList.add(new Player(new Name("이름" + i))));
    }

    @Test
    void 플레이어목록을생성() {
        assertThat(players).isEqualTo(new Players(playerList));
    }

    @Test
    void 플레이어이름은_중복될수없다() {
        playerList.add(new Player(new Name("이름" + 1)));
        assertThatThrownBy(() -> {
            new Players(playerList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 플레이어목록은_비어있을수없다(List<?> input) {
        assertThatThrownBy(() -> {
            new Players((List<Player>) input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어의 이름이 일치하는 순번쨰 index를 반환한다.")
    void 이름이일치인덱스반환() {
        int index = 2;
        Name findName = new Name("이름" + index);
        int findIndex = players.whoseName(findName);
        assertThat(findIndex).isEqualTo(index);
    }

    @Test
    void 없는이름찾기() {
        assertThatThrownBy(() -> {
            players.whoseName(new Name("없는이름"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어의 순서와 결과리스트의 순서대로 결과맵에 매치한다.")
    void 결과매치() {
        Map<Player, Result> winning = new LinkedHashMap<>();
        List<Result> resultList = Arrays.asList(Result.of("결과1"), Result.of("결과2"), Result.of("결과3"));
        players.match(resultList, winning);
        Streams.forEachPair(winning.keySet().stream(), playerList.stream(), (key, player) -> {
            assertThat(key).isEqualTo(player);
        });
        Streams.forEachPair(winning.values().stream(), resultList.stream(), (value, result) -> {
            assertThat(value).isEqualTo(result);
        });
    }

    @Test
    void 플레이어목록프린트() {
        List<Player> playerList = players.getPlayers();
        playerList.stream()
                .forEach(player -> System.out.print(fitSpace(player.toString())));
        System.out.println();
    }

}
