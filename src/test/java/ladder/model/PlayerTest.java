package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
public class PlayerTest {

    @Test
    void 사람이름_5글자_초과시_오류발생(){
        assertThatIllegalArgumentException()
                .isThrownBy(
                        ()-> new Player("player1")
                ).withMessageContaining("이름은 최대 5글자입니다.");
    }


}
