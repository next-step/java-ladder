package ladder.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.Names;
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
    void 실행결과_사다리_출력() {
        Ladder ladder = Ladder.of(3, 3);
        OutputView.printLadder(ladder, 3);

        assertThat(output.toString()).containsPattern("(\\|[- ]{3}\\|[- ]{3}\\|[- ]{3}\\|\n){3}");
    }

    @Test
    void 실행결과_이름_출력() {
        OutputView.printNames(Names.of(List.of("a", "b", "c")), 3);

        assertThat(output.toString()).containsPattern("(\\S{1,5} {0,3}){3}");
    }

    @Test
    void 실행결과_출력() {
        OutputView.printResult();

        assertThat(output.toString()).containsPattern("\n실행결과\n");
    }

}
