package domain;

import org.junit.Test;
import util.StringUtil;
import view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputTagGroupTest {
    @Test
    public void 중복() {
        String names = "pobi,honux,pobi,jk";
        List<NameTag> nameTagGroup = StringUtil.makeNameTags(names);
        ResultTagGroup resultTagGroups = ResultTagGroup.of(nameTagGroup);
    }


    @Test
    public void 실행및결과보고싶은사람() {
        String names = "pobi,honux,crong,jk";
        List<NameTag> nameTagGroup = StringUtil.makeNameTags(names);
        String results = "꽝,5000,꽝,3000";
        List<NameTag> resultTagGroup = StringUtil.makeNameTags(results);

        List<Boolean> booleanList = Arrays.asList(true, false, true);
        Line lines = Line.of(booleanList);
        List<Line> lineList = new ArrayList<>();
        lineList.add(lines);
        Ladder ladder = Ladder.of(lineList);
        InputTagGroup nameTagGroups = InputTagGroup.of(nameTagGroup, ladder);
        ResultTagGroup resultTagGroups = ResultTagGroup.of(resultTagGroup);
        ResultView.printNameTags(nameTagGroups);
        ResultView.printLadder(ladder);
        ResultView.printResultNameTags(resultTagGroups);
//        실행결과
        nameTagGroups.getAllFinalResult(resultTagGroups).forEach(System.out::println);



    }
}