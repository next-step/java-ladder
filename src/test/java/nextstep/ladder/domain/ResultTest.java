package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ResultTest {

    @Test
    void 입력받은_이름이_참여할_이름목록에_없을경우_예외처리() {
        Result result = new Result(Map.of("pobi", "꽝"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> result.get("crong"))
                .withMessageContaining("해당하는 사람이 존재하지 않습니다.");
    }
}
