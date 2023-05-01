package com.radsoltan;


import com.radsoltan.strings.MicroBlog;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MicroBlog microBlog = new MicroBlog();
        System.out.println(microBlog.truncate("\uD83C\uDCCE\uD83C\uDCB8\uD83C\uDCC5\uD83C\uDCCB\uD83C\uDCCD\uD83C\uDCC1\uD83C\uDCCA"));
    }
}