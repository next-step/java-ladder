package nextstep.ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NamesTest {

    private static final String NORMAL_NAME1 = "mojh";
    private static final String NORMAL_NAME2 = "mojh2";

    @Test
    @DisplayName("Names가 정상적으로 생성되어지는에 대한 테스트")
    public void constructorSuccessTest() {
        assertThat(new Names(
                List.of(
                        new Name(NORMAL_NAME1),
                        new Name(NORMAL_NAME2)
                )
        )).isEqualTo(new Names(
                List.of(
                        new Name(NORMAL_NAME1),
                        new Name(NORMAL_NAME2)
                )
        ));
    }

    @Test
    @DisplayName("Names를 생성할 때 하나만 값을 넣어 에러가 발생되어지는지에 대한 테스트.")
    public void constructorErrorTest() {
        assertThatThrownBy(() -> new Names(
                List.of(new Name(NORMAL_NAME1))
        )).isInstanceOf(IllegalArgumentException.class);
    }

}