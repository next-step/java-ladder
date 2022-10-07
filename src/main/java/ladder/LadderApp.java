package ladder;

import ladder.model.HorizontalLine;
import ladder.model.Users;
import ladder.service.LineGenerator;
import ladder.service.impl.RandomLineGenerator;
import ladder.ui.InputView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class LadderApp {

    static LineGenerator generator = getLineGenerator();

    public static void main(String[] args) {
        try(InputView inputView = getInputView()){
            Users users = Users.createUsersWithName(inputView.getUser());
            Integer lineLength = inputView.getVerticalLine();

            List<HorizontalLine> horizontalLines = generator.generate(users.size(), lineLength);

            users.addLine(horizontalLines);

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
