import domain.wiseSaying.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;
    private int lastId;
    private List<WiseSaying> wiseSayings;

    public App(Scanner sc) {
        this.sc = sc;
        this.lastId = 0;
        this.wiseSayings = new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령 ) ");
            String cmd = sc.nextLine();

            if(cmd.equals("종료")) {

                System.out.println("명언앱을 종료합니다.");
                break;

            } else if(cmd.equals("등록")) {

                System.out.println("명언 : ");
                String content = sc.nextLine();
                System.out.println("작가 : ");
                String author = sc.nextLine();

                int id = ++lastId;
                WiseSaying wiseSaying = new WiseSaying(id, content, author);
                wiseSayings.add(wiseSaying);

                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));

            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                System.out.println("2 / 작자미상 / 과거에 집착하지 마라.");
                System.out.println("1 / 작자미상 / 현재를 사랑하라.");
            }
        }
    }
}
