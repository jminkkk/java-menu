package menu.controller;

import static menu.util.CoachFactory.generate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.util.validator.CoachValidator;
import menu.util.validator.MenuValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class CoachController {
    public List<Coach> init() {
        String[] coachNames = createCoaches();
        List<Coach> coaches = generate(coachNames);
        OutputView.println();

        registerHateMenu(coaches);
        return coaches;
    }

    private String[] createCoaches() {
        OutputView.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        try {
            String[] coachNames = InputView.input().split(",");
            CoachValidator.validate(coachNames);
            return coachNames;
        } catch (IllegalArgumentException e) {
            OutputView.println(e.getMessage());
        }
        return createCoaches();
    }

    private void registerHateMenu(List<Coach> coaches) {
        for (Coach coach : coaches) {
            List<String> hateMenus = getHateMenus(coach.getName());

            coach.addHateMenus(hateMenus);
            OutputView.println();
        }
    }

    private List<String> getHateMenus(String name) {
        OutputView.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String input = InputView.input();

        if (input.isBlank()) {
            return new ArrayList<>();
        }

        try {
            String[] hateMenus = input.split(",");
            MenuValidator.validate(hateMenus);
            return Arrays.stream(hateMenus)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            OutputView.println(e.getMessage());
            return getHateMenus(name);
        }
    }
}
