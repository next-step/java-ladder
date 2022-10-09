package ladder;

import ladder.model.HorizontalLine;
import ladder.model.Users;
import ladder.service.LineGenerator;
import ladder.service.RandomLineGenerator;
import ladder.ui.InputView;
import ladder.ui.OutputView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LadderApp {

    private static final Logger LOGGER = Logger.getLogger(LadderApp.class.getName());
    private static final LineGenerator generator = getLineGenerator();

    public static void main(String[] args) {
        try (InputView inputView = getInputView()) {
            Users users = Users.createUsersWithName(inputView.getUser());
            Integer lineLength = inputView.getVerticalLine();

            List<HorizontalLine> horizontalLines = generator.generate(users.size(), lineLength);
            users.addLine(horizontalLines);

            OutputView.printLadder(users, lineLength);
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
        return new RandomLineGenerator();
    }
}
