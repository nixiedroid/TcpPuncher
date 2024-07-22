package com.nixiedroid.util;

@SuppressWarnings("unused")

public final class ByteArrays {

    private ByteArrays() {
        throw new Error();
    }

    public static void xor(final byte[] first, final byte[] second) {
        if (first == null || second == null) throw new IllegalArgumentException("Null Array");
        if (first.length != second.length) throw new IllegalArgumentException("Wrong Length");
        final int length = first.length;
        for (int i = 0; i < length; i++) first[i] ^= second[i];
    }

    public static void reverse(final byte[] input) {
        if (input == null) throw new IllegalArgumentException();
        int i = 0, j = input.length - 1;
        byte tmp;
        while (j > i) {
            tmp = input[j];
            input[j] = input[i];
            input[i] = tmp;
            j--;
            i++;
        }
    }

    public static boolean equals(byte[] a, int aFromIndex, int aToIndex,
                                 byte[] b, int bFromIndex, int bToIndex) {
        if (a == b) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.length == 0) {
            return b.length == 0;
        }

        int lenA = aToIndex - aFromIndex;
        int lenB = bToIndex - bFromIndex;

        if (lenB == 0) {
            return lenA == 0;
        }

        int result = 0;
        result |= lenA - lenB;

        // time-constant comparison
        for (int indexA = 0; indexA < lenA; indexA++) {
            int indexB = ((indexA - lenB) >>> 31) * indexA;
            result |= a[aFromIndex + indexA] ^ b[bFromIndex + indexB];
        }

        return result == 0;
    }

}
