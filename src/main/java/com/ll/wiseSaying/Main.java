package com.ll.wiseSaying;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        test2();
    }

    public static void test2() {
        // System.out -> 표준 출력 -> 모니터(콘솔)
        // 출력문의 값을 문자열로 받아서 봇에게 줄 수 있다.

        // 기존 출력 스트림 저장
        PrintStream origin = System.out;
        // 비어있는 스트림
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 출력 스트림 설정 변경
        System.setOut(new PrintStream(out));
        // 출력문이 out이 가르키는 스트림에 전달
        System.out.println("hello");
        // 기존 출력 스트림으로 다시 변경
        System.setOut(origin);
        // out 변수가 참조하고 있는 스트림이 가지고 있는 값 문자열로 변환
        String str = out.toString();
        //출력(모니터)
        System.out.println(str);
    }

    public static void test1() {
        // System.in --> 표준 입력

        // 1. 입력을 봇에게 맡기 수 있다.
        Scanner scan = new Scanner("등록\n현재를 사랑하라.\n작자미상\n");

        String val1 = scan.nextLine();
        System.out.println(val1);

        String val2 = scan.nextLine();
        System.out.println(val2);

        String val3 = scan.nextLine();
        System.out.println(val3);

        //테스트봇 만들기

        App app = new App();
        app.run();
    }
}
