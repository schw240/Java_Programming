package JavaClass;

public class ASCII extends Encoder {

    @Override
    public byte[] CodeWord(byte[] in){
        return in;
    }

    @Override
    public String toString(int value){
        return (char)value + "";
    }
}