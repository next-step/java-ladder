package ladder;


import ladder.controller.LadderController;

public class Main {
    public static void main(String[] args) {
        LadderController ladderController = LadderController.of();
        ladderController.climbLadder();
    }
}
