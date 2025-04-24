package nextstep;

import nextstep.domain.Ladder;
import nextstep.domain.Names;
import nextstep.view.InputView;
import nextstep.view.OutputView;

public class Main {
    public static void main(String[] args) {
        /* I/O 선언 */
        InputView in = new InputView();
        OutputView out = new OutputView();

        Names names = in.getName();
        List<String> bonus = in.getBonus(name.size());
        int height = in.getHeight();

        Ladder ladder = Ladder.of(names.size(), height);
        out.printResult(names, ladder, bonus);

    }
}
