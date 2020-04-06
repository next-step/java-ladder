package nextstep.ladder.domain;

import nextstep.ladder.domain.exception.IllegalMaxLengthValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PrizeTest {

    @DisplayName("이름을 저장할 수 있다.")
    @Test
    void create() {
        String name = "boram";
        Prize prize = new Prize(name);
        assertThat(prize.getName()).isEqualTo(name);
    }

    @DisplayName("다섯글자 초과의 이름을 입력하면 에러가 난다.")
    @Test
    void maxLengthError() {
        assertThatExceptionOfType(IllegalMaxLengthValueException.class)
                .isThrownBy(() -> new Prize("luvram"));
    }
}
