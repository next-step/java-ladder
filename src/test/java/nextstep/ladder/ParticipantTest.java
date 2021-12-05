package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.lang.reflect.Field;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantTest {

    @Test
    @DisplayName("참석자의 이름이 정상적으로 생성된다.")
    void create() throws NoSuchFieldException, IllegalAccessException {
        Participant participant = new Participant("koi");

        String nameByReflection = getNameByReflection(participant);

        assertThat(nameByReflection).isEqualTo("koi");
    }

    @Test
    @DisplayName("참석자의 이름이 5자가 넘어가면, RuntimeException 이 발생한다.")
    void createExceptionTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participant("kiyeon_kim1"));
    }

    private String getNameByReflection(Participant participant)
        throws NoSuchFieldException, IllegalAccessException {
        Field nameField = Participant.class.getDeclaredField("name");
        nameField.setAccessible(true);
        return (String) nameField.get(participant);
    }

}
