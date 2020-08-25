package com.hskim.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

    @DisplayName("유저 이름 리스트를 통해 UserName 객체 리스트를 만드는 로직 테스트")
    @ParameterizedTest
    @MethodSource("provideNamesAndResult")
    void makeUserNamesFromNames(List<String> names, List<UserName> expected) {
        // when
        List<UserName> result = UserName.makeUserNamesFromNames(names);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNamesAndResult() {
        return Stream.of(
                Arguments.of(Arrays.asList("kim", "hs", "test"),
                        Arrays.asList(new UserName("kim"), new UserName("hs"), new UserName("test"))),
                Arguments.of(Arrays.asList("java", "lad", "der"),
                        Arrays.asList(new UserName("java"), new UserName("lad"), new UserName("der"))),
                Arguments.of(Arrays.asList("name1", "name2", "name3"),
                        Arrays.asList(new UserName("name1"), new UserName("name2"), new UserName("name3")))
        );
    }
}
