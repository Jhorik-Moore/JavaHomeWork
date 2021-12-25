package com.pb.gvozdev.hw13;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Consumer implements Runnable {

    private final Buffer buffer;

    @SneakyThrows
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        synchronized (buffer) {
            if (buffer.buffer.isEmpty()) {
                System.out.println(threadName + " ->> Буфер пуст");
                buffer.wait();
                System.out.println("Поток " + threadName + " достает данные:\n" + buffer.buffer);
                int i = 4;
                while (!buffer.buffer.isEmpty()) {
                    Thread.sleep(1000);
                    System.out.println("Удаляем: " + buffer.buffer.get(i));
                    buffer.buffer.remove(i);
                    i--;
                }
                System.out.println(threadName + " ->> Буфер пуст");
            }
        }
    }
}

