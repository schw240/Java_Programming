package DESHW5;

public class KeyMaker {

    static int[] PC1 = {
            57,49,41,33,25,17, 9,
            1,58,50,42,34,26,18,
            10, 2,59,51,43,35,27,
            19,11, 3,60,52,44,36,
            63,55,47,39,31,23,15,
            7,62,54,46,38,30,22,
            14, 6,61,53,45,37,29,
            21,13, 5,28,20,12, 4
    };

    static int[] PC2 = {
            14,17,11,24, 1, 5,
            3,28,15, 6,21,10,
            23,19,12, 4,26, 8,
            16, 7,27,20,13, 2,
            41,52,31,37,47,55,
            30,40,51,45,33,48,
            44,49,39,56,34,53,
            46,42,50,36,29,32
    };

    static int sc[] = {1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1};
    static byte[] block = new byte[56];
    static byte[] temp2 = new byte[48];
    static byte[] rightkey = new byte[28];
    static byte[] leftkey = new byte[28];
    static byte[][] keylist = new byte[16][48];
    static byte tmp2 = 0;
    static byte tmp1 = 0;
    static int i,j,v,k,l=0;
    //private static KeyMakey KeyMaker;

    static byte[] Pc1 (byte[] original) {
        byte[] key = new byte[56];
        System.out.print("최초 56비트키 + 8비트 패리티비트 : ");
        for(i=0;i<56;i++){
            System.out.print(original[i]);
            if(i%8==7)
                System.out.print(" ");
        }
        System.out.println();


        System.out.print("PC1순열수행후 : ");
        for(i=0;i<56;i++){
            key[i] = original[PC1[i]-1];
            System.out.print(key[i]);
            if(i%7==6)
                System.out.print(" ");
        }
        System.out.println();
        return key;
    }


    static byte[] Shift (byte temp[],int j) {
        byte[] carry = new byte[2];

        carry[0] = temp[0];
        carry[1] = temp[1];

        if(j==1 || j==2 || j==9 || j==16 )
            v=1;
        else v=2;


        for(i=0;i<26;i++) {
            temp[i]=temp[i+v];
        }

        if(v==1) {
            temp[26]=temp[27];
            temp[27]=carry[0];
        }
        else if(v==2) {
            temp[25]=temp[27];
            temp[26]=carry[0];
            temp[27]=carry[1];
        }
        return temp;
    }

    static byte[][] keyGeneration (byte a[]) {

        for(i=0;i<28;i++) {
            leftkey[i] = a[i];
            rightkey[i] = a[i+28];
        }

        for(k=0;k<16;k++) {
            System.out.println();
            System.out.println((k+1)+"번째키생성과정");
            leftkey = KeyMaker.Shift(leftkey,(k+1));
            rightkey =KeyMaker.Shift(rightkey,(k+1));

            System.out.println(" "+ sc[k] + "shift수행후");
            System.out.print("   왼쪽비트 (L"+(k+1)+") : ");
            for(i=0;i<28;i++){
                System.out.print(leftkey[i]);
                if(i%7==6)
                    System.out.print("  ");
            }
            System.out.println();

            System.out.print("   오른쪽비트 (R"+(k+1)+") : ");
            for(i=0;i<28;i++){
                System.out.print(leftkey[i]);
                if(i%7==6)
                    System.out.print("  ");
            }
            System.out.println();

            for(l=0;l<28;l++) {
                block[l] = leftkey[l];
                block[l+28] = rightkey[l];
            }

            System.out.print(" =>"+(k+1) +"번째 키 : ");
            for(l=0;l<48;l++) {
                temp2[l] = block[PC2[l]-1];
                keylist[k][l]=temp2[l];
                System.out.print(temp2[l]);
                if(l%8 == 7)
                    System.out.print("  ");
            }
        }
        return keylist;
    }
}
