package domain;

import org.junit.Before;
import org.junit.Test;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;


public class NameTagGroupTest {
    int height;
    List<NameTag> nameTags;

    @Before
    public void setUp() throws Exception {
        height = 1;
        nameTags = StringUtils.makeNameTag("faker,bang,wolf");
    }

    @Test
    public void 생성자테스트() {
        NameTagGroup.of(nameTags, height);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 중복체크() {
        List<NameTag> nameTags = new ArrayList<>();
        NameTag nameTag = NameTag.of("crox");
        nameTags.add(nameTag);
        nameTags.add(nameTag);
        NameTagGroup.of(nameTags, height);
    }

    @Test
    public void 배열사이즈() {
        NameTagGroup nameTagGroup = NameTagGroup.of(nameTags, height);
        assertThat(nameTagGroup.size()).isEqualTo(3);
    }


    @Test
    public void 결과값도출하기() {
        List<Point> points = new ArrayList<>();
        Point first = Point.first(FALSE);
        Point second = first.next(TRUE);
        Point third = second.next(FALSE);
        points.add(first);
        points.add(second);
        points.add(third);
        LadderLine ladderLine = LadderLine.ofList(points);
        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(ladderLine);
        Ladder ladder = Ladder.ofList(ladderLines);


        NameTagGroup nameTagGroup = NameTagGroup.ofLadder(nameTags, ladder);
        String name = "wolf";
        int index = nameTagGroup.indexOf(name);
        int lastIndex = nameTagGroup.getFinalPosition(index);

        assertThat(lastIndex).isEqualTo(height);


    }


    @Test
    public void ofDifficult() {
        Difficult difficult = Difficult.valueOf("상");
        NameTagGroup nameTagGroup =  NameTagGroup.ofDifficult(nameTags, difficult);
        assertThat(nameTagGroup.getLadderHeight()).isEqualTo(20);
    }
}