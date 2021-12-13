package nextstep.ladder.model;

import nextstep.ladder.model.value.Participant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ParticipantsTest {

    private static Participants localParticipants;

    @BeforeEach
    void setUp() {
        String inputData = "lee,kim,park,joo";
        localParticipants = Participants.from(inputData);
    }

    @ParameterizedTest
    @DisplayName("참석자 이름 입력했을 때 생성하는 검증 로직")
    @CsvSource(value = {"lee,kim,oh:3", "lee,kim:2"}, delimiter = ':')
    void createTest(String inputData, int sizeResult) {
        Participants participants = Participants.from(inputData);

        assertThat(participants.size()).isEqualTo(sizeResult);
    }

    @Test
    @DisplayName("사다리 구조에 따라 기능이 잘 동작한다.")
    void executeTest() {
        Ladder ladder = Ladder.of(2, 4, drawLineRandom());

        // true, false, true
        /*  0     1      2     3
         *  |-----|      |-----|
         *  |-----|      |-----|
         */
        Participants participants = Participants.from("lee,park,kim,joo");
        Participants resultParticipants = participants.execute(ladder);

        List<Integer> resultPositions = resultParticipants.getParticipants().stream()
                .map(Participant::getPosition)
                .collect(Collectors.toList());

        assertThat(resultPositions).containsExactly(0, 1, 2, 3);
    }

    @Test
    @DisplayName("참가자 이름을 찾을때, 존재한다면, 정상적으로 반환된다.")
    void findNameTest() {
        AtomicInteger mockPosition = new AtomicInteger(0);
        String inputData = "lee,kim,park,joo";
        List<String> names = Arrays.asList(inputData.split(","));

        for (String name : names) {
            assertThat(localParticipants.findByName(name)).isEqualTo(
                    new Participant(name, mockPosition.getAndIncrement()));
        }
    }

    @Test
    @DisplayName("참가자 이름을 찾을때, 없는 이름이라면 예외가 발생한다.")
    void findNameExceptionTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> localParticipants.findByName("mock"));
    }

    private Random drawLineRandom() {
        return new Random() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        };
    }
}
