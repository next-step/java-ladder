package ladder;

import ladder.domain.LadderGame;
import ladder.view.DrawView;
import ladder.view.InputView;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputText = inputView.getParticipants();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = inputView.getLadderHeight();

        LadderGame ladderGame = new LadderGame(height, inputText);

        DrawView drawView = new DrawView();
        drawView.drawResult(ladderGame);
    }
}
