package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @DisplayName("높이만큼의 라인들을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void line_height(int height) {
        Ladder ladder = Ladder.of(height, getPlayer(2));
        assertThat(ladder.getLines()).hasSize(height);
    }

    @DisplayName("높이는 최소 1이상이다. 1미만시 예외 발생")
    @Test
    void min_height() {
        assertThatThrownBy(() -> Ladder.of(0, getPlayer(2)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유저는 2명 이상이다. 2명 미만시 예외 발생")
    @Test
    void min_player() {
        assertThatThrownBy(() -> Ladder.of(4, getPlayer(1)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private List<String> getPlayer(int count) {
        return Stream.generate(() -> UUID.randomUUID().toString().substring(0, 5))
            .limit(count)
            .collect(Collectors.toList());
    }

}
