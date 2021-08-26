package step3;

import step3.factory.FixedHeightLadderFactory;
import step3.factory.NamedUsersFactory;
import step3.factory.StringResultsFactory;
import step3.util.NoneConsecutiveSidelineGenerator;
import step3.util.RandomSidelineGenerator;
import step3.util.SidelineGenerator;
import step3.view.LadderInputView;
import step3.view.LadderOutputView;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        // 기본정보 입력
        List<String> usernames = LadderInputView.getParsedStringsWithPrompt("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)", ",");
        Users users = new NamedUsersFactory(usernames).createUsers();

        List<String> resultValues = LadderInputView.getParsedStringsWithPrompt("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)", ",");
        Results results = new StringResultsFactory(resultValues).createResults();

        int ladderHeight = LadderInputView.getLadderHeightWithPrompt("최대 사다리 높이는 몇 개인가요?");

        // 사다리 생성
        SidelineGenerator randomSidelineGenerator = new RandomSidelineGenerator(usernames.size() - 1);
        SidelineGenerator noneConsecutiveSidelineGenerator = new NoneConsecutiveSidelineGenerator(randomSidelineGenerator);

        Ladder ladder = new FixedHeightLadderFactory(ladderHeight, noneConsecutiveSidelineGenerator).createLadder();

        // 사다리 출력
        LadderOutputView.printLadderWithUsernamesAndResults(users, ladder, results);

        // 결과 목표 입력
        String username = LadderInputView.getUsernameWithPrompt("결과를 보고 싶은 사람은?");

        // 사다리 실행
        List<User> targetUsers = users.findUsersByUsername(username);
        List<Position> finalPositions = ladder.startLadder(targetUsers);
        List<Result> ladderResults = results.findResultsByPositions(finalPositions);

        // 결과 출력
        LadderOutputView.printLadderResults(targetUsers, ladderResults);
    }
}
