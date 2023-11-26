package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.engine.dto.NameAndResult;
import me.namuhuchutong.ladder.domain.implement.wrapper.Name;
import me.namuhuchutong.ladder.domain.implement.wrapper.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class NameAndResultTest {

    @DisplayName("결과에 존재하지 않는 키 값일 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_key_is_not_exist() {
        Map<Name, Result> givenMap = Map.of(new Name("test"), new Result("test"));
        String givenName = "hello";
        NameAndResult nameAndResult = new NameAndResult(givenMap, null);

        assertThatThrownBy(() -> nameAndResult.getResult(givenName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}