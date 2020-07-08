package JavaClass;

public class Hex extends Encoder{
    Hex(){
        symbol_map = "0123456789ABCDEF";
    }

    @Override
    public byte[] CodeWord(byte[] in){
        byte[] word = new byte[in.length * 2];

        for(int i = 0; i <in.length; i++){
            word[i*2] = (byte)(in[i] >> 4);
            word[i*2 + 1] = (byte)(in[i] & 0x0F);
        }
        return word;
    }
}