package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.ladder.LadderGame;
import step3.domain.ladder.LadderPlayers;
import step3.exceptions.OutOfRangePlayerNameException;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JoinePersonTest {

    @DisplayName("입력한 사람이름만큼 참가자 생성")
    @ParameterizedTest
    @ValueSource(strings = {"catsb,pobi,crong,bibi,nabi"})
    void joinAndCreate(String input) {
        LadderPlayers players = LadderGame.join(input);
        assertThat(players.count()).isEqualTo(5);
    }

    @DisplayName("입력한 참가자 이름 길이 테스트")
    @Test
    void playerNameLengthOver5() {
        String name = "catsbi";
        assertThatThrownBy(()-> LadderGame.join(name))
                .isInstanceOf(OutOfRangePlayerNameException.class);
    }

    @DisplayName("입력한 참가자 이름이 없을 때")
    @ParameterizedTest
    @NullAndEmptySource
    void playerNameIsNullAndEmpty(String name) {
        assertThatThrownBy(()-> LadderGame.join(name))
                .isInstanceOf(NoSuchElementException.class);
    }
}
