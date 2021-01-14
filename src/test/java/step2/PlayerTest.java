package step2;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    @TestFactory
    Stream<DynamicTest> 참가자명에_대한_예외() {
        return Stream.of(
                DynamicTest.dynamicTest("null이면 예외", () -> {
                    assertThatThrownBy(() -> {
                        Player.newPlayer(null);
                    }).isInstanceOf(IllegalArgumentException.class);
                }),
                DynamicTest.dynamicTest("5자를 초과하면 예외", () -> {
                    assertThatThrownBy(() -> {
                        Player.newPlayer("이병덕이다요");
                    }).isInstanceOf(IllegalArgumentException.class);
                })
        );
    }
}