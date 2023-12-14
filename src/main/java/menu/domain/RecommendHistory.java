package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class RecommendHistory {
    private final Coach coach;
    private final List<String> menus;

    public RecommendHistory(Coach coach) {
        this.coach = coach;
        this.menus = new ArrayList<>();
    }

    public void addRecommendMenu(String menu) {
        menus.add(menu);
    }

    public boolean canEat(String menu) {
        return !menus.contains(menu)
                && !coach.hateMenu(menu);
    }

    public int countOf(MenuCategory menuCategory) {
        return (int) menus.stream()
                .filter(menu -> MenuCategory.findMenuCategoryByMenu(menu) == menuCategory)
                .count();
    }
}
