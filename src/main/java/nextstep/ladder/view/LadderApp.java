package nextstep.ladder.view;

import nextstep.ladder.Ladder;
import nextstep.ladder.LadderInput;
import nextstep.ladder.Result;
import nextstep.ladder.participant.Participants;
import nextstep.ladder.RandomMiddleLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LadderApp {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {

        String[] names = InputView.inputName(scanner);
        int depth = InputView.makeDepth(scanner);
        Participants participants = Participants.of(names);
        LadderInput input = new LadderInput(participants, depth);

        input.setRandomPoint(new RandomMiddleLadder());

        Ladder ladder = Ladder.of(input);
        List<Result> result = InputView.inputResult(scanner);

        OutputView.showResult(ladder, result);
        ladder.playLadderGame();

        scanner.nextLine();
        ResultMap map = new ResultMap(ladder.getParticipants(),result);
        while(true){
            String name = InputView.getName(scanner);
            if("all".equals(name)){
                OutputView.showAll(map);
                break;
            }
            System.out.println(map.findResult(name));
        }
    }

}
