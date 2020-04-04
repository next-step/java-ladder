package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @DisplayName("사다리 정상 생성")
    @Test
    void createLadder() {
        int heightOfLine = 10;
        List<String> personNames = Arrays.asList("dong", "chul", "lee");
        List<Person> people = personNames.stream()
                .map(Person::new)
                .collect(Collectors.toList());
        Ladder ladder = Ladder.of(people, heightOfLine);

        assertThat(ladder.getHeightOfLadder()).isEqualTo(heightOfLine);
    }
}
