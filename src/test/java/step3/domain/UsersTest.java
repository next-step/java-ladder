package step3.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UsersTest {
    @Test
    void 이름은_5글자넘어가면_에러_발생() {
        assertThatThrownBy(() -> new Users(List.of("namename")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임에_참여한_유저가아니면_에러_발생() {
        assertThatThrownBy(() -> new Users(List.of("pobi", "honux", "crong", "jk")).findContainedName("ryan"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 인원수_반환() {
        assertThat(new Users(List.of("pobi", "crong", "jetty")).getUserCounts()).isEqualTo(3);
    }
}

