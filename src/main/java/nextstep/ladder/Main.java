package nextstep.ladder;

public class Main {

    public static void main(String[] args) {
        try {
            LadderController ladderController = new LadderController();
            ladderController.start();
        }catch (Exception exception){
            System.out.println(String.join("\n", "error", exception.getMessage()));
        }
    }
}
