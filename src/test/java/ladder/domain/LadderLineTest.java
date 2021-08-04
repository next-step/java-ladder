package ladder.domain;

import javafx.scene.shape.Line;
import ladder.dto.response.LadderResult;
import ladder.exception.InvalidRopeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LadderLineTest {
    @ValueSource(strings = {
            "true,true,false",
            "true,true",
            "false,true,true,false",
            "false,false,true,true,false"
    })
    @ParameterizedTest
    public void 이어지는_로프_테스트(String strRopes) {
        List<Rope> ropes = Arrays.stream(strRopes.split(","))
                .map(Boolean::valueOf)
                .map(Rope::of)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> LadderLine.of(ropes))
                .isInstanceOf(InvalidRopeException.class);
    }

    @ValueSource(strings = {
            "true,false",
            "false,true,false,false",
            "false,false,true,false,true"
    })
    @ParameterizedTest
    public void 이어지는_로프_테스트_통과(String strRopes) {
        List<Rope> ropes = Arrays.stream(strRopes.split(","))
                .map(Boolean::valueOf)
                .map(Rope::of)
                .collect(Collectors.toList());

        assertThatCode(() -> LadderLine.of(ropes))
                .doesNotThrowAnyException();
    }

    @DisplayName("이동 방향 결정 테스트")
    @Test
    public void moveDirectionTest() {
        LadderLine ladderLine = LadderLine.of(
                Stream.of(false, true, false, true)
                .map(Rope::of)
                .collect(Collectors.toList())
        );

        assertThat(
            ladderLine.moveDirection(0)
        ).isEqualTo(MoveDirection.RIGHT);
        assertThat(
                ladderLine.moveDirection(1)
        ).isEqualTo(MoveDirection.LEFT);
        assertThat(
                ladderLine.moveDirection(2)
        ).isEqualTo(MoveDirection.RIGHT);
        assertThat(
                ladderLine.moveDirection(3)
        ).isEqualTo(MoveDirection.LEFT);
    }
}