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

class LadderRequestDtoTest {

    private LadderRequestDto createLadderRequestDto(List<String> names, List<String> results, int height) {
        return new LadderRequestDto(names, results, height);
    }

    @Test
    @DisplayName("참여할 사람이 1명일 경우 Exception")
    void validateNamesTest() {
        assertThatThrownBy(() -> this.createLadderRequestDto(Arrays.asList("iljun"), Arrays.asList("5000"), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여할 사람이 비어있을 경우 Exception")
    void validateEmptyNameTest() {
        assertThatThrownBy(() -> this.createLadderRequestDto(Collections.EMPTY_LIST, Arrays.asList("5000"), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여할 사람이 null일 경우 Exception")
    void validateNullNameTest() {
        assertThatThrownBy(() -> this.createLadderRequestDto(null, Arrays.asList("5000"), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideNotValidHeight")
    @DisplayName("높이가 1보다 작은 경우 Exception")
    void validateHeightTest(List<String> names, List<String> results, int height) {
        assertThatThrownBy(() -> this.createLadderRequestDto(names, results, height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNotValidHeight() {
        return Stream.of(
                Arguments.of(Arrays.asList("iljun", "iljun2"), Arrays.asList("5000", "꽝"), 1),
                Arguments.of(Arrays.asList("iljun", "iljun2"), Arrays.asList("5000", "꽝"), 0),
                Arguments.of(Arrays.asList("iljun", "iljun2"), Arrays.asList("5000", "꽝"), -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidRequestDto")
    @DisplayName("정상 파라미터 테스트")
    void createRequestDtoTest(List<String> names, List<String> results, int height) {
        LadderRequestDto ladderRequestDto = this.createLadderRequestDto(names, results, height);
        assertThat(ladderRequestDto.getNames()).isEqualTo(names);
        assertThat(ladderRequestDto.getHeight()).isEqualTo(height);
    }

    private static Stream<Arguments> provideValidRequestDto() {
        return Stream.of(
                Arguments.of(Arrays.asList("iljun", "iljun2"), Arrays.asList("5000", "꽝"), 3),
                Arguments.of(Arrays.asList("iljun", "iljun2", "iljun3"), Arrays.asList("5000", "꽝", "3000"), 5),
                Arguments.of(Arrays.asList("iljun", "iljun2", "iljun4", "iljun5"), Arrays.asList("5000", "꽝", "꽝", "7000"), 2)
        );
    }

    @Test
    @DisplayName("사다리 결과가 비어있을때 exception")
    void validateEmptyResults() {
        assertThatThrownBy(() -> this.createLadderRequestDto(Arrays.asList("iljun"), Arrays.asList(""), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 결과가 빈 collection 일때 exception")
    void validateEmptyCollectionResults() {
        assertThatThrownBy(() -> this.createLadderRequestDto(Arrays.asList("iljun"), Collections.EMPTY_LIST, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 결과가 Null일때 exception")
    void validateNullResults() {
        assertThatThrownBy(() -> this.createLadderRequestDto(Arrays.asList("iljun"), null, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 결과에 잘못된 문자가 입력되었을때 Exception")
    void validateNotValidString() {
        assertThatThrownBy(() -> this.createLadderRequestDto(Arrays.asList("iljun"), Arrays.asList("iljun"), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
