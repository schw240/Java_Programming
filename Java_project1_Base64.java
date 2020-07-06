public class base64 {

    private static final char[] base64 = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };

    public static void encode(StringBuffer eBuffer,char [] src,int length){

        for (int i = 0; i < length; i += 3){
            eBuffer.append(base64[(int)(src[i] >> 2 & 0x3f)]);
            if ((i + 1) == length){
                eBuffer.append(base64[(int)(src[i] << 4) & 0x30]);
                eBuffer.append("==");
                break;
            }

            eBuffer.append(base64[(int)((src[i] << 4) & 0x30) | (src[i + 1] >> 4 & 0xf)]);

            if (i + 2 == length){
                eBuffer.append(base64[(int)((src[i + 1] << 2) & 0x3c)]);
                eBuffer.append('=');
                break;
            }

            eBuffer.append(base64[(int)(((src[i + 1] << 2) & 0x3c) | ((src[i + 2] >> 6) & 0x3))]);
            eBuffer.append(base64[(int)(src[i + 2] & 0x3f)]);
        }

    }

    private static int getIndex(char src) {
        if (src >= 'A' && src <= 'Z')
            return (int)(src - 'A') ;
        else if (src >= 'a' && src <= 'z')
            return (int)('Z' - 'A') + (int)(src - 'a') + 1;
        else if (src >= '0' && src <= '9')
            return (int)('Z' - 'A') + (int)('z' - 'a') + 1 + (int)(src - '0' + 1);
        else if (src == '+')
            return 62;
        else if (src == '/')
            return 63;
        return 0xff;
    }

    public static void decode(StringBuffer dBuffer,char [] src,int length){

        for (int i = 0; i < length; i += 4){
            dBuffer.append((char)(((getIndex(src[i]) << 2) & 0xfc) | ((getIndex(src[i + 1]) >> 4) & 0x3)));

            if (src[i + 2] == '=')
                break;

            dBuffer.append((char)(((getIndex(src[i + 1]) << 4) & 0xf0) | ((getIndex(src[i + 2]) >> 2) & 0xf)));

            if (src[i + 3] == '=')
                break;

            dBuffer.append((char)(((getIndex(src[i + 2]) << 6) & 0xc0) | ((getIndex(src[i + 3])) & 0x3f)));
        }
    }

    public static void main(String[] args) {

        String s = "SGFwcHkgaGFja2luZyB3aXRoIEphdmEgcHJvZ3JhbW1pbmch";
        StringBuffer mainBuffer2 = new StringBuffer();
        decode(mainBuffer2, s.toCharArray(), s.length());
        System.out.println("Base64 sentence is: " + s);
        System.out.println("Decode sentence is :" + mainBuffer2.toString());
        System.out.println("");

        String s2 = "Happy hacking with Java programming!";
        StringBuffer mainBuffer = new StringBuffer();
        encode(mainBuffer, s2.toCharArray(), s2.length());
        System.out.println("ASCII sentence is: " + s2);
        System.out.println("Encode sentence is : " + mainBuffer.toString());

    }
}
