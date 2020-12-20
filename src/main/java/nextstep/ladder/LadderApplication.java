package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.floor.RandomFloorFactory;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.LadderPrinter;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {

        List<String> names = InputView.getNamesOfMembers();
        Members members = Members.of(names);

        Height height = InputView.getHeight();

        Ladder ladder = new Ladder(members, height);
        ladder.generateFloorsWith(new RandomFloorFactory());

        System.out.println("실행결과");
        LadderPrinter.print(ladder);
    }
}
