package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

public class NamesTest {

    @Test
    void 참가자한명() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Names.of("a"))
            .withMessageMatching("참가자는 두 명 이상이어야 합니다.");
    }

    @Test
    void 빈값() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Names.of(","))
            .withMessageMatching("이름 목록은 빈 값일 수 없습니다.");
    }

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
        assertThat(Names.of("a,b,c").names()).containsExactly(Name.of("a"), Name.of("b"), Name.of("c"));
    }

    @Test
    void 이름목록생성() {
        assertAll(
            () -> assertThat(Names.of(List.of(Name.of("a"), Name.of("b"), Name.of("c"))).names()).containsExactly(Name.of("a"), Name.of("b"), Name.of("c")),
            () -> assertThat(Names.of(List.of(Name.of("a"), Name.of("b"), Name.of("c")))).isEqualTo(Names.of(List.of(Name.of("a"), Name.of("b"), Name.of("c"))))
        );
    }

}
