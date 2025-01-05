package com.ll.wiseSaying;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestBot {

    // 자바 시간에 객체는 static 지양.
    // 객체 -> 데이터 x (상태 없음) -> static 사용 괜찮음
    // 따라서 테스트에서 new 하지 말고 바로 사용할 수 있게 함

    public static String run(String input) {
        Scanner sc = new Scanner(input + "종료\n");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        App app = new App();
        app.run();

        return out.toString();
    }
}