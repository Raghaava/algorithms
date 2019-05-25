package org.interview.preperation.java8;

import java.util.function.Consumer;

public class CascadePattern {

    static class Mailer {

        private void print(String msg) {
            System.out.println(msg);
        }

        public Mailer from(String from) {
            print("from: " + from);
            return this;
        }

        public Mailer to(String to) {
            print("to: " + to);
            return this;
        }

        public Mailer subject(String subject) {
            print("subject: " + subject);
            return this;
        }

        public Mailer body(String body) {
            print("body: " + body);
            return this;
        }

        public static void send(Consumer<Mailer> block) {
            Mailer mailer = new Mailer();
            block.accept(mailer);

            mailer.print("sending...");
        }
    }


    public static void main(String args[]) {
        Mailer.send(mailer -> mailer.from("Ragava")
                .to("Rag")
                .subject("hello")
                .body("body"));
    }
}
