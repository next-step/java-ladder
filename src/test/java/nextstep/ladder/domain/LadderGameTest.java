package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    void success() {
        Brace firstLine_brace1 = new Brace(false, true);
        Brace firstLine_brace2 = new Brace(true, false);
        Brace firstLine_brace3 = new Brace(false, false);
        Brace firstLine_brace4 = new Brace(false, false);
        RealLine firstLine = new RealLine(List.of(firstLine_brace1, firstLine_brace2, firstLine_brace3, firstLine_brace4));

        Brace secondLine_brace1 = new Brace(false, true);
        Brace secondLine_brace2 = new Brace(true, false);
        Brace secondLine_brace3 = new Brace(false, false);
        Brace secondLine_brace4 = new Brace(false, false);
        RealLine secondLine = new RealLine(List.of(secondLine_brace1, secondLine_brace2, secondLine_brace3, secondLine_brace4));

        Brace thirdLine_brace1 = new Brace(false, false);
        Brace thirdLine_brace2 = new Brace(false, true);
        Brace thirdLine_brace3 = new Brace(true, false);
        Brace thirdLine_brace4 = new Brace(false, false);
        RealLine thirdLine = new RealLine(List.of(thirdLine_brace1, thirdLine_brace2, thirdLine_brace3, thirdLine_brace4));

        Brace fourthLine_brace1 = new Brace(false, true);
        Brace fourthLine_brace2 = new Brace(true, false);
        Brace fourthLine_brace3 = new Brace(false, false);
        Brace fourthLine_brace4 = new Brace(false, false);
        RealLine fourthLine = new RealLine(List.of(fourthLine_brace1, fourthLine_brace2, fourthLine_brace3, fourthLine_brace4));

        Players players = new Players("a,b,c,d");
        Amounts amounts = new Amounts("1,2,3,4");
        RealLadder ladder = new RealLadder(List.of(firstLine, secondLine, thirdLine, fourthLine));
        LadderGameResult ladderGameResult = new LadderGameResult();
        int index1 = ladder.move(0);
        int index2 = ladder.move(1);
        int index3 = ladder.move(2);
        int index4 = ladder.move(3);
        assertThat(index1).isEqualTo(1);
        assertThat(index2).isEqualTo(2);
        assertThat(index3).isEqualTo(0);
        assertThat(index4).isEqualTo(3);
    }
}
