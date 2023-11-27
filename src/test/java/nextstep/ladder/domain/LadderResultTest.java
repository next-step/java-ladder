package nextstep.ladder.domain;

import nextstep.ladder.exception.MisMatchNameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderResultTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi:꽝", "honux:5000", "crong:꽝", "jk:3000"}, delimiter = ':')
    @DisplayName("성공 - 이름에 해당하는 결과를 구한다.")
    void success_find_result_by_name(String name, String prize) {
        LadderResult ladderResult = new LadderResult(
                Map.of(
                        new Name("pobi"), new Prize("꽝"),
                        new Name("honux"), new Prize("5000"),
                        new Name("crong"), new Prize("꽝"),
                        new Name("jk"), new Prize("3000")
                )
        );
        assertThat(ladderResult.result(name)).isEqualTo(new Prize(prize));
    }

    @Test
    @DisplayName("실패 - 이름에 해당하는 결과가 없을 경우 예외가 발생한다.")
    void fail_find_result_by_name() {
        LadderResult ladderResult = new LadderResult(
                Map.of(
                        new Name("pobi"), new Prize("꽝"),
                        new Name("honux"), new Prize("5000"),
                        new Name("crong"), new Prize("꽝"),
                        new Name("jk"), new Prize("3000")
                )
        );

        Assertions.assertThatThrownBy(() -> ladderResult.result("kwc"))
                .isInstanceOf(MisMatchNameException.class)
                .hasMessage("kwc 이름을 가진 사람은 존재 하지 않습니다.");
    }

}
