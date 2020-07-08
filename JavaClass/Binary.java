package JavaClass;

public class Binary extends Encoder{
    Binary() {
        symbol_map = "01";
    }

    @Override
    public byte[] CodeWord(byte[] in){
        byte[] out = new byte[in.length * 8];

        for(int i = 0; i < in.length; i++)
            for(int j = 7; j >= 0; j--)
                out[i*8 + j] = (byte)((in[i] & (1 << (7 - j))) >> (7 - j));
        return out;
    }
}