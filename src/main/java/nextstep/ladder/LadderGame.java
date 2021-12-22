package nextstep.ladder;

import nextstep.ladder.factory.LinesFactory;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Lines;
import nextstep.ladder.model.Players;
import nextstep.ladder.model.Results;
import nextstep.ladder.utils.StringUtils;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    private static final String DELIMITER = ",";

    private LadderGame() {
    }

    public static void main(String[] args) {
        String inputNames = InputView.nextLine("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] splitNames = StringUtils.validationNotNullAndEmpty(inputNames).split(DELIMITER);
        Players players = new Players(splitNames);
        int width = splitNames.length;

        String inputResults = InputView.nextLine("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] splitResults = StringUtils.validationNotNullAndEmpty(inputResults).split(DELIMITER);
        Results results = new Results(splitResults, width);


        int height = InputView.nextInt("최대 사다리 높이는 몇 개인가요?");
        Lines lines = LinesFactory.of(width, height);


        Ladder ladder = new Ladder(players, lines, results);

        OutputView.print(ladder);
    }
}
