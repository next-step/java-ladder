package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {

    @DisplayName("실행 결과 입력값에 따른 생성 테스트")
    @ParameterizedTest
    @MethodSource("makeLadderResultData")
    void from(String input, String ...inputs) {
        LadderResult ladderResult = LadderResult.from(input);

        assertThat(ladderResult).isEqualTo(new LadderResult(inputs));
    }

    private static Stream<Arguments> makeLadderResultData() {
        return Stream.of(
                Arguments.of("삼겹살,김밥,아이스크림", "삼겹살", "김밥", "아이스크림"),
                Arguments.of("광, 꼴찌,꽝,1등, 2등", "광", "꼴찌", "꽝", "1등", "2등"),
                Arguments.of("1000, 2000", "1000", "2000")
        );
    }

    @DisplayName("인덱스 별 결과 반환 테스트")
    @ParameterizedTest
    @MethodSource("makeGetResultByData")
    void getResultBy(String results, int index, String expectedResult) {
        LadderResult ladderResult = LadderResult.from(results);

        String actual = ladderResult.getResultBy(index);

        assertThat(actual).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> makeGetResultByData() {
        return Stream.of(
                Arguments.of("츄러스,마카롱,콘치즈", 1, "마카롱"),
                Arguments.of("1,2,3,4,5,6", 7, null),
                Arguments.of("프레첼,호떡,붕어빵,국화빵", 0, "프레첼")
        );
    }

}
