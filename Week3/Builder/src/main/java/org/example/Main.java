package org.example;

public class Main {
    public static void main(String[] args) {
        StreamingSubscription ss1 = new StreamingSubscription.Builder("Streaming", 4.99)
                .name("Duilio")
                .devices(2)
                .ads(true)
                .resolution(Resolution.HD)
                .build();

        System.out.println(ss1);

    }
}