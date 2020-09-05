package nextstep.controller;

import nextstep.entity.Entries;
import nextstep.entity.Length;
import nextstep.view.InputView;
import nextstep.view.ResultView;

public class Controller {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        Entries entries = inputView.inputEntries();
        Length length = inputView.inputLength();

        resultView.printEntries(entries);
    }
}
