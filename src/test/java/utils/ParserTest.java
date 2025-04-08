package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParserTest {
    @Test
    @DisplayName("입력된 참가자 이름을 ','를 통해 구분한다.")
    void 스플릿_테스트() {
        Assertions.assertThat(Parser.split("pobi,honux,crong,jk")).isEqualTo(List.of("pobi", "honux", "crong", "jk"));
    }

    @Test
    @DisplayName("입력된 참가자 이름을 공백이 포함된 ','를 통해 구분한다.")
    void 스플릿_테스트2() {
        Assertions.assertThat(Parser.split("pobi, honux , crong, jk")).isEqualTo(List.of("pobi", "honux", "crong", "jk"));
    }
}
