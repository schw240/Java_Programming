package DESHW5;

public class EnDecrypt extends Encoder {

    static int i,j;

    static byte[] Ip (byte[] original) {
        byte[] temp= new byte[64];
        System.out.print("IP순열 통과후 : ");
        for(i=0;i<64;i++){
            temp[i] = original[IP[i]-1];
            System.out.print(temp[i]);
            if(i%8==7)
                System.out.print("  ");
        }
        System.out.println();
        return temp;
    }

    static byte[] Ip2 (byte[] original) {
        byte[] temp = new byte[64];
        System.out.print("IP역순열 통과후:  ");
        for(i=0;i<64;i++){
            temp[i] = original[IP2[i]-1];
            System.out.print(temp[i]);
            if(i%8==7)
                System.out.print(" ");
        }
        System.out.println();
        return temp;
    }

    static byte[] Rounding(byte[] original,byte[] key) {

        byte[] nextTemp = new byte[64];
        byte[] left = new byte[32];
        byte[] right = new byte[32];
        byte[] tempExpansion = new byte[48];
        byte[] temp = new byte[32];
        byte[] rightTemp = new byte[32];
        int sTemp;

        for(i=0;i<32;i++) {
            left[i]=original[i];
            right[i]=original[i+32];
            temp[i] = right[i];
        }

        System.out.print("32비트를 48비트로 확장 순열후: ");
        for(i=0;i<48;i++) {
            tempExpansion[i] = right[E[i]-1];
            System.out.print(tempExpansion[i]);
            if(i%8==7)
                System.out.print(" ");
        }
        System.out.println();
        System.out.println("오른쪽비트와 키값이랑  XOR후 : ");
        for(i=0;i<48;i++) {
            tempExpansion[i] = (byte)(tempExpansion[i]^key[i]);
            System.out.print(tempExpansion[i]);
            if(i%8==7)
                System.out.print("  ");
        }
        System.out.println();


        for(j=0;j<8;j++){

            int row = 2*tempExpansion[j*6] + tempExpansion[j*6+5];

            int column = 8*tempExpansion[j*6+1] + 4*tempExpansion[j*6+2]+
                    2*tempExpansion[j*6+3] + tempExpansion[j*6+4];


            sTemp = S[j][16*row+column];


            if((sTemp & 8) == 8)
                right[j*4] = 1;
            else right[j*4]=0;

            if((sTemp & 4) == 4)
                right[j*4+1] = 1;
            else right[j*4+1]=0;

            if((sTemp & 2) == 2)
                right[j*4+2] = 1;
            else right[j*4+2]=0;

            if((sTemp & 1) == 1)
                right[j*4+3] = 1;
            else right[j*4+3]=0;

        }


        System.out.print("S-box통과후 : ");
        for(i=0;i<32;i++){
            System.out.print(right[i]);
            if(i%8==7)
                System.out.print("  ");
        }
        System.out.println();


        System.out.print("P함수통과후 : ");
        for(i=0;i<32;i++) {
            nextTemp[i] = temp[i];
            rightTemp[i] = right[P[i]-1];
            System.out.print(rightTemp[i]);
            if(i%8==7)
                System.out.print(" ");
        }
        System.out.println();



        System.out.print("Li-1 과 F함수수행결과 XOR후 : ");
        for(i=0;i<32;i++) {
            left[i] = (byte)(left[i]^rightTemp[i]);
            nextTemp[i+32] = left[i];
            System.out.print(left[i]);
            if(i%8==7)
                System.out.print(" ");
        }
        System.out.println();
        return nextTemp;
    }


    static byte[] swaping(byte[] temp) {
        byte[] right = new byte[32];
        byte[] left = new byte[32];


        for(i=0;i<32;i++) {

            left[i] = temp[i];

            right[i] = temp[i+32];
        }

        for(i=0;i<32;i++) {
            temp[i] = right[i];
            temp[i+32] = left[i];
        }
        System.out.println("32비트 스왑후");
        System.out.print("왼쪽 32비트 : ");
        for(i=0;i<32;i++) {
            System.out.print(temp[i]);
            if(i%8==7)
                System.out.print("  ");
        }
        System.out.println();

        System.out.print("오른쪽 32비트 : ");
        for(i=0;i<32;i++) {
            System.out.print(temp[i+32]);
            if(i%8==7)
                System.out.print("  ");
        }
        System.out.println();

        return temp;
    }

}
