package JavaLadder.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ResultsTest {
    String name = "test1,test2";
    String prize = "prize1,prize2";

    @Test
    @DisplayName("전체사용자결과")
    public void allUserResultsTest() {
        GameInformation gameInformation = new GameInformation(name, prize);
        Results results = new Results(gameInformation, "all");
        assertThat(results.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("특정사용자결과테스트")
    public void anyUserResultsTest() {
        GameInformation gameInformation = new GameInformation(name, prize);
        Results results = new Results(gameInformation, "test1");
        assertThat(results.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("사용자없을경우결과테스트")
    public void noUserResultsTest() {
        GameInformation gameInformation = new GameInformation(name, prize);
        assertThatThrownBy(() -> {
            Results results = new Results(gameInformation, "test3");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("사용자에 없는 이름입니다.[test3]");
    }
}
