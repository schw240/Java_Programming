package  JavaClass;

public class Main {

    public static void main(String[] args) {
        Base64 bencoder = new Base64();
        Hex hencoder= new Hex();
        ASCII aencoder = new ASCII();
        Decimal dencoder = new Decimal();
        Binary Bencoder = new Binary();

        byte[] inputdata = new byte[6];
        inputdata[0] = 0x12;
        inputdata[1] = 0x34;
        inputdata[2] = 0x56;
        inputdata[3] = 65;
        inputdata[4] = 66;
        inputdata[5] = 67;

        String res1 = bencoder.encode(inputdata);
        String res2 = hencoder.encode(inputdata);
        String res3 = aencoder.encode(inputdata);
        String res4 = dencoder.encode(inputdata);
        String res5 = Bencoder.encode(inputdata);

        System.out.println("Base64 result: " + res1);
        System.out.println("Hex result: " + res2);
        System.out.println("ASCII result: " + res3);
        System.out.println("Decimal result: " + res4);
        System.out.println("Binary result: " + res5);
    }
}