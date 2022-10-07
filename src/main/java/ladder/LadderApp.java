package ladder;

import ladder.model.User;
import ladder.model.Users;
import ladder.service.LineGenerator;
import ladder.service.impl.RandomLineGenerator;
import ladder.ui.InputView;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LadderApp {

    public static void main(String[] args) {
        try(InputView inputView = getInputView()){
            Users users = Users.createUsersWithName(inputView.getUser());
            Integer lineLength = inputView.getVerticalLine();

            LineGenerator generator = getLineGenerator();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static InputView getInputView() {
        return new InputView(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static LineGenerator getLineGenerator(){
        return new RandomLineGenerator();
    }
}
