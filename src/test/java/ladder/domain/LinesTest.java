package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

public class LinesTest {

    @DisplayName("사다리 전체(Lines) 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:4", "2:5", "5:10"})
    void Lines_of(int participantCount, int ladderHeight) {
        Lines lines = Lines.of(ladderHeight, new LineRandomGenerator(participantCount));

        lines.stream()
                .map(Line::getConnection)
                .map(this::makeStringForView)
                .forEach(System.out::println);
    }

    private String makeStringForView(List<Boolean> connection) {
        String result = connection.stream()
                .map(bol -> bol ? "-----" : "     ")
                .map(line -> "|" + line)
                .collect(Collectors.joining());
        return result + "|";
    }
}
