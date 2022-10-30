package step2;

import step2.domain.Users;
import step2.view.InputView;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        Users users = new Users(InputView.inputUsers());
    }
}
