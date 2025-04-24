package nextstep;

import java.util.List;

import nextstep.domain.Bonus;
import nextstep.domain.Ladder;
import nextstep.domain.LadderResult;
import nextstep.domain.Name;
import nextstep.domain.Names;
import nextstep.view.InputView;
import nextstep.view.OutputView;

public class Main {
    public static void main(String[] args) {
        /* I/O 선언 */
        InputView in = new InputView();
        OutputView out = new OutputView();

        Names names = in.getName();
        List<Bonus> bonus = in.getBonus(names.size());
        int height = in.getHeight();

        Ladder ladder = Ladder.of(names.size(), height);
        LadderResult result = new LadderResult(ladder);

        out.printLadder(names, ladder, bonus);
        while (true) {
            String target = in.readTarget().trim();
            boolean isAll = "all".equals(target);
            if (isAll) {
                out.printAllResults(names, result, bonus);
                break;
            }
            Name n = Name.of(target);
            int idx = names.unmodifiableNames().indexOf(n);
            if (idx < 0) {
                out.printPersonalResult(-1, result, bonus);
                continue;
            }
            out.printPersonalResult(idx, result, bonus);
        }
    }
}
