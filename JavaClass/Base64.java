package JavaClass;

public class Base64 extends Encoder{
    Base64(){
        symbol_map = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
    }

    @Override
    public byte[] CodeWord(byte[] in){
        byte [] word = new byte[4];
        word[0] = (byte) ((in[0] & 0xfc) >> 2);
        word[1] = (byte) (((in[0] & 0x3) << 4) | ((in[1] & 0xf0)>> 4));
        word[2] = (byte) (((in[1] & 0xf) << 2) | ((in[2] & 0xc0)>>2));
        word[3] = (byte) (in[2] &0x3f);
        return word;
    }

    @Override
    public String encode(byte[] in){
        byte[] word;
        byte[] in_code = new byte[3];
        String result = "";

        for (int i = 0 ; i < in.length ; i = i+3) {
            in_code[0] = in[i];
            in_code[1] = in[i+1];
            in_code[2] = in[i+2];

            word = CodeWord(in_code);

            for (int j = 0 ; j < 4; j++) {
                result += toString(word[j]);
            }
        }
        return result;
    }
}
