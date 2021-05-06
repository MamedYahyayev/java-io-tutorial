/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.maqa.java.main;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mamedyahyayev
 */
public class PipeInputAndOutputStreamExample {

    private static final PipedInputStream pipedInputStream = new PipedInputStream();
    private static final PipedOutputStream pipedOutputStream = new PipedOutputStream();

    class Producer extends Thread {

        @Override
        public void run() {
            try {
                String message = "Hello, i am producer";
                pipedOutputStream.write(message.getBytes());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PipeInputAndOutputStreamExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(PipeInputAndOutputStreamExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    class Consumer extends Thread {

        @Override
        public void run() {
            try {
                int i;
                while ((i = pipedInputStream.read()) != 0) {
                    System.out.print((char) i);
                }
            } catch (IOException ex) {
                Logger.getLogger(PipeInputAndOutputStreamExample.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static void main(String[] args) {
        try {
            pipedOutputStream.connect(pipedInputStream);

            PipeInputAndOutputStreamExample demo = new PipeInputAndOutputStreamExample();
            ExecutorService service = Executors.newFixedThreadPool(2);
            Producer producer = demo.new Producer();
            Consumer consumer = demo.new Consumer();

            service.execute(producer);
            service.execute(consumer);
        } catch (IOException ex) {
            Logger.getLogger(PipeInputAndOutputStreamExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
