package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbResultsTest {

    private ClimbResults climbResults;

    @BeforeEach
    public void init(){
        List<ClimbResult> climbResultList = new ArrayList<>();
        climbResultList.add(ClimbResult.of(Player.from("pobi"), Award.from("100")));
        climbResultList.add(ClimbResult.of(Player.from("honux"), Award.from("fail")));
        climbResultList.add(ClimbResult.of(Player.from("crong"), Award.from("200")));
        climbResultList.add(ClimbResult.of(Player.from("jk"), Award.from("300")));
        climbResults = new ClimbResults(climbResultList);
    }

    @DisplayName("ClimbResults 생성 테스트")
    @Test
    void climbResultsConstructorTest(){
        assertThat(climbResults.getClimbResults()).containsExactly(ClimbResult.of(Player.from("pobi"), Award.from("100")),
                ClimbResult.of(Player.from("honux"), Award.from("fail")),
                ClimbResult.of(Player.from("crong"), Award.from("200")),
                ClimbResult.of(Player.from("jk"), Award.from("300")));
    }

    @DisplayName("플레이어 이름으로 결과값을 찾는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"pobi:100", "honux:fail", "crong:200", "jk:300"}, delimiter = ':')
    void matchAwardByPlayerNameTest(String playerName, String expectAward){
        String result = climbResults.matchAwardByPlayerName(playerName);
        assertEquals(expectAward, result);
    }

    @DisplayName("존재하지 않는 플레이어 이름으로 결과값을 찾는 경우 Exception 테스트")
    @Test
    void throw_exception_not_exists_player(){
        assertThatThrownBy(() ->{
            climbResults.matchAwardByPlayerName("mimimjin");
        }).isInstanceOf(RuntimeException.class);
    }


}
