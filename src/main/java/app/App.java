package app;

import app.domain.wiseSaying.SystemController;
import app.domain.wiseSaying.WiseSayingController;
import app.global.Command;

import java.util.Scanner;

public class App {

    private Scanner sc;
    private final WiseSayingController wiseSayingController;
    private final SystemController systemController;

    public App(Scanner sc) {
        this.sc = sc;
        this.wiseSayingController = new WiseSayingController(sc);
        this.systemController = new SystemController();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령 ) ");
            String cmd = sc.nextLine();

            //명령?부가정보 -> 명렁, 부가정보
//            String[] cmdBits = cmd.split("\\?");
//            String actionName = cmdBits[0];

            Command command = new Command(cmd);
            String actionName = command.getActionName();

            switch (actionName) {
                case "종료" -> systemController.exit();
                case "등록" -> wiseSayingController.actionWrite();
                case "목록" -> wiseSayingController.actionPrint();
                case "삭제" -> wiseSayingController.actionDelete(command);
                case "수정" -> wiseSayingController.actionModify(command);
                default -> System.out.println("올바른 명령이 아닙니다.");
            }
            if(cmd.equals("종료")) break;
        }

    }
}

