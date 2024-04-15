package ladder.domain.result;

import static ladder.domain.ladder.line.LineTest.line;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.item.Item;
import ladder.domain.item.Items;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

class ResultTest {

    @Test
    @DisplayName("사다리 게임 결과를 생성한다.")
    void Result_LadderGame() {
        final Map<Player, Item> expectedResult = Map.of(
                new Player("kyle"), new Item("item3"),
                new Player("alex"), new Item("item2"),
                new Player("haley"), new Item("item1")
        );

        final Map<Player, Item> actualResult = result().getAll();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("사다리 기둥 개수가 동일하지 않은 경우 예외를 던진다.")
    void Result_DifferentCountBetweenPlayersAndColumns_Exception() {
        final Players players = Players.from(List.of("kyle", "alex", "haley"));
        final Ladder ladder = new Ladder(List.of(
                line(true, false, true),
                line(false, true, false),
                line(true, false, true)
        ));
        final Items items = Items.from(List.of("item1", "item2", "item3"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Result.of(players, ladder, items));
    }

    @Test
    @DisplayName("플레이어 수가 동일하지 않은 경우 예외를 던진다.")
    void Result_DifferentCountBetweenPlayersAndResults_Exception() {
        final Players players = Players.from(List.of("kyle", "alex", "haley", "harry"));
        final Ladder ladder = new Ladder(List.of(
                line(true, false),
                line(false, true),
                line(true, false)
        ));
        final Items items = Items.from(List.of("item1", "item2", "item3"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Result.of(players, ladder, items));
    }

    @Test
    @DisplayName("사다리 결과 개수가 동일하지 않은 경우 예외를 던진다.")
    void Result_DifferentCountBetweenColumnsAndResults_Exception() {
        final Players players = Players.from(List.of("kyle", "alex", "haley"));
        final Ladder ladder = new Ladder(List.of(
                line(true, false),
                line(false, true),
                line(true, false)
        ));
        final Items items = Items.from(List.of("item1", "item2", "item3", "item4"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Result.of(players, ladder, items));
    }

    @Test
    @DisplayName("특정 플레이어에 대한 결과를 반환한다.")
    void GetOne_ResultOfSinglePlayer() {
        assertThat(result().getOne("kyle"))
                .isEqualTo(new Item("item3"));
    }

    @Test
    @DisplayName("결과를 보고 싶은 플레이어가 존재하지 않는 경우 예외를 던진다.")
    void GetOne_ResultOfNotExistedPlayer_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> result().getOne("harry"));
    }

    private Result result() {
        final Players players = Players.from(List.of("kyle", "alex", "haley"));
        final Ladder ladder = new Ladder(List.of(
                line(true, false),
                line(false, true),
                line(true, false)
        ));
        final Items items = Items.from(List.of("item1", "item2", "item3"));

        return Result.of(players, ladder, items);
    }
}
