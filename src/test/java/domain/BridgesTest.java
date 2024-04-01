package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgesTest {

    @DisplayName("특정 높이의 bridge 를 생성하거나, 제거한다.")
    @TestFactory
    Collection<DynamicTest> test01() {
        Bridges bridges = new Bridges(5);
        int height = 1;
        return List.of(
                DynamicTest.dynamicTest("특정 높이에 다리를 생성한다.", () -> {
                    bridges.create(height);
                    assertThat(bridges.has(height)).isTrue();
                }),
                DynamicTest.dynamicTest("특정 높이에 다리를 제거한다.", () -> {
                    bridges.remove(height);
                    assertThat(bridges.has(height)).isFalse();
                })
        );
    }
}
