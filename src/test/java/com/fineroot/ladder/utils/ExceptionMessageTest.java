package com.fineroot.ladder.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ExceptionMessageTest {
    @ParameterizedTest
    @CsvSource({"UTILITY_CLASS,'Utility class는 생성을 허용하지 않습니다.'"})
    void getMessage(ExceptionMessage input, String expected) {
        assertThat(input.getMessage()).isEqualTo(expected);
    }
}
