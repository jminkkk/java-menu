package menu.controller;

import static menu.util.CoachFactory.generate;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.util.validator.CoachValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class CoachController {
    public List<Coach> init() {
        List<Coach> coaches = generate(createCoaches());
        OutputView.println();

        for (Coach c : coaches) {
            OutputView.println(c.getName() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            String cantEat = InputView.input();
            OutputView.println();
        }

        return coaches;
    }

    private String[] createCoaches() {
        OutputView.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        try {
            String[] coachNames = InputView.input().split(",");
            CoachValidator.validate(coachNames);
        } catch (IllegalArgumentException e) {
            OutputView.println();
        }
        return createCoaches();
    }

}
