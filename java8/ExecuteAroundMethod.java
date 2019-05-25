package org.interview.preperation.java8;

import java.util.function.Consumer;

public class ExecuteAroundMethod {
    static class Resource {
        private Resource() {

        }

        public Resource op1() {
            System.out.println("op1");
            return this;
        }

        public void op2() {
            System.out.println("op2");
        }

        private void close() {
            System.out.println("close");
        }

        public static void use(Consumer<Resource> block) {
            //pre operation
            Resource resource = new Resource();
            try {
                block.accept(resource);
            } finally {
                //post operation
                resource.close();
            }
        }
    }

    public static void main(String args[]){
        Resource.use(resource -> resource.op1().op2());
    }
}
