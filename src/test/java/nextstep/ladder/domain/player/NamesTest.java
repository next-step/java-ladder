package nextstep.ladder.domain.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Names 테스트")
class NamesTest {

    private Names names;

    @BeforeEach
    void setUp() {
        names = new Names("test1", " test2", "test3");
    }

    @DisplayName("쉼표를 기준으로 이름을 구분할 수 있다. - 사이즈 확인")
    @Test
    void names() {
        assertThat(names.size()).isEqualTo(3);
    }

    @DisplayName("쉼표를 기준으로 이름을 구분할 수 있다. - Element 값 확인")
    @ParameterizedTest
    @ValueSource(strings = {"test1", "test2", "test3"})
    void names(String input) {
        assertThat(names.contains(new Name(input))).isTrue();
    }
}