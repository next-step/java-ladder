package ladder.control;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;

public class LadderControllerTest {


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
        List<String> stringList = List.of(
                "pobi,honux,crong,jk",
                "꽝,5000,꽝,3000",
                "7",
                "pobi",
                "all",
                "q");
        consoleInput(
                stringList.stream()
                        .collect(Collectors.joining(System.lineSeparator()))
        );
        //when
        //then
        LadderController.main(new String[]{});
    }
}