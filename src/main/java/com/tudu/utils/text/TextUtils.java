package com.tudu.utils.text;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.lang.Nullable;

@EnableConfigurationProperties(TextUtils.class)
@ConfigurationProperties(prefix = "text-utils")
public class TextUtils {

    /**
     * Returns true if the string is null or 0-length.
     *
     * @param str the string to be examined
     * @return true if str is null or zero length
     */
    public static boolean isEmpty(@Nullable CharSequence str) {
        return str == null || str.length() == 0;
    }

    /**
     * Returns length of the string if nonnull, otherwise 0
     *
     * @param str the string to be examined
     * @return lengt of str
     */
    public static int length(@Nullable String str) {
        return str != null ? str.length() : 0;
    }

    /**
     * Returns true if a and b are equal, including if they are both null.
     *
     * @param a first CharSequence to check
     * @param b second CharSequence to check
     * @return true if a and b are equal
     */
    public static boolean equals(@Nullable CharSequence a, @Nullable CharSequence b) {
        if (a == b) {
            return true;
        }
        int length;
        if (a != null && b != null && (length = a.length()) == b.length()) {
            if (a instanceof String && b instanceof String) {
                return a.equals(b);
            } else {
                for (int i = 0; i < length; i++) {
                    if (a.charAt(i) != b.charAt(i)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether the given CharSequence contains only digits.
     */
    public static boolean isDigitsOnly(CharSequence str) {
        final int len = str.length();
        for (int cp, i = 0; i < len; i += Character.charCount(cp)) {
            cp = Character.codePointAt(str, i);
            if (!Character.isDigit(cp)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns whether the given CharSequence contains only letters.
     */
    public static boolean isLettersOnly(CharSequence str) {
        final int len = str.length();
        for (int cp, i = 0; i < len; i += Character.charCount(cp)) {
            cp = Character.codePointAt(str, i);
            if (!Character.isLetter(cp)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns whether the given CharSequence contains only letters.
     */
    public static boolean contains(@Nullable String a, @Nullable CharSequence b) {
        if (a == null || b == null) {
            return false;
        }
        return a.contains(b);
    }

}
