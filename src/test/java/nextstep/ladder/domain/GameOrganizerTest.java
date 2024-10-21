package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameOrganizerTest {

    @Test
    void create() {
        assertThat(GameOrganizer.of("pobi,honux,crong,jk", "꽝, 5000, 3000, 꽝"))
                .isEqualTo(new GameOrganizer(
                        Stream.of("pobi", "honux", "crong", "jk").map(Player::new).collect(Collectors.toList()),
                        List.of("꽝", "5000", "3000", "꽝")));
    }

    @Test
    void 입력받은_사다리_결과가_빈문자일때_예외_발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameOrganizer.of("pobi,honux,crong,jk", ""));
    }

    @ParameterizedTest
    @CsvSource(value = {":꽝, 5000, 3000, 꽝", "pobisdfsd,honux,crong,jk:꽝, 5000, 3000, 꽝"}, delimiter = ':')
    void 참가자_이름이_5자초과_또는_빈문자일때_예외_발생(String players, String ladderResults) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameOrganizer.of(players, ""));
    }

    @Test
    void 참가자_수와_사다리_결과_수가_일치하지_않을때_예외발생() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                GameOrganizer.of("pobi,honux,crong,jk", "꽝, 5000, 3000"));
    }
}
