package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.MenuCategory;
import menu.domain.RecommendHistory;

public class MenuController {
    public List<RecommendHistory> recommend(List<Coach> coaches) {
        List<RecommendHistory> recommendHistories = initHistories(coaches);

        for (int i = 0; i < 5; i++) {
            // 카테고리 정하고
            // 안겹치게 메뉴 정하고
            // 각 맵에 저장
        }

        return recommendHistories;
    }

    private List<RecommendHistory> initHistories(List<Coach> coaches) {
        List<RecommendHistory> recommendHistories = new ArrayList<>();
        coaches.forEach(
                coach -> recommendHistories.add(new RecommendHistory(coach))
        );
        return recommendHistories;
    }

    private void recommendDay(List<RecommendHistory> recommendHistories) {
        MenuCategory menuCategory = choiceRandomCategory(recommendHistories);
        List<String> menus = Menu.findMenuNamesByCategory(menuCategory);
        String menu = Randoms.shuffle(menus).get(0);

        // 중복되거나  싫어하면 안됨
        for (RecommendHistory history : recommendHistories) {
            if (history.canEat(menu)) {
                history.addRecommendMenu(menu);
            }
        }
    }

    // 카테고리가 2개 이상이거나
    private MenuCategory choiceRandomCategory(List<RecommendHistory> recommendHistories) {
        int categoryNumber = Randoms.pickNumberInRange(1, 5);
        MenuCategory menuCategory = MenuCategory.findByCategoryNum(categoryNumber);

        while (recommendHistories.get(0).countOf(menuCategory) > 2) {
            menuCategory = choiceRandomCategory(recommendHistories);
        }

        return menuCategory;
    }
}
