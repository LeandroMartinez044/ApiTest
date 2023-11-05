package com.martinez.utils;

import org.apache.commons.lang3.StringUtils;

public final class Validate {
    public static boolean notBlank(CharSequence cs, String message) {
        if (StringUtils.isBlank(cs)) {
            throw new RuntimeException(message);
        }

        return true;
    }

    public static boolean notNull(Object o, String message) {
        if (o == null) {
            throw new RuntimeException(message);
        }

        return true;
    }
}
