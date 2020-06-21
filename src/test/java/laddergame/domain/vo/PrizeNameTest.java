package laddergame.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PrizeNameTest {

    @DisplayName("당첨 결과명이 Null 또는 공백일때 IllegalArgumentException Throw")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyThrowException(String expectName) {
        assertThatThrownBy(() -> new PrizeName(expectName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 결과명은 Null 이나 공백일 수 없습니다.");
    }
}