package DESHW5;

import com.sun.org.apache.xpath.internal.operations.Bool;
//export JAVA_OPTS="-Dfile.encoding=UTF-8";
import java.io.IOException;

import static DESHW5.Conversion.bytesToBooleans;

public class DES {

    public static void main(String arg[]) throws IOException {

//
//        FileReader f = new FileReader();
//
//        int count = 0;
//
//        String s = String.valueOf(f.readFileLines("src//hw5_DES_encryption.txt"));
//        //boolean[] boolText = bytesToBooleans(plainText);
//        Conversion.stringToByteArray(s);
//        byte[] plainText = Conversion.stringToByteArray(s);
//        ;
//
//        boolean[] boolText = bytesToBooleans(plainText);


       // System.out.println(boolText);

        byte[] plainText = {
                0,1,0,1,0,1,0,1,
                1,0,0,0,1,0,1,0,
                0,0,1,0,1,0,0,1,
                1,1,0,1,0,0,1,1,
                0,1,1,0,0,1,0,0,
                0,1,0,1,1,0,1,0,
                1,0,1,0,1,1,0,1,
                1,0,0,1,0,1,0,1
        };

        byte[] key = {
                0,0,1,1,1,0,0,1,
                1,0,0,0,1,1,0,1,
                0,1,1,1,0,0,1,0,
                1,1,0,0,0,1,1,0,
                0,0,1,1,0,1,0,1,
                1,0,1,1,0,1,0,0,
                0,0,0,1,1,1,1,0,
                1,1,0,1,0,0,0,1
        };
        int i,j,k;
        byte[] key1 = new byte[64];
        byte[][] keylist = new byte[16][48];
        byte[] cipher =new byte[64];


        System.out.println("============키생성과정============");
        key1 = KeyMaker.Pc1(key);
        keylist = KeyMaker.keyGeneration(key1);


        System.out.println();
        System.out.println("============Encoding과정============");
        System.out.print("Plain Text : ");
        for(i=0;i<64;i++)	{
            System.out.print(plainText[i]);
            if(i%8==7)
                System.out.print("  ");
        }
        System.out.println();


        cipher = (byte[]) EnDecrypt.Ip(plainText);

        for(j=0;j<16;j++) {
            System.out.println("***"+ (j+1) + "라운드반복(Encoding과정)***  ");
            cipher = EnDecrypt.Rounding(cipher,keylist[j]);
        }

        cipher = EnDecrypt.swaping(cipher);

        cipher = EnDecrypt.Ip2(cipher);
        System.out.println("***result***");
        for(k=0;k<64;k++){
            System.out.print(cipher[k]);
            if(k%8 == 7)
                System.out.print("  ");
        }
        System.out.println();


        System.out.println();
        System.out.println("============Decoding============");
        System.out.print("Encoding result : ");
        for(i=0;i<64;i++)	{
            System.out.print(cipher[i]);
            if(i%8==7)
                System.out.print(" ");
        }
        System.out.println();


        cipher = EnDecrypt.Ip2(cipher);

        for(j=0;j<16;j++) {
            System.out.println("*"+ (j+1) + "라운드반복(Decoding과정)*  ");
            cipher = EnDecrypt.Rounding(cipher,keylist[j]);
        }

        cipher = EnDecrypt.swaping(cipher);
        cipher = (byte[]) EnDecrypt.Ip(cipher);

        System.out.print("Decoding : ");
        for(i=0;i<64;i++){
            System.out.print(cipher[i]);
            if(i%8 == 7)
                System.out.print("  ");
        }
        System.out.println();

    }
}

