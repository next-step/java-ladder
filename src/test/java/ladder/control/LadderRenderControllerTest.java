package ladder.control;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class LadderRenderControllerTest {


    @AfterEach
    public void afterEach() {
        System.setIn(System.in);
    }

    private void consoleInput(String inputString) {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
    }

    @DisplayName("실행 테스트를 자동화한다")
    @Test
    public void ladderAppRunner() {
        //given
        consoleInput(
                "pobi,honux,crong,jk" + System.lineSeparator() +
                        "7" + System.lineSeparator()
        );
        //when
        //then
        LadderController.main(new String[]{});
    }
}