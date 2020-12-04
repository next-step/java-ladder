package ladder;

import ladder.DTO.LadderDTO;
import ladder.DTO.UsersDTO;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class Client {

    private static Users users;
    private static int ladderHeight;
    private static Ladder ladder;

    public static void main(String[] args) {
        setUpUser();
        setUpLadderHeight();
        generateLadder();
        printUsers();
        printLadder();
    }

    private static void setUpUser() {
        String userNameInput = InputView.askNames();
        List<String> parsedInput = InputParser.parseRawInput(userNameInput);
        users = new Users(parsedInput);
    }

    private static void setUpLadderHeight() {
        ladderHeight = InputView.askLadderHeight();
    }

    private static void generateLadder() {
        ladder = new Ladder(ladderHeight, users.size());
        ladder.shuffle();
    }

    private static void printUsers() {
        ResultView.printResultOpening();

        UsersDTO usersDTO = users.exportData();
        List<String> users = usersDTO.getUsers();
        ResultView.printUsers(users);
    }

    private static void printLadder() {
        LadderDTO ladderDTO = ladder.exportData();
        List<List<Boolean>> layout = ladderDTO.getLayout();
        ResultView.printLadder(layout);
    }
}
