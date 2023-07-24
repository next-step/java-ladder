package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PlayerTest {

    @Test
    void 이름_유효성_체크() {
        assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> new Player(null)
                ), () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> new Player("           ")
                ), () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> new Player("")
                ), () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> new Player("fiveover")
                )
        );
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"kbc:.    kbc", "kang:.   kang", "kbc12:.  kbc12"})
    void 이름_출력_테스트(String name, String expected) {
        String playerName = new Player(name).toString();

        assertThat(playerName).isEqualTo(expected.replace(".", ""));
    }


}
