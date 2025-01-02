package com.ll.wiseSaying;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class FirstTest {

    @Test
    @DisplayName("t1")
    void t1() {
        int res = 1;
        assertThat(res).isEqualTo(1);
    }
}
