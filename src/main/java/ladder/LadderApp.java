package ladder;

import ladder.domain.*;
import ladder.dto.ResultDto;
import ladder.service.LadderService;
import ladder.ui.InputView;
import ladder.ui.OutputView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
                List<HorizontalPosition> resultPositions = ladderService.getResultOfUser(ladder, users, inputView.getUserForResult());
                List<ResultDto> resultDtos = resultPositions.stream()
                        .map((position) -> {
                            User foundUser = users.findUserByPosition(position);
                            String foundResult = ladderResult.result(position);
                            return new ResultDto(foundUser, foundResult);
                        }).collect(Collectors.toList());
                OutputView.printResult(resultDtos);
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
