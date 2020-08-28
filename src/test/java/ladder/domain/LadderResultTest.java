package ladder.domain;

import ladder.exception.LadderExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderResultTest {

    @DisplayName("실행 결과 입력값에 따른 생성 테스트")
    @ParameterizedTest
    @MethodSource("makeLadderResultData")
    void from(String names, String input, String... inputs) {
        Participants participants = Participants.of(names);
        LadderResult ladderResult = LadderResult.of(participants, input);

        assertThat(ladderResult).isEqualTo(new LadderResult(inputs));
    }

    private static Stream<Arguments> makeLadderResultData() {
        return Stream.of(
                Arguments.of("p1,p2,p3", "삼겹살,김밥,아이스크림", "삼겹살", "김밥", "아이스크림"),
                Arguments.of("p1,p2,p3,p4,p5", "광, 꼴찌,꽝,1등, 2등", "광", "꼴찌", "꽝", "1등", "2등"),
                Arguments.of("p1,p2", "1000, 2000", "1000", "2000")
        );
    }

    @DisplayName("실행 결과를 참가자 수와 다르게 입력한 경우 테스트")
    @ParameterizedTest
    @MethodSource("makeLadderResultInvalidData")
    void from_shortage_ladder_result(String names, String input) {
        Participants participants = Participants.of(names);
        String exceptionMessage = LadderExceptionMessage.INVALID_LADDER_RESULT_COUNT;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderResult.of(participants, input))
                .withMessage(exceptionMessage);
    }

    private static Stream<Arguments> makeLadderResultInvalidData() {
        return Stream.of(
                Arguments.of("p1,p2", "1등,2등,3등,4등,5등"),
                Arguments.of("p1,p2,p3,p4,p5,p6", "1등,2등,3등,4등"),
                Arguments.of("p1", "")
        );
    }

    @DisplayName("인덱스 별 결과 반환 테스트")
    @ParameterizedTest
    @MethodSource("makeGetResultByData")
    void getResultBy(String names, String results, int index, String expectedResult) {
        Participants participants = Participants.of(names);
        LadderResult ladderResult = LadderResult.of(participants, results);

        String actual = ladderResult.getResultBy(index);

        assertThat(actual).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> makeGetResultByData() {
        return Stream.of(
                Arguments.of("p1,p2,p3", "츄러스,마카롱,콘치즈", 1, "마카롱"),
                Arguments.of("p1,p2,p3,p4,p5,p6", "1,2,3,4,5,6", 7, null),
                Arguments.of("p1,p2,p3,p4", "프레첼,호떡,붕어빵,국화빵", 0, "프레첼")
        );
    }

}
