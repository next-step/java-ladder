package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    @DisplayName("index 로 result 를 찾는다.")
    void test01() {
        Result result = new Result(List.of("1", "꽝", "2"));

        String findResult = result.result(new Position(0));

        assertThat(findResult).isEqualTo("1");
    }

}
