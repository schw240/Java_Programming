package JavaClass;
public abstract class Encoder implements Encoderble {
    protected String symbol_map;

    @Override
    abstract public byte[] CodeWord(byte[] in);//{
//      return in;
//   }

    @Override
    public String toString(int value){
        return symbol_map.charAt(value) + "";
    }

    @Override
    public String encode(byte[] in) {
        String res = "";
        byte[] out = CodeWord(in);
        for(int i = 0; i < out.length; i++) {
            res += toString((int)out[i]);
        }
        return res;
    }
}

