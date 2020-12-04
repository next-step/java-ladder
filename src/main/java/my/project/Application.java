package my.project;

import my.project.domain.Ladder;
import my.project.view.InputView;
import my.project.dto.Users;

/**
 * Created : 2020-12-04 오전 8:51
 * Developer : Seo
 */
public class Application {
    public static void main(String[] args) {
        Users users = new Users(InputView.getUsers());
        Ladder ladder = new Ladder(InputView.getLadderHeight());
        ladder.draw();
    }
}
