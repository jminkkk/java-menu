package menu.controller;

import java.util.List;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.RecommendHistory;
import menu.view.OutputView;

public class MainController {
    private final CoachController coachController;
    private final MenuController menuController;

    public MainController(CoachController coachController, MenuController menuController) {
        this.coachController = coachController;
        this.menuController = menuController;
    }

    public void run() {
        OutputView.println("점심 메뉴 추천을 시작합니다.");
        OutputView.println();

        List<Coach> coaches = coachController.init();
        List<RecommendHistory> recommendMenus = menuController.recommend(coaches);

        OutputView.printRecommendMenus(recommendMenus);
    }
}
