package nextstep.ladder.domain.game;

import nextstep.ladder.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameResultTest {

    @MethodSource("유저_리스트_생성")
    @ParameterizedTest
    @DisplayName("사다리 게임 결과 생성 테스트")
    void create(Map<User, Result> userResultMap) {
        assertThatCode(() -> new LadderGameResult(userResultMap)).doesNotThrowAnyException();
    }

    @NullSource
    @ParameterizedTest
    @DisplayName("사다리 게임 결과 생성 null 주입 예외 테스트")
    void exception(Map<User, Result> userResultMap) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGameResult(userResultMap));
    }


    private static Stream<Arguments> 유저_리스트_생성() {
        Map<User, Result> userResultMap = new HashMap<>();
        userResultMap.put(User.newInstance("pobi", Order.from(1)), Result.from("꽝"));
        userResultMap.put(User.newInstance("ray", Order.from(2)), Result.from("5000"));

        return Stream.of(Arguments.of(userResultMap));
    }
}
