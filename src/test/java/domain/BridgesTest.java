package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgesTest {

    @DisplayName("높이에 따른 Bridge 를 생성할 수 있다.")
    @Test
    void test01() {
        Bridges bridges = new Bridges(5);
        int height = 1;

        bridges.create(height);

        assertThat(bridges.has(height)).isTrue();
    }
}
