package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.floor.RandomFloorFactory;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.LadderPrinter;
import nextstep.ladder.ui.ResultView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {

        List<String> names = InputView.getNamesOfMembers();
        Members members = Members.of(names);

        List<String> titles = InputView.getTitlesOfResults();
        Results results = Results.of(titles);

        Height height = InputView.getHeight();

        Ladder ladder = new Ladder(members, results, height);
        ladder.generateFloorsWith(new RandomFloorFactory());

        System.out.println("실행결과");
        LadderPrinter.print(ladder);

        ResultView.printResult(ladder);
    }
}
