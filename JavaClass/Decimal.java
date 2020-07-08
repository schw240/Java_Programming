package JavaClass;

public class Decimal extends Encoder {
    Decimal(){
        symbol_map = "0123456789";
    }

    @Override
    public byte[] CodeWord(byte[] in) {
        byte[] out = new byte[in.length * 3];

        for(int i = 0; i < in.length; i++) {
            out[i * 3] = (byte)(in[i] / 100);
            out[i * 3 + 1] = (byte)(in[i] / 10 % 10);
            out[i * 3 + 2] = (byte)(in[i] % 10);
        }
        return out;
    }
}