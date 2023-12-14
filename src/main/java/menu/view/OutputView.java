package menu.view;


import java.util.List;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.RecommendHistory;

public class OutputView {
    public static void println() {
        System.out.println();
    }
    public static void println(String message) {
        System.out.println(message);
    }
    public static void print(String message) {
        System.out.print(message);
    }

    public static void printRecommendMenus(List<RecommendHistory> recommendMenus) {
        OutputView.println("메뉴 추천 결과입니다.");
        OutputView.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        OutputView.println(recommendMenus.get(0).getCategories());
        recommendMenus.forEach(history -> println(history.toString()));
        OutputView.println();
        OutputView.println("추천을 완료했습니다.");
    }
}
