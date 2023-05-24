package ladder.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import ladder.domain.result.GameResult;
import ladder.domain.Ladder;
import ladder.domain.result.LadderResult;
import ladder.domain.name.Name;
import ladder.domain.name.Names;
import ladder.domain.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    ByteArrayOutputStream output;

    @BeforeEach
    void 초기화() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    void 전체_사다리_결과() {
        Map<Name, Position> map = Map.of(
            Name.of("a"), Position.of(1, 0),
            Name.of("b"), Position.of(1, 1),
            Name.of("c"), Position.of(1, 2),
            Name.of("d"), Position.of(1, 3)
        );
        OutputView.printGameResultOfAll(GameResult.of(map), LadderResult.of("1000,5000,3000,15000"), Names.of("a,b,c,d"));

        assertThat(output.toString()).containsPattern("실행 결과\\n(\\S{1,5} : .+\\n){4}");
    }

    @Test
    void 입력이름_사다리_결과() {
        Map<Name, Position> map = Map.of(
            Name.of("a"), Position.of(1, 0),
            Name.of("b"), Position.of(1, 1),
            Name.of("c"), Position.of(1, 2),
            Name.of("d"), Position.of(1, 3)
        );
        OutputView.printGameResultOf(GameResult.of(map), LadderResult.of("1000,5000,3000,15000"), Name.of("a"));
        OutputView.printGameResultOf(GameResult.of(map), LadderResult.of("1000,5000,3000,15000"), Name.of("b"));
        OutputView.printGameResultOf(GameResult.of(map), LadderResult.of("1000,5000,3000,15000"), Name.of("c"));
        OutputView.printGameResultOf(GameResult.of(map), LadderResult.of("1000,5000,3000,15000"), Name.of("d"));

        assertAll(
            () -> assertThat(output.toString()).containsPattern("1000"),
            () -> assertThat(output.toString()).containsPattern("5000"),
            () -> assertThat(output.toString()).containsPattern("3000"),
            () -> assertThat(output.toString()).containsPattern("15000")
        );
    }

    @Test
    void 결과를보고싶은사람_문구() {
        OutputView.printGameResultOf();

        assertThat(output.toString()).containsPattern("결과를 보고 싶은 사람은?");
    }

    @Test
    void 사다리결과_출력() {
        OutputView.printLadderResult(LadderResult.of("꽝,5000,꽝,3000"), 3);

        assertThat(output.toString()).containsPattern("(.+ {0,3}){4}");
    }

    @Test
    void 실행결과_사다리_문구() {
        OutputView.printLadderResult();

        assertThat(output.toString()).containsPattern("사다리 결과\n");
    }

    @Test
    void 실행결과_사다리_출력() {
        Ladder ladder = Ladder.of(3, 3);
        OutputView.printLadder(ladder, 3);

        assertThat(output.toString()).containsPattern("(\\|[- ]{3}\\|[- ]{3}\\|[- ]{3}\\|\n){3}");
    }

    @Test
    void 실행결과_이름_출력() {
        OutputView.printNames(Names.of(List.of(Name.of("a"), Name.of("b"), Name.of("c"))), 3);

        assertThat(output.toString()).containsPattern("(\\S{1,5} {0,3}){3}");
    }

    @Test
    void 실행결과_출력() {
        OutputView.printResult();

        assertThat(output.toString()).containsPattern("\n실행결과\n");
    }

}
