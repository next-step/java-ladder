package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.lang.reflect.Field;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantTest {

    @Test
    @DisplayName("참석자의 이름이 정상적으로 생성된다.")
    void createTest() throws NoSuchFieldException, IllegalAccessException {
        Participant participant = new Participant("koi", 0);

        String nameByReflection = getNameByReflection(participant);

        assertThat(nameByReflection).isEqualTo("koi");
    }

    @Test
    @DisplayName("참석자의 이름이 5자가 넘어가면, RuntimeException 이 발생한다.")
    void createExceptionTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participant("kiyeon_kim1", 0));
    }

    @Test
    @DisplayName("사용자의 사다리타기가 잘 동작하는지 확인한다.")
    void climbTest() {
        String name = "koi";
        Participant participant = new Participant(name, 0);
        Participant afterClimbParticipant = participant.climb(
            Ladder.create(PositiveNumber.create(2), 3, drawLineRandomMock()));

        /*
         *  0     1      2
         *  |-----|      |
         *  |-----|      |
         */

        assertThat(afterClimbParticipant).isEqualTo(new Participant(name, 0));
    }

    private String getNameByReflection(Participant participant)
        throws NoSuchFieldException, IllegalAccessException {
        Field nameField = Participant.class.getDeclaredField("name");
        nameField.setAccessible(true);
        return (String) nameField.get(participant);
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
