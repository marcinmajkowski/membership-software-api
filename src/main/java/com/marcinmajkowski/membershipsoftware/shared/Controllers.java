package com.marcinmajkowski.membershipsoftware.shared;

public class Controllers {

    public static <T> T requireEqualOrNull(T obj, T equalOrNull) {
        if (equalOrNull != null && !obj.equals(equalOrNull)) {
            throw new IllegalArgumentException();
        }

        return obj;
    }
}
