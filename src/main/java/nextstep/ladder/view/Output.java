package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

import java.util.List;

public class Output {

    private static final String UNLINK = "    |";
    private static final String LINK = "----|";

    public void personName(List<String> persons) {
        print("실행 결과");
        System.out.println();
        for (String person : persons) {
            print(person + " ");
        }
        System.out.println();
    }

    public void result(Ladder ladder) {
        for (Line line : ladder.getLadder()) {
            for (Boolean isLink : line.getList()) {
                if (isLink)
                    print(LINK);
                else
                    print(UNLINK);
            }
            System.out.println();
        }
    }

    private void print(String word) {
        System.out.print(word);
    }
}
