package ladder.controller;

import ladder.DTO.LadderDTO;
import ladder.DTO.UsersDTO;
import ladder.domain.InputParser;
import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class Controller {

    private Users users;
    private int ladderHeight;
    private Ladder ladder;

    public Controller() {
    }

    public void run() {
        setUpUser();
        setUpLadderHeight();
        generateLadder();
        printOpening();
        printUsers();
        printLadder();
    }

    private void setUpUser() {
        String userNameInput = InputView.askNames();
        List<String> parsedInput = InputParser.parseRawInput(userNameInput);
        users = new Users(parsedInput);
    }

    private void setUpLadderHeight() {
        ladderHeight = InputView.askLadderHeight();
    }

    private void generateLadder() {
        ladder = new Ladder(ladderHeight, users.size() - 1);
        ladder.shuffle();
    }

    private void printOpening() {
        ResultView.printResultOpening();
    }

    private void printUsers() {
        UsersDTO usersDTO = users.exportData();
        List<String> users = usersDTO.getUsers();
        ResultView.printUsers(users);
    }

    private void printLadder() {
        LadderDTO ladderDTO = ladder.exportData();
        List<List<Boolean>> layout = ladderDTO.getLayout();
        ResultView.printLadder(layout);
    }
}
