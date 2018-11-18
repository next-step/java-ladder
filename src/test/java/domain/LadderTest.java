package domain;


import org.junit.Test;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {

    @Test
    public void 최종위치테스트() {
        List<Line> lines = new ArrayList<>();
        List<Boolean> booleanList = Arrays.asList(true);//|-----|
        lines.add(Line.ofGroup(booleanList));

        Ladder ladder = new Ladder(lines);
        int startPosition = 1;
        assertThat(0).isEqualTo(ladder.getFinalPosition(startPosition));
    }

    //Ladder ladder = Ladder.ofCount(ladderHeight, players.size());

    @Test
    public void 다른생성자로구현() {
        List<Line> lines = new ArrayList<>();
        List<Boolean> booleanList = Arrays.asList(true,false,true,false);//|-----|
        lines.add(Line.ofGroup(booleanList));

        String names = "stron,box,test,kkk,sdfa";
        List<Player> players = StringUtils.joinPlayer(StringUtils.splitDelemeter(names));

        Ladder ladder = Ladder.ofList(lines, players);
        int startPosition = 4;
        assertThat(4).isEqualTo(ladder.getFinalPosition(startPosition));

    }
}