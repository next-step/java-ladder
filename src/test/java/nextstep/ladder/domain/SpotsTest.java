package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SpotsTest {

    @ParameterizedTest
    @ValueSource(strings = {",,aa", " ,aa,bb"})
    public void 생성_실패_spot명_문제(String failNames) {
        assertThatThrownBy(() -> {
            new Spots(failNames, "0,500,1000");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 생성_실패_spot숫자_문제() {
        assertThatThrownBy(() -> {
            new Spots("aa,bb,cc", "0,500,500,1000");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}