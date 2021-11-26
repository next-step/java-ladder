package nextstep.ladder.controller;

import nextstep.ladder.controller.view.InputView;
import nextstep.ladder.controller.view.OutputView;
import nextstep.ladder.domain.*;
import nextstep.ladder.utils.Parser;

import java.util.List;

public class LadderController {

    private static final int DIFFERENCE_BETWEEN_NAMES_SIZE_AND_WIDTH = 1;

    private LadderController() {
    }

    public static void main(String[] args) {
        try {
            start();
        } catch (IllegalArgumentException e) {
            System.out.println("\n잘못된 입력입니다: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n잠시후 다시 이용하세요");
        }
    }

    private static void start() {
        List<Participant> participants = createParticipants();
        Ladder ladder = createLadder(participants.size() - DIFFERENCE_BETWEEN_NAMES_SIZE_AND_WIDTH);

        OutputView.showNames(participants);
        OutputView.showLadder(ladder);
    }

    private static List<Participant> createParticipants() {
        List<String> names = Parser.split(InputView.getName());
        return Participant.listOf(names);
    }

    private static Ladder createLadder(int widthValue) {
        Positive width = new Positive(widthValue);
        Positive height = new Positive(InputView.getHeight());
        return Ladder.of(new LadderSize(width, height), new RandomPointRule());
    }

}
