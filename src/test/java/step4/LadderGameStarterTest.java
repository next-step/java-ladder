package step4;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Bridge;
import step4.domain.Ladder;
import step4.domain.LadderGameResult;
import step4.domain.LadderGameStarter;
import step4.domain.Line;
import step4.domain.Lines;
import step4.domain.Prize;
import step4.domain.UserName;
import step4.domain.UserNames;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class LadderGameStarterTest {

    @Test
    @DisplayName("사다리 게임의 결과가 정상적인지 테스트.")
    void start() {
        Ladder ladder = new Ladder(Lines.from(List.of(
            Line.from(List.of(new Bridge(false), new Bridge(false), new Bridge(false), new Bridge(false))),
            Line.from(List.of(new Bridge(true), new Bridge(false), new Bridge(true), new Bridge(false))),
            Line.from(List.of(new Bridge(false), new Bridge(true), new Bridge(false), new Bridge(true))),
            Line.from(List.of(new Bridge(true), new Bridge(false), new Bridge(true), new Bridge(false))))
        ));

        then(LadderGameStarter.start(
                ladder,
                UserNames.from(List.of("a", "b", "c", "d")),
                Prize.from(List.of("1", "2", "3", "4")))
        ).isEqualTo(new LadderGameResult(Map.of(
            new UserName("a"), new Prize("4"),
            new UserName("c"), new Prize("2"),
            new UserName("b"), new Prize("3"),
            new UserName("d"), new Prize("1")
        )));
    }

    @Test
    @DisplayName("사다리의 넓이와 userNames, prizes의 개수는 모두 동일하지 않다면 에러 발생.")
    void validateLadderGame() {
        Ladder ladder = new Ladder(Lines.from(List.of(
            Line.from(List.of(new Bridge(false), new Bridge(false))))
        ));

        assertThatIllegalArgumentException().isThrownBy(
            () -> LadderGameStarter.start(ladder, UserNames.from(List.of("a")), Prize.from(List.of("1", "2")))
        );

        assertThatIllegalArgumentException().isThrownBy(
            () -> LadderGameStarter.start(ladder, UserNames.from(List.of("a", "b")), Prize.from(List.of("0")))
        );
    }
}