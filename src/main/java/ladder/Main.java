package ladder;


import ladder.Controller.LadderController;

public class Main {
    public static void main(String[] args) {
        LadderController ladderController = LadderController.of();
        ladderController.climbLadder();
    }
}
