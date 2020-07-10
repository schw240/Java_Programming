package DESHW5;

public class Conversion {
    public static String bytesToBinaryString (byte[] b) {
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<b.length; ++i){
            sb.append(byteToBinaryString(b[i]));
        }
        return sb.toString();
    }

    public static String byteToBinaryString (byte n) {
        StringBuilder sb = new StringBuilder("00000000");
        for (int bit = 0; bit < 8; bit++) {
            if (((n >> bit) & 1) > 0) {
                sb.setCharAt(7 - bit, '1');
            }
        }
        return sb.toString();
    }

    public static byte[] binaryStringToBytes (String s) {
        int count=s.length()/8;
        byte[] b=new byte[count];
        for(int i=1; i<=count; ++i){
            String t=s.substring((i-1)*8, i*8);
            b[i-1]=binaryStringToByte(t);
        }
        return b;
    }

    public static byte binaryStringToByte (String s) {
        byte ret=0, total=0;
        for(int i=0; i<8; ++i){
            ret = (s.charAt(7-i)=='1') ? (byte)(1 << i) : 0;
            total = (byte) (ret|total);
        }
        return total;
    }

    public static byte[] stringToByteArray (String s) {
        return s.getBytes();
    }

    public static byte[] stringToBytes (String s, int length) {
        byte[] o = new byte[length];
        byte[] b = stringToByteArray(s);

        for (int i=0; i<o.length && i<b.length; i++) {
            o[i] = b[i];
        }

        return o;
    }

    public static boolean[] bytesToBooleans (byte[] b) {
        boolean[] bool = new boolean[b.length * 8];

        for (int i=0; i<b.length; i++) {
            byte c = b[i];
            bool[8*i] = (c & 128) != 0;
            bool[8*i+1] = (c & 64) != 0;
            bool[8*i+2] = (c & 32) != 0;
            bool[8*i+3] = (c & 16) != 0;
            bool[8*i+4] = (c & 8) != 0;
            bool[8*i+5] = (c & 4) != 0;
            bool[8*i+6] = (c & 2) != 0;
            bool[8*i+7] = (c & 1) != 0;
        }

        return bool;
    }

    public static byte[] booleansToBytes (boolean[] bool) {
        int length = bool.length / 8;
        byte[] b = new byte[length];

        for (int i=0; i<length; i++) {
            b[i] = (byte)((bool[8*i] ? 128 : 0)
                    + (bool[8*i+1] ? 64 : 0)
                    + (bool[8*i+2] ? 32 : 0)
                    + (bool[8*i+3] ? 16 : 0)
                    + (bool[8*i+4] ? 8 : 0)
                    + (bool[8*i+5] ? 4 : 0)
                    + (bool[8*i+6] ? 2 : 0)
                    + (bool[8*i+7] ? 1 : 0));
        }

        return b;
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static void print (String label, boolean[] array) {
        System.out.print(label + ":\t");
        for (int i=0;; i++) {
            for (int j=0; j<8; j++) {
                if (8*i+j == array.length) {
                    System.out.print('\n');
                    return;
                }
                System.out.print(array[8*i+j] ? '1' : '0');
            }
            System.out.print(' ');
        }
    }
}
