package com.ll.wiseSaying;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // System.in --> 표준 입력(키보드)
        //
        String str = "등록\n현재를 사랑하라.\n작자미상\n";
        Scanner sc = new Scanner(str);

        String s1 = sc.nextLine();
        System.out.println("s1 = " + s1);

        String s2 = sc.nextLine();
        System.out.println("s2 = " + s2);

        String s3 = sc.nextLine();
        System.out.println("s3 = " + s3);

        TestApp app = new TestApp();
        app.run();
    }
}
