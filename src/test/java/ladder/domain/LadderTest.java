package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

public class LadderTest {

    @DisplayName("사다리 전체(Lines) 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:4", "2:5", "5:10"}, delimiter = ':')
    void Lines_of(int participantCount, int ladderHeight) {
        Ladder ladder = Ladder.of(ladderHeight, new LineRandomGenerator(participantCount));

        ladder.getLines()
                .stream()
                .map(Line::getConnection)
                .map(this::makeStringForView)
                .forEach(System.out::println);

        System.out.println();
    }

    private String makeStringForView(List<Boolean> connection) {
        return connection.stream()
                .map(bol -> bol ? "-----" : "     ")
                .map(line -> "|" + line)
                .collect(Collectors.joining());
    }
}
