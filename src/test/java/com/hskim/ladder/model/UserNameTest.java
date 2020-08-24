package com.hskim.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserNameTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        UserName userName = new UserName("test");

        // when & then
        assertThat(userName).isEqualTo(new UserName("test"));
    }

    @DisplayName("생성 실패 테스트 - 이름이 5자를 초과한 경우")
    @Test
    void create_실패_이름길이제한초과() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new UserName("exceed");
        });
    }
}
