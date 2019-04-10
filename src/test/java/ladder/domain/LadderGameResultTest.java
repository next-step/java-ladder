package ladder.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultTest {

    @Test
    public void 실행결과_단건_출력하기() {
        LadderGameResult ladderGameResult = new LadderGameResult(Arrays.asList("먹기", "잠자기"));
        ladderGameResult.initPlayerResults(Arrays.asList(new PlayResult("A",0), new PlayResult("B",1)));
        String result = ladderGameResult.getPlayResults("B");
        assertThat(result).isEqualTo("잠자기");
    }

    @Test
    public void 실행결과_모두_출력하기() {
        LadderGameResult ladderGameResult = new LadderGameResult(Arrays.asList("먹기", "잠자기"));
        ladderGameResult.initPlayerResults(Arrays.asList(new PlayResult("A",0), new PlayResult("B",1)));
        String result = ladderGameResult.getPlayResults("all");
        assertThat(result).isEqualTo("A : 먹기 \n" + "B : 잠자기 \n" + "");
    }
}