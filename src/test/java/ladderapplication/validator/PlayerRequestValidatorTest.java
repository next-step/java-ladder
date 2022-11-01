package ladderapplication.validator;

import ladderapplication.models.requests.PlayerRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerRequestValidatorTest {

    private static final String WRONG_NAME = "플레이어 이름음 5글자 이하 여야 합니다.";
    private static final List<PlayerRequest> playerRequests = new ArrayList<>();

    @BeforeAll
    public static void setPlayerRequest() {
        String players = "pobi,honux,crong,jk";
        String[] playerArr = players.split(",");
        Stream.of(playerArr).forEach(name -> playerRequests.add(PlayerRequest.of(name)));
    }

    @Test
    @DisplayName("입력받은 사용자 이름이 5글자가 넘으면 Exception이 발생한다.")
    void test1() {
        PlayerRequest playerRequest = PlayerRequest.of("robinson");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> PlayerRequestValidator.validation(playerRequest));
        assertThat(exception.getMessage()).isEqualTo(WRONG_NAME);

    }
}
