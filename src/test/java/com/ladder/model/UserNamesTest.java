package com.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserNamesTest {

    @DisplayName("콤마를 기준으로 여러 유저 이름을 생성하는데 성공한다")
    @Test
    void createUsername_whenManyUsers_success() {
        // given
        String names = "a,b,c,d,e";
        int expectedSize = 5;
        // when
        UserNames result = UserNames.of(names);
        // then
        assertThat(result.getUserNames()).contains(UserName.of("a"),
                                                    UserName.of("b"),
                                                    UserName.of("c"),
                                                    UserName.of("d"),
                                                    UserName.of("e"));
        assertThat(result.getUserNames()).hasSize(expectedSize);
    }
}