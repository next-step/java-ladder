package step04.model;

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

public class LadderUserTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        LadderUser user = new LadderUser("user");

        // when & then
        assertThat(user).isEqualTo(new LadderUser("user"));
    }

    @DisplayName("생성 실패 테스트 - 이름이 5자를 초과한 경우")
    @Test
    void create_실패_길이제한초과() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderUser("exceed");
        });
    }

    @DisplayName("names 리스트를 통해 User 객체 리스트를 만드는 로직 테스트")
    @ParameterizedTest
    @MethodSource("provideUserNamesAndResult")
    void makeUsersFromNames(List<String> userNames, List<LadderUser> expected) {
        // when
        List<LadderUser> result = LadderUser.makeUsersFromNames(userNames);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideUserNamesAndResult() {
        return Stream.of(
                Arguments.of(Arrays.asList("kim", "hs", "test"),
                        Arrays.asList(new LadderUser("kim"), new LadderUser("hs"),
                                new LadderUser("test"))),
                Arguments.of(Arrays.asList("name1", "name2", "name3"),
                        Arrays.asList(new LadderUser("name1"), new LadderUser("name2"),
                                new LadderUser("name3"))),
                Arguments.of(Arrays.asList("hard", "to", "test"),
                        Arrays.asList(new LadderUser("hard"), new LadderUser("to"),
                                new LadderUser("test")))
        );
    }
}
