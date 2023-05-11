package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

public class NamesTest {

    @Test
    void 이름_너비() {
        assertThat(Names.of("a, b, c").properWidth()).isEqualTo(1);
    }

    @Test
    void 이름_개수() {
        assertThat(Names.of("a,b,c").count()).isEqualTo(3);
    }

    @Test
    void 이름목록생성_구분자() {
        assertThat(Names.of("a,b,c").names()).containsExactly("a", "b", "c");
    }

    @Test
    void 이름목록생성() {
        assertAll(
            () -> assertThat(Names.of(List.of("a", "b", "c")).names()).containsExactly("a", "b", "c"),
            () -> assertThat(Names.of(List.of("a", "b", "c"))).isEqualTo(Names.of(List.of("a","b","c")))
        );
    }

}
