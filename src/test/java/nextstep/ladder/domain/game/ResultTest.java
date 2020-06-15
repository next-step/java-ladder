package nextstep.ladder.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    @DisplayName("결과 생성 테스트")
    void create(){
        Result result = Result.from("꽝");
        assertThat(result).isEqualTo(Result.from("꽝"));
    }
}
