package ladder.domain;

import ladder.exception.InvalidParticipantsCountException;
import ladder.helper.Fixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderFloorTest {
    @DisplayName("사다리의 한 Floor은 참가자 수를 입력 받아 생성된다.")
    @Test
    void create() {
        assertThat(new LadderFloor(5, AutoLineGenerator.create())).isNotNull();
    }

    @DisplayName("입력된 참가자 수는 1이상이 되지 못하면 Exception 발생한다.")
    @ParameterizedTest(name = "{arguments} {displayName}")
    @ValueSource(ints = {0})
    void validate(int countOfParticipants) {
        assertThatThrownBy(() -> new LadderFloor(countOfParticipants, AutoLineGenerator.create())).isInstanceOf(InvalidParticipantsCountException.class);
    }

    @DisplayName("주입된 전략 인스턴스에 따라 LadderFloor가 생성된다.")
    @Test
    void generateLines() {
        int countOfParticipants = 10;
        LadderFloor ladderFloor = new LadderFloor(countOfParticipants, (n) -> Fixture.generatedLines());

        assertThat(ladderFloor.getLines()).isEqualTo(Fixture.generatedLines());
    }
}

