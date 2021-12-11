package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    private Participants participants;

    @BeforeEach
    void init() {
        participants = Participants.create("pobi,kiyy,koi,kk");
    }

    @Test
    @DisplayName("참석자는 `,` 을 기준으로 split하여, 생성되어야 한다.")
    void createTest() throws NoSuchFieldException, IllegalAccessException {
        String input = "pobi,kiyy,koi,kk";

        List<Participant> participantList = getParticipantsByReflection(participants);

        AtomicInteger position = new AtomicInteger(0);
        List<Participant> expected = Arrays.stream(input.split(","))
            .map(name -> new Participant(name, position.getAndIncrement()))
            .collect(Collectors.toList());

        assertThat(participantList).isEqualTo(expected);
    }

    @Test
    @DisplayName("일급콜렉션 객체의 List는 외부에서는 불변 리스트 이다.")
    void getParticipantsUnmodifiableCollectionTest() {
        List<Participant> participantsList = participants.getParticipants();

        assertThatExceptionOfType(UnsupportedOperationException.class)
            .isThrownBy(() -> participantsList.add(new Participant("user5", 0)));
    }

    @Test
    @DisplayName("사다리 구조에 따라 기능이 잘 동작한다.")
    void executeTest() {
        Ladder ladder = Ladder.create(PositiveNumber.create(2), 4, drawLineRandomMock());

        // true, false, true
        /*  0     1      2     3
         *  |-----|      |-----|
         *  |-----|      |-----|
         */

        Participants resultParticipants = participants.execute(ladder);

        List<Integer> resultPositions = resultParticipants.getParticipants().stream()
            .map(Participant::getPosition)
            .collect(Collectors.toList());

        assertThat(resultPositions).containsExactly(0, 1, 2, 3);

    }

    @SuppressWarnings("unchecked")
    private List<Participant> getParticipantsByReflection(Participants participants)
        throws NoSuchFieldException, IllegalAccessException {
        Field participantsField = Participants.class.getDeclaredField("participants");
        participantsField.setAccessible(true);
        return (List<Participant>) participantsField.get(participants);
    }

    private Random drawLineRandomMock() {
        return new Random() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        };
    }


}