package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {
    Names names;

    @BeforeEach
    void setUp() {
        names = Names.of("1,2");
    }

    @Test
    @DisplayName("Names.of 로 스트링을 초기화 할 수 있다.")
    void of() {
        assertThat(names.getNames()).contains(
                new Name("1"),
                new Name("2")
        );
    }

    @Test
    @DisplayName("특정 String 의 Index 를 indexOf 메서드를 통해 찾을 수 있다")
    void indexOf() {
        assertThat(names.indexOf("1")).isEqualTo(0);
    }

    @Test
    @DisplayName("특정 String 이 존재하지 않으면 IndexOf 는 -1을 반환한다")
    void indexOf2() {
        assertThat(names.indexOf("3")).isEqualTo(-1);
    }
}
