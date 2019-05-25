package org.interview.preperation.java8;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class DecoratorPattern {
    static class Camera {
        private Function<Color, Color> filter;

        public Camera(Function<Color, Color>... filters) {
            setFilters(filters);
        }

        private void setFilters(Function<Color, Color>... filters) {
            filter = Stream.of(filters)
                    .reduce(Function.identity(), Function::andThen);
        }

        public Color snap(Color color) {
            return filter.apply(color);
        }
    }

    private static void printSnap(Camera camera) {
        System.out.println(camera.snap(new
                Color(125, 125, 125)));
    }

    public static void main(String args[]) {
        printSnap(new Camera());
        printSnap(new Camera(Color::brighter,Color::darker));
    }
}
