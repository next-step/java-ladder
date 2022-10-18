package ladder;

import ladder.domain.*;
import ladder.dto.ResultDto;
import ladder.factory.UserNameFactory;
import ladder.service.LadderService;
import ladder.ui.InputView;
import ladder.ui.OutputView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LadderApp {

    private static final Logger LOGGER = Logger.getLogger(LadderApp.class.getName());

    private static final LadderService ladderService = new LadderService();

    public static void main(String[] args) {
        try (InputView inputView = getInputView()) {
            Users users = Users.createUsersWithName(inputView.getUser());
            LadderResult ladderResult = new LadderResult(inputView.getResult(), users.size());
            LadderLength ladderLength = new LadderLength(inputView.getVerticalLine());

            Ladder ladder = ladderService.getLadder(users.size(), ladderLength);

            OutputView.printLadder(users, ladder, ladderResult);

            while (true) {
                List<UserName> userNames = UserNameFactory.getUserName(users, inputView.getUserForResult());
                List<User> foundUsers = users.findUserByUsernames(userNames);

                ResultDto resultDto = ladderService.getResultOfUser(ladder, foundUsers, ladderResult);
                OutputView.printResult(resultDto);
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


}
