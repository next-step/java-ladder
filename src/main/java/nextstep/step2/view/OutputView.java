package nextstep.step2.view;

import nextstep.step2.domain.Lines;
import nextstep.step2.domain.Participants;

public class OutputView {

    private OutputView() {
    }

    public static void printResult(Participants participants, Lines lines) {
        System.out.println(System.lineSeparator() + "실행결과");

        System.out.println(participants.toParticipants());
        System.out.println(lines.drawLines());
    }

}
