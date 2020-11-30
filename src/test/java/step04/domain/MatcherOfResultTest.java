package step04.domain;

import exception.NotMatchedCountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step03.domain.Matcher;
import step03.domain.NamesOfResult;
import step03.domain.Participants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MatcherOfResultTest {
    Participants participants;
    NamesOfResult namesOfResult;
    List<Integer> matchTable;

    @BeforeEach
    void setup() {
        participants = Participants.of("pobi,honux,crong,jk");
        namesOfResult = NamesOfResult.of("꽝,5000,꽝,3000");
        matchTable = Arrays.asList(1, 0, 3, 2);
    }

    @DisplayName("생성자")
    @Test
    void test_constructor_of() {
        Matcher matcher = Matcher.Builder.of(participants)
                .namesOfResult(namesOfResult)
                .matchedTable(matchTable)
                .build();

        assertThat(matcher).isEqualTo(
                Matcher.Builder.of(participants)
                        .namesOfResult(namesOfResult)
                        .matchedTable(matchTable)
                        .build());
    }

    @DisplayName("참여자와 결과이름의 길이가 다르면 예외 던짐")
    @Test
    void test_validateCount1() {
        assertThatExceptionOfType(NotMatchedCountException.class)
                .isThrownBy(() -> Matcher.Builder.of(participants)
                        .namesOfResult(NamesOfResult.of("꽝,5000,3000")));
    }

    @DisplayName("참여자와 결과테이블의 길이가 다르면 예외 던짐")
    @Test
    void test_validateCount2() {
        assertThatExceptionOfType(NotMatchedCountException.class)
                .isThrownBy(() -> Matcher.Builder.of(participants)
                        .namesOfResult(NamesOfResult.of("꽝,5000,2,3000"))
                        .matchedTable(Arrays.asList(1, 0, 3)));
    }

    private static Stream<Arguments> provideMatchedResult()
    {
        return Stream.of(
                Arguments.of("pobi", "5000"),
                Arguments.of("honux", "꽝"),
                Arguments.of("crong", "3000"),
                Arguments.of("jk", "꽝")
        );
    }

    @DisplayName("참여자의 이름으로 매칭된 결과이름 찾기")
    @ParameterizedTest
    @MethodSource("provideMatchedResult")
    void test_getResultByParticipant(String nameOfParticipant, String nameOfResult) {
        Matcher matcher = Matcher.Builder.of(participants)
                .namesOfResult(namesOfResult)
                .matchedTable(matchTable)
                .build();

        assertThat(matcher.getResultByParticipant(nameOfParticipant))
                .isEqualTo(nameOfResult);
    }

    @DisplayName("참여자와 결과의 모든 매칭 결과")
    @Test
    void test_getResults() {
        Matcher matcher = Matcher.Builder.of(participants)
                .namesOfResult(namesOfResult)
                .matchedTable(matchTable)
                .build();

        Map<String, String> expect = new HashMap<>();
        expect.put("pobi", "5000");
        expect.put("honux", "꽝");
        expect.put("crong", "3000");
        expect.put("jk", "꽝");

        assertThat(matcher.getResults())
                .isEqualTo(expect);
    }

}
