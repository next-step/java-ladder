package ladder;

import ladder.domain.Ladder;
import ladder.dto.Gamer;
import ladder.dto.LadderGenerator;
import ladder.dto.Reward;
import ladder.view.LadderInputView;
import ladder.view.LadderOutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static final String SHOW_ALL_KEYWORD = "all";

    public static void main(String[] args) {
        doLadderGame();
    }

    private static void doLadderGame() {
        try {
            //참여자 input
            String inputName = LadderInputView.inputName();

            //input 값 validation 체크 및 split
            List<String> names = LadderInputView.splitInputName(inputName);

            //게이머 생성
            List<Gamer> gamers = names.stream()
                    .map(Gamer::new)
                    .collect(Collectors.toList());

            //참여자 이름중 가장 긴 이름 확인
            List<Gamer> sortedGamers = new ArrayList<>(gamers);
            sortedGamers.sort(Collections.reverseOrder());
            int maxNameLength = sortedGamers.get(0).getNameLength();

            //결과 input
            String inputResult = LadderInputView.inputResult();

            //input 값 validation 체크 및 split
            List<String> results = LadderInputView.splitInputResult(inputResult, gamers.size());

            //보상생성
            List<Reward> rewards = results.stream()
                    .map(Reward::new)
                    .collect(Collectors.toList());

            //높이 input
            int height = LadderInputView.inputHeight();

            //사다리생성 및 겹치는 라인 확인
            Ladder ladder = LadderGenerator.createLadde(height, gamers.size(), gamers, rewards);
            ladder.checkLadder();

            //output ladder
            LadderOutputView.printGamers(gamers, maxNameLength);
            LadderOutputView.printLadder(ladder, maxNameLength, height);
            LadderOutputView.printResults(rewards, maxNameLength);

            //게이머-보상 매칭
            ladder.matchingReward();

            //show game result
            String gamerName;
            while (true) {
                gamerName = LadderInputView.inputGamer();

                if (gamerName.equals(SHOW_ALL_KEYWORD)) {
                    LadderOutputView.printAllReward(gamers);
                    break;
                }

                Gamer gamer = ladder.containGamer(gamerName);
                LadderOutputView.printReward(gamer);
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
