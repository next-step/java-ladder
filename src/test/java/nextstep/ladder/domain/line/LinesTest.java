//package nextstep.ladder.domain.line;
//
//import nextstep.ladder.domain.RandomMovementGenerator;
//import nextstep.ladder.dto.LadderRequestDto;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//import java.util.stream.Stream;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//class LinesTest {
//
//    private Lines createLines(LadderRequestDto ladderRequestDto) {
//        return new Lines(ladderRequestDto, new RandomMovementGenerator(new Random()));
//    }
//
//    private LadderRequestDto createLadderRequestDto(List<String> names, List<String> results, int height) {
//        return new LadderRequestDto(names, results, height);
//    }
//
//    @ParameterizedTest
//    @MethodSource("provideLadderRequestDto")
//    @DisplayName("높이에 해당하는 라인 반환 테스트")
//    void findLineTest(List<String> names, List<String> results, int height) {
//        Lines lines = this.createLines(this.createLadderRequestDto(names, results, height));
//        Line line = lines.findLine(1);
//        assertThat(line).isNotNull();
//    }
//
//    private static Stream<Arguments> provideLadderRequestDto() {
//        return Stream.of(
//                Arguments.of(Arrays.asList("il", "il2"), Arrays.asList("1", "꽝"), 2),
//                Arguments.of(Arrays.asList("il", "il2", "il3"), Arrays.asList("1", "꽝", "5000"), 3),
//                Arguments.of(Arrays.asList("il", "il2", "il3", "il4"), Arrays.asList("1", "꽝", "5000", "꽝"), 4)
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("provideLadderRequestDtoAndFindHeight")
//    @DisplayName("존재하지 않는 라인일 경우 Exception")
//    void notFoundLineTest(List<String> names, List<String> results, int height, int findHeight) {
//        Lines lines = this.createLines(this.createLadderRequestDto(names, results, height));
//        assertThatThrownBy(() -> lines.findLine(findHeight))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    private static Stream<Arguments> provideLadderRequestDtoAndFindHeight() {
//        return Stream.of(
//                Arguments.of(Arrays.asList("il", "il2"), Arrays.asList("1", "꽝"), 2, 3),
//                Arguments.of(Arrays.asList("il", "il2", "il3"), Arrays.asList("1", "꽝", "5000"), 3, 99),
//                Arguments.of(Arrays.asList("il", "il2", "il3", "il4"), Arrays.asList("1", "꽝", "5000", "꽝"), 4, -1)
//        );
//    }
//}