package ladder;

import ladder.domain.Ladder;
import ladder.dto.Gamer;
import ladder.view.LadderInputView;
import ladder.view.LadderOutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
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
            List<Gamer> gamers = new ArrayList<>();
            names.stream()
                    .map(Gamer::new)
                    .collect(Collectors.toList());

            //참여자 이름중 가장 긴 이름 확인
            List<Gamer> sortedGamers = new ArrayList<>(gamers);
            sortedGamers.sort(Collections.reverseOrder());
            int maxNameLength = sortedGamers.get(0).getNameLength();

            //높이 input
            int height = LadderInputView.inputHeight();

            //사다리생성 및 겹치는 라인 확인
            Ladder ladder = new Ladder(height, gamers.size());
            ladder.checkLadder();

            //output result
            LadderOutputView.printGamers(gamers, maxNameLength);
            LadderOutputView.printLadder(ladder, maxNameLength, height);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
