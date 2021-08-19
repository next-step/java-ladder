package nextstep.ladders.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class LadderTest {

    @ParameterizedTest
    @CsvSource(value = "pobi,honux,crong,jk:5", delimiter = ':')
    void 사다리_생성(final String participantsText, final int height) {
        assertDoesNotThrow(() -> {
            List<String> names = getNames(participantsText);
            Lines lines = new Lines(names.size(), height);
            Ladder ladder = new Ladder(lines);
        });
    }

    private List<String> getNames(String participantsText) {
        return Arrays.stream(participantsText.split(","))
                .collect(Collectors.toList());
    }
}