package nextstep.ladder.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderRequestDtoTest {

    private LadderRequestDto createLadderRequestDto(List<String> names, int height) {
        return new LadderRequestDto(names, height);
    }

    @Test
    @DisplayName("참여할 사람이 1명일 경우 Exception")
    void validateNamesTest() {
        assertThatThrownBy(() -> this.createLadderRequestDto(Arrays.asList("iljun"), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여할 사람이 비어있을 경우 Exception")
    void validateEmptyNameTest() {
        assertThatThrownBy(() -> this.createLadderRequestDto(Collections.EMPTY_LIST, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여할 사람이 null일 경우 Exception")
    void validateNullNameTest() {
        assertThatThrownBy(() -> this.createLadderRequestDto(null, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideNotValidHeight")
    @DisplayName("높이가 1보다 작은 경우 Exception")
    void validateHeightTest(List<String> names, int height) {
        assertThatThrownBy(() -> this.createLadderRequestDto(names, height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNotValidHeight() {
        return Stream.of(
                Arguments.of(Arrays.asList("iljun", "iljun2"), 1),
                Arguments.of(Arrays.asList("iljun", "iljun2"), 0),
                Arguments.of(Arrays.asList("iljun", "iljun2"), -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidRequestDto")
    @DisplayName("정상 파라미터 테스트")
    void createRequestDtoTest(List<String> names, int height) {
        LadderRequestDto ladderRequestDto = this.createLadderRequestDto(names, height);
        assertThat(ladderRequestDto.getNames()).isEqualTo(names);
        assertThat(ladderRequestDto.getHeight()).isEqualTo(height);
    }

    private static Stream<Arguments> provideValidRequestDto() {
        return Stream.of(
                Arguments.of(Arrays.asList("iljun", "iljun2"), 3),
                Arguments.of(Arrays.asList("iljun", "iljun2", "iljun3"), 5),
                Arguments.of(Arrays.asList("iljun", "iljun2", "iljun4", "iljun5"), 2)
        );
    }
}
