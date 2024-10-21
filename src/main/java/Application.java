import ladder.domain.Users;
import ladder.view.InputView;

public class Application {
    public static void main(String[] args) {
        final Users users = new Users(InputView.inputUserNames());
    }
}
