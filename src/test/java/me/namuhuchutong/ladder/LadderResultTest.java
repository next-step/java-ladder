package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.engine.dto.LadderResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LadderResultTest {

    @DisplayName("결과에 존재하지 않는 키 값일 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_key_is_not_exist() {
        Map<String, String> givenMap = Map.of("test", "test");
        String givenName = "hello";
        LadderResult ladderResult = new LadderResult("names",
                                                     "rows",
                                                     "prize",
                                                     givenMap);

        assertThatThrownBy(() -> ladderResult.getResult(givenName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}