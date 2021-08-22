package nextstep.ladders.domain;

import com.sun.tools.javac.util.List;
import nextstep.ladders.domain.exceptions.HorizontalLinesOverlapException;
import nextstep.ladders.domain.exceptions.NotFoundDataException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class LadderTest {

    private static final PointGenerateStrategy strategy = (previous -> true);

    @ParameterizedTest
    @CsvSource(value = {"pobi,honux,crong,jk:꽝,5000,꽝,3000:", "pobi,honux,crong,jk:꽝,5000,꽝,3000:sff"}, delimiter = ':')
    void 사다리_높이가_숫자가_아니면_에러(final String participantsText, final String executionResultText, final String maxLadderHeightText) {
        assertThrows(NumberFormatException.class, () -> new Ladder(strategy, participantsText, executionResultText, maxLadderHeightText));
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,honux,crong,jk:꽝,5000,꽝,3000:5", "pobi,honux,crong,jk:꽝,5000,꽝,3000:2", "pobi,honux,crong,jk:꽝,5000,꽝,3000:7"}, delimiter = ':')
    void 사다리_라인으로_생성(final String participantsText, final String executionResultText, final String maxLadderHeightText) {
        assertDoesNotThrow(() -> new Ladder(strategy, participantsText, executionResultText, maxLadderHeightText));
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi:꽝", "honux:3000", "crong:꽝", "jk:5000"}, delimiter = ':')
    void 사다리_결과_확인(final String name, final String result) {
        // given
        Lines lines = getLines();
        Ladder ladder = new Ladder(new LadderDetail("pobi,honux,crong,jk", "꽝,5000,꽝,3000"), lines);

        // when
        ExecutionResult executionResult = ladder.start(Participant.valueOf(name));

        //then
        assertEquals(ExecutionResult.valueOf(result), executionResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"aa", "bb", "cccc"}, delimiter = ':')
    void 사다리_참가자가_존재하지_않을때_에러(final String name) {
        Lines lines = getLines();
        Assertions.assertThrows(NotFoundDataException.class, () -> {
            Ladder ladder = new Ladder(new LadderDetail("pobi,honux,crong,jk", "꽝,5000,꽝,3000"), lines);
            ladder.start(Participant.valueOf(name));
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"honux"}, delimiter = ':')
    void 사다리가_선이_이어져_있는경우_에러(final String name) {
        Lines lines = new Lines(List.of(new Line(List.of(false, true, true, false))));
        Assertions.assertThrows(HorizontalLinesOverlapException.class, () -> {
            Ladder ladder = new Ladder(new LadderDetail("pobi,honux,crong,jk", "꽝,5000,꽝,3000"), lines);
            ladder.start(Participant.valueOf(name));
        });
    }

    private Lines getLines() {
        /**
         *     |-----|     |-----|
         *     |     |-----|     |
         *     |-----|     |     |
         *     |     |-----|     |
         *     |-----|     |-----|
         */
        return new Lines(List.of(
                new Line(List.of(false, true, false, true)),
                new Line(List.of(false, false, true, false)),
                new Line(List.of(false, true, false, false)),
                new Line(List.of(false, false, true, false)),
                new Line(List.of(false, true, false, true))
        ));
    }
}