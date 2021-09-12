package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Ladders;
import nextstep.ladder.model.Name;
import nextstep.ladder.model.Names;

public class OutputView {
    public static void printNames(Names names) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Name name : names) {
            stringBuilder.append(name.toString());
            for (int i = 0; i < 6 - name.length(); i++) {
                stringBuilder.append(" ");
            }
        }
        System.out.println(stringBuilder);
    }

    public static void printLadders(Ladders ladders) {
        for (int height = 0; height < ladders.height(); height++) {
            for (Ladder ladder : ladders) {
                System.out.print(ladder.hasStep(height) ? "|-----" : "|     ");
            }
            System.out.println("|");
        }
    }
}
