package nextstep.ladder;

public class LadderController {
    private static final LadderView view = new LadderView();
    public static void main(String[] args) {
         var users = view.getUsers();
         var height = view.getHeight();

         var ladder = new Ladder(users, height, new RandomGenerationStrategy());
         view.printResults(ladder);
    }
}
