package my.project;

import my.project.domain.LadderGenerator;
import my.project.domain.Users;
import my.project.view.InputView;
import my.project.view.ResultView;

/**
 * Created : 2020-12-04 오전 8:51
 * Developer : Seo
 */
public class Application {
    public static void main(String[] args) {
        Users users = new Users(InputView.getUsers());
        LadderGenerator generator = new LadderGenerator(users, InputView.getLadderHeight());
        ResultView.print(users, generator.generate());
    }
}
