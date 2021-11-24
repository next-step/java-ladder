package nextstep.ladder.controller;

import nextstep.ladder.controller.view.InputView;
import nextstep.ladder.controller.view.OutputView;
import nextstep.ladder.domain.*;
import nextstep.ladder.utils.Parser;

import java.util.List;

public class LadderController {

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
        List<Name> names = createNames();
        OutputView.showNames(names);

        Ladder ladder = createLadder(names.size());
        OutputView.showLadder(ladder);
    }

    private static List<Name> createNames() {
        List<String> names = Parser.split(InputView.getName());
        return Name.listOf(names);
    }

    private static Ladder createLadder(int widthValue) {
        Positive width = new Positive(widthValue);
        Positive height = new Positive(InputView.getHeight());
        return Ladder.of(new LadderSize(width, height), new RandomPointRule());
    }

}
