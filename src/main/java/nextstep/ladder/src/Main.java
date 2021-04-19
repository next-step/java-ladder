package nextstep.ladder.src;

import nextstep.ladder.src.common.InputView;
import nextstep.ladder.src.common.ResultView;

public class Main {
  public static void main(String[] args) {
    Participants participants = Participants.makeByString(InputView.participants());
    Ladder ladder = Ladder.makeLadderBySize(InputView.height(), participants.numberOfParticipants() - 1);
    Ui ui = new Ui(participants.maxNameLength() < 3 ? 3 : participants.maxNameLength());

    System.out.println("실행결과");

    ResultView.users(participants, ui);
    ResultView.ladder(ladder, ui);
  }
}
