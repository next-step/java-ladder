package ladder;

import ladder.domain.*;
import ladder.dto.UserResult;
import ladder.ui.InputView;
import ladder.ui.OutputView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderApp {

    private static final Logger LOGGER = Logger.getLogger(LadderApp.class.getName());

    private static final String ALL_USER = "all";

    public static void main(String[] args) {
        try (InputView inputView = getInputView()) {
            Users users = Users.createUsersWithName(inputView.getUser());
            LadderResult ladderResult = new LadderResult(inputView.getResult(), users.size());
            LadderLength ladderLength = new LadderLength(inputView.getVerticalLine());

            Ladder ladder = LadderFactory.getLadder(users.size(), ladderLength);
            OutputView.printLadder(users, ladder, ladderResult);

            while (true) {
                List<User> foundUsers = getUser(users, inputView.getUserForResult());
                List<Position> userPositions = users.findUserPositionByUsers(foundUsers);
                List<Position> resultPositions = ladder.play(userPositions);

                List<UserResult> results = getUserResults(users, ladderResult, userPositions, resultPositions);
                OutputView.printResult(results);
            }
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, "유효하지 않은 입력값입니다.", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static List<UserResult> getUserResults(Users users, LadderResult ladderResult, List<Position> userPositions, List<Position> resultPositions) {
        return IntStream.range(0, userPositions.size())
                .mapToObj((idx) -> {
                    User user = users.findUserByPosition(getPosition(userPositions, idx));
                    Result result = ladderResult.findResultByPosition(getPosition(resultPositions, idx));
                    return new UserResult(user, result);
                })
                .collect(Collectors.toList());
    }

    private static Position getPosition(List<Position> positions, int idx) {
        return positions.get(idx);
    }

    private static InputView getInputView() {
        return new InputView(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static List<User> getUser(Users users, String name) {
        if (name.equals(ALL_USER)) {
            return users.findAllUser();
        }
        return List.of(new User(name));
    }
}
