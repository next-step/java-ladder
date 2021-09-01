package newladder.controller;

import newladder.model.GameResult;
import newladder.model.MyLadderGame;
import newladder.model.Prize;
import newladder.model.Users;
import newladder.view.Input;
import newladder.view.Result;

public class Game {

    private final String ALL_RESULT = "all";

    MyLadderGame ladderGame;
    GameResult gameResult = new GameResult();
    Prize prize;

    public void makeLadder() {
        String[] users = Input.getUsers();
        String[] prizeList = Input.getPrizeList();
        prize = new Prize(prizeList);
        int ladderHeight = Input.getLadderHeight();

        ladderGame = new MyLadderGame(users, ladderHeight);
        Result.printUsers(ladderGame.usersInfo());
        Result.printLadder(ladderGame.ladderInfo());
        makeResult();
    }

    public void makeResult() {
        Users users = ladderGame.usersInfo();
        Result.printPrize(prize);
        users.usersInfo()
                .stream()
                .forEach(user -> {
                    int userIndex = users.userIndex(user.nameInfo());
                    gameResult.addResult(user.nameInfo(),
                            prize.prizeInfo(ladderGame.playLadder(userIndex)));
                });

        while (true) {
            printResult();
        }
    }

    private void printResult() {
        String userName = Input.getUser();
        if (userName == null) {
            return;
        }

        if (ALL_RESULT.equals(userName)) {
            Result.printResultAll(gameResult);
            return;
        }
        Result.printResult(gameResult.getResult(userName));
    }


}
