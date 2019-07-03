package nextstep.step3.ladder.dto;

import nextstep.step3.ladder.domain.Name;
import nextstep.step3.ladder.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-03 17:58
 */
class ResultTest {
    @DisplayName("전달받은 이름을 통해 prize 반환하기")
    @Test
    void getPrize() {
        Name name = Name.of("kwon");
        Prize prize = Prize.of(1000);

        Map<Name, Prize> resultDto = new HashMap<>();
        resultDto.put(name, prize);
        Result result = new Result(resultDto);

        assertThat(result.getPrize("kwon")).isEqualTo(prize);
    }
}