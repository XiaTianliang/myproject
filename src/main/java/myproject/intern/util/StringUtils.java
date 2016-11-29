package myproject.intern.util;

import java.nio.charset.Charset;

public class StringUtils {
    private static final String UTF8_ENCODING = "UTF-8";
    private static final Charset UTF8_CHARSET = Charset.forName(UTF8_ENCODING);

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.trim().length() <= 0;
    }

    public static byte[] truncate(String string, int length) {
        if (isEmpty(string)) {
            return null;
        } else {
            byte[] raw = toBytes(string);
            if (length >= raw.length) {
                return raw;
            } else {
                byte[] result = new byte[length];
                System.arraycopy(raw, 0, result, 0, length);
                return result;
            }
        }
    }

    public static byte[] toBytes(String s) {
        return s.getBytes(UTF8_CHARSET);
    }

    public static String toString(final byte[] b) {
        if (b == null) {
            return null;
        }
        return toString(b, 0, b.length);
    }

    public static String toString(final byte[] b, int off, int len) {
        if (b == null) {
            return null;
        }
        if (len == 0) {
            return "";
        }
        return new String(b, off, len, UTF8_CHARSET);
    }

    public static byte[] fixSuffix(String value, int length) {
        byte[] data = new byte[length];
        for (int i = 0; i < length; i++) {
            data[i] = (byte) ' ';
        }
        if (isNotEmpty(value)) {
            byte[] raw = toBytes(value);
            System.arraycopy(raw, 0, data, 0, Math.min(raw.length, length));
        }
        return data;
    }

    public static String join(String top, Object... args) {
        StringBuilder sb = new StringBuilder(top);
        for (Object arg : args) {
            sb.append(arg.toString());
        }
        return sb.toString();
    }
}
