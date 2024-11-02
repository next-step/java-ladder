package nextstep.ladder;

import nextstep.ladder.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    private List<Player> players;
    private List<Prize> prizes;
    private Ladder ladder;

    @BeforeEach
    public void setUp() {
        players = new ArrayList<>();
        Player playerKim = new Player("김선수");
        Player playerLee = new Player("이선수");
        Player playerPark = new Player("박선수");
        Player playerChoi = new Player("최선수");
        players.addAll(List.of(playerKim, playerLee, playerPark, playerChoi));

        prizes = new ArrayList<>();
        Prize prize1000 = new Prize("1000원");
        Prize prize2000 = new Prize("2000원");
        Prize prize3000 = new Prize("3000원");
        Prize noPrize = new Prize("꽝");
        prizes.addAll(List.of(prize1000, prize2000, prize3000, noPrize));

        ladder = new Ladder(4,
                List.of(new Line(true, false, true), new Line(false, true, false), new Line(true, false, false),
                        new Line(false, true, false), new Line(true, false, true)
                )
        );
    }

    @Test
    void play_사다리게임을_실행하면_게임결과를_반환한다() {
        LadderGameResult gameResult = new LadderGame(players, prizes, ladder).play();

        Iterator<Integer> expectedPrizes = List.of(0, 3, 2, 1)
                .iterator();
        players.forEach(
                player -> assertThat(gameResult.getValue()).containsEntry(player, prizes.get(expectedPrizes.next())));
    }
}
