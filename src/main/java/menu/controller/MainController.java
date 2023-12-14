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

        OutputView.println("메뉴 추천 결과입니다.");
        OutputView.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        OutputView.println("[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]");
        OutputView.printRecommendMenus(recommendMenus);
        OutputView.println();
        OutputView.println("추천을 완료했습니다.");
    }
}
