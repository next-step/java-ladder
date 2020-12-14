package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultsTest {

    private GameResults gameResults;

    @BeforeEach
    void SetUp() {
        Users users = Users.of("pobi,honux,crong,jk");
        Line line = new Line(Arrays.asList(
                Point.of(0,Pointer.of(false,true)),
                Point.of(1,Pointer.of(true,false)),
                Point.of(2,Pointer.of(false,true)),
                Point.of(3,Pointer.of(true,false))
        ));

        Line line2 = new Line(Arrays.asList(
                Point.of(0,Pointer.of(false,true)),
                Point.of(1,Pointer.of(true,false)),
                Point.of(2,Pointer.of(false,true)),
                Point.of(3,Pointer.of(true,false))
        ));

        Lines lines = new Lines(Arrays.asList(line,line2));
        GameReward gameReward = GameReward.of("꽝,5000,꽝,3000");
        this.gameResults = GameResults.of(Ladder.of(users,lines),gameReward);
    }

    @Test
    @DisplayName("GameResults 객체 비교")
    void gameResults_results_isEqualTo() {
        Users users = Users.of("pobi,honux,crong,jk");
        Line line = new Line(Arrays.asList(
                Point.of(0,Pointer.of(false,true)),
                Point.of(1,Pointer.of(true,false)),
                Point.of(2,Pointer.of(false,true)),
                Point.of(3,Pointer.of(true,false))
        ));

        Line line2 = new Line(Arrays.asList(
                Point.of(0,Pointer.of(false,true)),
                Point.of(1,Pointer.of(true,false)),
                Point.of(2,Pointer.of(false,true)),
                Point.of(3,Pointer.of(true,false))
        ));

        Lines lines = new Lines(Arrays.asList(line,line2));
        GameReward gameReward = GameReward.of("꽝,5000,꽝,3000");

        assertThat(gameResults).isEqualTo(GameResults.of(Ladder.of(users,lines),gameReward));
    }
}
