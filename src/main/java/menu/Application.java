package menu;

import menu.controller.CoachController;
import menu.controller.MainController;
import menu.controller.MenuController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(
                new CoachController(),
                new MenuController());
        mainController.run();
    }
}
