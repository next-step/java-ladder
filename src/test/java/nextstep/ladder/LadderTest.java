package nextstep.ladder;

import nextstep.ladder.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void init() {
        Point point1 = Point.init(true); // 0 , (false , true)
        Point point2 = point1.next(false);//  1, (true , false)
        Point point3 = point2.next(false);// 2 , (false, false)
        Point last = point3.next(false); //  3, (false ,false)
        LadderLine line1 = new LadderLine(Arrays.asList(point1, point2, point3, last));

        Point point4 = Point.init(false); // 0 , (false, false)
        Point point5 = point4.next(true); // 1, (false, true)
        Point point6 = point5.next(false); // 2, (true ,false)
        last = point6.last(); // 3 , (false, false)
        LadderLine line2 = new LadderLine(Arrays.asList(point4, point5, point6, last));

        Point point7 = Point.init(true);// 0 , (false , true)
        Point point8 = point7.next();// 1 , (true , false)
        Point point9 = point8.next(true);// 2 ,(false , true)
        last = point9.last(); // 3, ( true, false);
        LadderLine line3 = new LadderLine(Arrays.asList(point7, point8, point9, last));

        ladder = new Ladder(Arrays.asList(line1, line2, line3));
        // 사다리 모양
        // |-----|     |     |
        // |     |-----|     |
        // |-----|     |-----|

    }

    @Test
    @DisplayName("사다리 이동")
    void move() {
        assertAll(
                () -> assertThat(ladder.move(0)).isEqualTo(3),
                () -> assertThat(ladder.move(1)).isEqualTo(1),
                () -> assertThat(ladder.move(2)).isEqualTo(0),
                () -> assertThat(ladder.move(3)).isEqualTo(2)
        );
    }

    @Test
    void startGame() {
        Players players = new Players("cony,pobi,crong,cr7");
        Result result = new Result("꽝,1등,3등,2등");
        LadderGame ladderGame = new LadderGame(players, ladder);
        Result gameResult = ladderGame.start(result);
        assertAll(
                () -> assertThat(gameResult.get(0)).isEqualTo("2등"),
                () -> assertThat(gameResult.get(1)).isEqualTo("1등"),
                () -> assertThat(gameResult.get(2)).isEqualTo("꽝"),
                () -> assertThat(gameResult.get(3)).isEqualTo("3등")
        );
    }

    // 사다리 모양
    // |-----|     |     |
    // |     |-----|     |
    // |-----|     |-----|
    @Test
    void startGame2() {
        Players players = new Players("cony,pobi,crong,cr7");
        Result result = new Result("꽝,1000,10,0");
        LadderGame ladderGame = new LadderGame(players, ladder);
        Map<String, String> map = ladderGame.start1(result);
        assertAll(
                () -> assertThat(map.get("cony")).isEqualTo("0"),
                () -> assertThat(map.get("pobi")).isEqualTo("1000"),
                () -> assertThat(map.get("crong")).isEqualTo("꽝"),
                () -> assertThat(map.get("cr7")).isEqualTo("10")
        );
    }
}