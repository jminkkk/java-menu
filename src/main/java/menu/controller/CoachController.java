package menu.controller;

import static menu.util.CoachFactory.generate;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.util.validator.CoachValidator;
import menu.util.validator.MenuValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class CoachController {
    public List<Coach> init() {
        List<Coach> coaches = generate(createCoaches());
        OutputView.println();

        registerHateMenu(coaches);
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

    private void registerHateMenu(List<Coach> coaches) {
        for (Coach coach : coaches) {
            OutputView.println(coach.getName() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            List<String> hateMenus = getHateMenus();

            coach.addHateMenus(hateMenus);
            OutputView.println();
        }
    }

    private List<String> getHateMenus() {
        String[] hateMenus = InputView.input().split(",");
        MenuValidator.validate(hateMenus);

        List<String> hateMenuList = new ArrayList<>();
        for (String menu : hateMenus) {
            hateMenuList.add(menu);
        }

        return hateMenuList;
    }
}
