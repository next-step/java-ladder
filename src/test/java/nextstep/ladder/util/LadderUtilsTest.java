package nextstep.ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LadderUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"false,false"}, delimiter = ',')
    @DisplayName("사다리 다리연결여부 이전 false , 현재 false")
    void isOpenBridge_F_FTest(boolean prevOpen, boolean thisPoint) {
        assertFalse(LadderUtils.isOpenBridge(prevOpen, thisPoint));
    }

    @ParameterizedTest
    @CsvSource(value = {"false,true"}, delimiter = ',')
    @DisplayName("사다리 다리연결여부 이전 false , 현재 true")
    void isOpenBridge_F_TTest(boolean prevOpen, boolean thisPoint) {
        assertTrue(LadderUtils.isOpenBridge(prevOpen, thisPoint));
    }

    @ParameterizedTest
    @CsvSource(value = {"true,true"}, delimiter = ',')
    @DisplayName("사다리 다리연결여부 이전 true , 현재 true")
    void isOpenBridge_T_TTest(boolean prevOpen, boolean thisPoint) {
        assertFalse(LadderUtils.isOpenBridge(prevOpen, thisPoint));
    }

    @ParameterizedTest
    @CsvSource(value = {"true,false"}, delimiter = ',')
    @DisplayName("사다리 다리연결여부 이전 true , 현재 false")
    void isOpenBridge_T_FTest(boolean prevOpen, boolean thisPoint) {
        assertFalse(LadderUtils.isOpenBridge(prevOpen, thisPoint));
    }

}