package step1.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class LadderGameStarterTest {

    @Test
    @DisplayName("사다리 게임 결과가 정상적으로 생성되는지 테스트")
    void start() {
        // given
        Lines lines = Lines.from(List.of(
            Line.from(List.of(new Bridge(false), new Bridge(false), new Bridge(false), new Bridge(false))),
            Line.from(List.of(new Bridge(true), new Bridge(false), new Bridge(true), new Bridge(false))),
            Line.from(List.of(new Bridge(false), new Bridge(true), new Bridge(false), new Bridge(true))),
            Line.from(List.of(new Bridge(true), new Bridge(false), new Bridge(true), new Bridge(false))))
        );
        Ladder ladder = new Ladder(lines);
        UserNames userNames = UserNames.from(List.of("pobi", "honux", "crong", "jk"));
        List<Prize> prizes = Prize.from(List.of("꽝", "5000", "꽝", "3000"));

        Map<UserName, Prize> ladderGoalMap = new HashMap<>();
        ladderGoalMap.put(new UserName("pobi"), new Prize("3000"));
        ladderGoalMap.put(new UserName("crong"), new Prize("5000"));
        ladderGoalMap.put(new UserName("honux"), new Prize("꽝"));
        ladderGoalMap.put(new UserName("jk"), new Prize("꽝"));

        // when
        LadderGameResult ladderGameResult = LadderGameStarter.start(ladder, userNames, prizes);

        // then
        then(ladderGameResult).isEqualTo(new LadderGameResult(ladderGoalMap));
    }

    @Test
    @DisplayName("사다리 넓이와 userNames, prizes 개수가 동일하지 않은 경우 에러 발생")
    void validateLadderGame() {
        Lines oneLines = Lines.from(List.of(
            Line.from(List.of(new Bridge(false), new Bridge(false))))
        );
        Ladder ladder = new Ladder(oneLines);

        assertThatIllegalArgumentException().isThrownBy(
            () -> LadderGameStarter.start(
                ladder,
                UserNames.from(List.of("pobi")),
                Prize.from(List.of("꽝", "5000"))
            )
        );

        assertThatIllegalArgumentException().isThrownBy(
            () -> LadderGameStarter.start(
                ladder,
                UserNames.from(List.of("pobi", "honux")),
                Prize.from(List.of("꽝"))
            )
        );
    }
}