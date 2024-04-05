package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("높이를 기반으로 Line 객체를 생성할 수 있다.")
    @Test
    void test01() {
        Line line = Line.createWithBridges(1, () -> true);
        assertThat(line.height()).isEqualTo(1);
    }

    @DisplayName("전략에 따라 bridge 를 생성하고, 정상적으로 생성되었는지 확인한다.")
    @TestFactory
    Collection<DynamicTest> test02() {
        int height = 5;
        Line prev = Line.createWithBridges(height, () -> false);
        return List.of(
                DynamicTest.dynamicTest("전략에 따라 bridge 를 생성한다.", () -> {
                    prev.addBridges(() -> true);
                    assertThat(prev.hasBridge(height)).isTrue();
                }),
                DynamicTest.dynamicTest("이전 Line 객체의 동일 높이의 bridge 가 생성되었다면, 현재 Line 객체의 동일 높이 bridge 는 제거한다.", () -> {
                    Line cur = Line.createWithBridges(height, () -> true);
                    cur.resetBridges(prev);
                    assertThat(cur.hasBridge(height)).isFalse();
                })
        );
    }

    @DisplayName("다리 (Bridge) 유무를 확인한다.")
    @Test
    void test03() {
        Line line = Line.createWithBridges(3, () -> true);
        assertThat(line.isBridge(1)).isTrue();
    }
}
