package step2;

import step2.util.NoneConsecutiveSidelineGenerator;
import step2.util.RandomSidelineGenerator;
import step2.util.SidelineGenerator;
import step2.view.LadderInputView;
import step2.view.LadderOutputView;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        List<String> usernames = LadderInputView.getParsedStringsWithPrompt("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)", ",");

        Users users = new Users(usernames);

        List<String> resultValues = LadderInputView.getParsedStringsWithPrompt("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)", ",");

        Results results = new Results(resultValues);

        int ladderHeight = LadderInputView.getLadderHeightWithPrompt("최대 사다리 높이는 몇 개인가요?");

        SidelineGenerator randomSidelineGenerator = new RandomSidelineGenerator(usernames.size() - 1);
        SidelineGenerator noneConsecutiveSidelineGenerator = new NoneConsecutiveSidelineGenerator(randomSidelineGenerator);

        Ladder ladder = new Ladder(ladderHeight, noneConsecutiveSidelineGenerator);

        LadderOutputView.printLadderWithUsernames(users, ladder);
    }
}
