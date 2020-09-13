package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.util.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private LadderResult ladderResult;
    public ResultView(LadderResult ladderResult) {
        this.ladderResult = ladderResult;
    }

    public void reuslt() {
        PrintResult.printNames(ladderResult.getLadderGame().getPeople());
        PrintResult.makeLadder(ladderResult.getLadderGame().getLadder());
        PrintResult.printResults(ladderResult.getGameReult());
        boolean flag = true;
        while (flag) {
            String personResult = InputUtil.returnString("결과를 보고 싶은 사람은?");
            flag = getResult(personResult);
        }
    }

    private boolean getResult(String personResult) {
        if ("all".equals(personResult)) {
            getAllResult();
            return false;
        }
        PrintResult.printResult(ladderResult.getPersonResult(personResult));
        return true;
    }

    private void getAllResult() {
        List<String> result = new ArrayList<>();
        for(int i = 0, length = ladderResult.getLadderGame().getPeople().size(); i < length ; i ++)
        {
            result.add(ladderResult.getPersonResult(ladderResult.getLadderGame().getPeople().get(i).getName()));
        }
        PrintResult.printAllResult(ladderResult.getLadderGame().getPeople(), result);
    }

}
