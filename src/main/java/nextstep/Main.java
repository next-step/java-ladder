package nextstep;

import java.util.List;

import nextstep.domain.Ladder;
import nextstep.view.InputView;
import nextstep.view.OutputView;

public class Main {
    public static void main(String[] args) {
        /* I/O 선언 */
        InputView in = new InputView();
        OutputView out = new OutputView();

        List<String> name = in.getName();
        List<String> bonus = in.getBonus(name.size());
        int height = in.getHeight();

        Ladder ladder = Ladder.of(name.size(), height);
        out.printResult(name, ladder, bonus);

    }
}
