package nextstep.ladder.controller;

import java.util.List;

import nextstep.ladder.module.Height;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {

    private final static InputView inputView = new InputView();
    private final static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        List<String> peopleNames = inputView.getPeopleNames();
        Height height = new Height(inputView.getHeight());

        
    }
}
