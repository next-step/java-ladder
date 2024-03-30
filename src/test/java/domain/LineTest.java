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
        Line line = new Line(1);
        assertThat(line.height()).isEqualTo(1);
    }

    @DisplayName("전략에 따라 bridge 를 생성하고, 정상적으로 생성되었는지 확인한다.")
    @TestFactory
    Collection<DynamicTest> test02() {
        Line line = new Line(3);
        return List.of(
                DynamicTest.dynamicTest("전략에 따라 bridge 를 생성한다.", () -> {
                    line.addBridges(new Line(3));
                    assertThat(line.hasBridge(0)).isTrue();
                }),
                DynamicTest.dynamicTest("전략에 맞춰 bridge 가 생성되었는지 확인한다.", () -> {
                    assertThat(line.hasBridge(1)).isTrue();
                })
        );
    }
}
