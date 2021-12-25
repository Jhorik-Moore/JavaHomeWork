package com.pb.gvozdev.hw13;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import java.util.Random;

@RequiredArgsConstructor
public class Producer implements Runnable {

    private final Buffer buffer;

    @SneakyThrows
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Поток " + threadName + " наполняет буфер:");
        synchronized (buffer) {
            if (buffer.buffer.isEmpty()) {
                while (buffer.buffer.size() < 5) {
                    Random random = new Random();
                    int programNumber = random.nextInt(100);
                    buffer.buffer.add(programNumber);
                    Thread.sleep(1000);
                    System.out.println(programNumber);
                }
                System.out.println("Поток " + threadName + " наполнил буфер\n" + buffer.buffer);
                Thread.sleep(1000);
                buffer.notify();
            }
        }
    }
}

