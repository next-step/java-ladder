package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-27 00:44
 */
public class LadderLineTest {

    @Test
    void init_test() {
        LadderLine ladderLine = LadderLine.init(5);
        System.out.println(ladderLine.toString());
    }
}
