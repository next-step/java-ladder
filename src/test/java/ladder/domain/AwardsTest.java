package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AwardsTest {

    private Awards awards;

    @BeforeEach
    public void init(){
        String[] awardNames = {"꽝", "5000", "1500"};
        awards = new Awards(awardNames);
    }

    @DisplayName("Awards 생성 테스트")
    @Test
    void awardsConstructorTest(){
        assertThat(awards.getAwards()).containsExactly(Award.from("꽝"), Award.from("5000"), Award.from("1500"));
    }

    @DisplayName("입력하지 않은 실행결과를 찾는 경우 Exception Test")
    @Test
    void searchWrongAwardExceptionTest(){

        assertThatIllegalArgumentException().isThrownBy(() -> {

            awards.searchAwardName(4);

        }).withMessageContaining("해당 위치에 결과값이 존재하지 않습니다.");
    }
}
