package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RungsTest {

    @DisplayName("Point객체를 생성했을 때 앞 부분이 가로선이 생겼다면 그 다음 부분은 공백이 된다")
    @Test
    void points() {
        Rungs rungs = new Rungs(3, () -> true);
        assertThat(rungs.getRungs().get(1).isExist()).isFalse();
    }

    @DisplayName("참가자수(n)에 따라 Point는 (n - 1) 개만큼 생긴다")
    @Test
    void size() {
        assertThat(new Rungs(3, () -> true).size()).isEqualTo(2);
    }

    @DisplayName("점들이 각각 true인지 false인지 검증한다")
    @Test
    void validatePoints() {
        Rungs rungs = new Rungs(List.of(new Rung(true), new Rung(false), new Rung(true)));

        List<Boolean> booleans = rungs.validateRungs();

        Assertions.assertThat(booleans.get(0)).isTrue();
        Assertions.assertThat(booleans.get(1)).isFalse();
        Assertions.assertThat(booleans.get(2)).isTrue();
    }
}
