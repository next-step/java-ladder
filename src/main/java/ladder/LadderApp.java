package ladder;

import ladder.domain.*;
import ladder.domain.LineGenerator;
import ladder.domain.RandomLineGenerator;
import ladder.domain.VerticalMapper;
import ladder.ui.InputView;
import ladder.ui.OutputView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LadderApp {

    private static final Logger LOGGER = Logger.getLogger(LadderApp.class.getName());
    private static final LineGenerator generator = getLineGenerator();

    public static void main(String[] args) {
        try (InputView inputView = getInputView()) {
            Users users = Users.createUsersWithName(inputView.getUser());
            LadderResult ladderResult = new LadderResult(inputView.getResult(), users.size());
            LadderLength ladderLength = new LadderLength(inputView.getVerticalLine());

            List<HorizontalLine> horizontalLines = generator.generate(users.size(), ladderLength);

            Ladder ladder = new Ladder(VerticalMapper.map(horizontalLines, users.size()), ladderLength);
            OutputView.printLadder(users, ladder, ladderResult);

            while (true) {
                UserName userName = new UserName(inputView.getUserForResult());
                OutputView.printResult(userName, users, ladderResult.result(ladder.play(users.findStartPositionByUsername(userName))));
            }
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, "유효하지 않은 입력값입니다.", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static InputView getInputView() {
        return new InputView(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static LineGenerator getLineGenerator() {
        Random random = new Random();
        return new RandomLineGenerator(random::nextBoolean);
    }
}
