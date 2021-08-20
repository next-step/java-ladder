package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.CommonConstans.ONE_BLANK_SPACE;

public class ExecuteLadderTest {
    @Test
    @DisplayName("라인 생성 테스트")
    void ladderGame() {
        ExecuteLadderGame executeLadderGame = ExecuteLadderGame.of("test1,test2,test3,test4", 5);

        executeLadderGame.getPlayers()
                .stream()
                .map(player -> player.getPlayer() + ONE_BLANK_SPACE)
                .forEach(System.out::print);

        System.out.println();
        executeLadderGame.getladders()
                .forEach(ladder -> System.out.println(ladder.getStringLine()));
    }

}
