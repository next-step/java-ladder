package nextstep.ladder.domain.endpoint;

import nextstep.ladder.domain.exception.InputInvalidException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

class EndpointsTest {
    private Endpoints endpoints;

    @BeforeEach
    void setUp() {
        endpoints = Endpoints.from("꽝,5000,꽝,3000");
    }

    @Test
    void arriveAt() {
        List<String> strings = endpoints.arriveAt();
        Assertions.assertThat(strings).containsExactly("꽝", "5000", "꽝", "3000");
    }

    @Test
    void size() {
        int size = endpoints.size();
        Assertions.assertThat(size).isEqualTo(4);
    }

    @Test
    void initException() {
        assertAll(
                () -> Assertions.assertThatThrownBy(() -> Endpoints.from("꽝5000꽝3000"))
                                .isInstanceOf(InputInvalidException.class)
                                .hasMessage("입력이 잘못됐습니다."),

                () -> Assertions.assertThatThrownBy(() -> Endpoints.from(null))
                                .isInstanceOf(InputInvalidException.class)
                                .hasMessage("입력이 없습니다.")
        );
    }
}
