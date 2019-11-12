package step2;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import step2.domain.PreDefinedBooleanGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.IOUtils.simulate;

class MainTest {

    @Test
    void name() {
        final String input = "" +
                "pobi,honux,crong,jk\n" +
                "5";
        final String expected = "" +
                "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\n" +
                "최대 사다리 높이는 몇 개인가요?\n" +
                "실행결과\n" +
                "\n" +
                "  pobi honux crong    jk\n" +
                "     |-----|     |-----|\n" +
                "     |     |-----|     |\n" +
                "     |-----|     |-----|\n" +
                "     |     |-----|     |\n" +
                "     |-----|     |-----|";

        final ByteArrayOutputStream simulate = simulate(input);
        Main.main(null, new PreDefinedBooleanGenerator(Arrays.asList(true, false)));
        assertThat(simulate.toString()).isEqualTo(expected);
    }
}