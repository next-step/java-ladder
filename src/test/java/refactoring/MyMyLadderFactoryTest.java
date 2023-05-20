package refactoring;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import refactoring.domain.LadderFatory;
import refactoring.domain.MyLadderFactory;
import refactoring.domain.MyLineFactory;

class MyMyLadderFactoryTest {

    @DisplayName("깊이가 0이하이면 예외를 던진다.")
    @Test
    void test1() throws Exception {
        LadderFatory myLadderFactory = new MyLadderFactory(new MyLineFactory());
        assertThatThrownBy(() -> {
            myLadderFactory.create(0, 2);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("깊이는 1이상이어야 합니다.");

    }
}
