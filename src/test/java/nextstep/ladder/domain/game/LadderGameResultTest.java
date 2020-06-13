package nextstep.ladder.domain.game;

import nextstep.ladder.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderGameResultTest {

    @MethodSource("유저_리스트_생성")
    @ParameterizedTest
    @DisplayName("사다리 게임 결과 생성 테스트")
    void create(List<User> users) {
        assertThatCode(() -> new LadderGameResult(users)).doesNotThrowAnyException();
    }


    private static Stream<Arguments> 유저_리스트_생성() {
        List<User> users = Arrays.asList(
                User.newInstance("pobi", Order.from(1)),
                User.newInstance("ray", Order.from(2)),
                User.newInstance("ray", Order.from(3)));

        return Stream.of(Arguments.of(users));
    }
}
