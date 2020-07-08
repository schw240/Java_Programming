package HW4;

import java.util.*;

class Symbol implements Comparable<Symbol> , Huffman_interface {
    char ch;
    int frequency;
    String codeWord;
    StringBuffer sb3 = new StringBuffer();


    static HashMap<Symbol , String> HuffmanTable = new HashMap<Symbol , String>();

    Symbol(char c , int freq){
        ch = c;
        frequency = freq;
        codeWord = "";

        left = null;
        right = null;
    }

    //compareTo는 두 스트링을 사전적 순서로 비교. 두 스트링이 같으면 0 , 현 스트링이 Symbol o 보다 먼저나오면 음수 아니면 양수
    @Override
    public int compareTo(Symbol o) {
        return this.frequency - o.frequency;
    }

    Symbol left;
    Symbol right;

    public static Symbol buildUp(Symbol cleft, Symbol cright){

        Symbol s = new Symbol((char)0, cleft.frequency + cright.frequency);

        s.left = cleft;
        s.right = cright;

        return s;
    }

    //라벨링
    public void labeling(String prefix){
        if(this.left != null){
            left.labeling(prefix + "0");
        }
        if(this.right != null){
            right.labeling(prefix + "1");
        }
        if(left == null && right == null){
            this.codeWord = prefix;
            HuffmanTable.put(this, this.codeWord);


        }
    }

    public String toString(){
        String str = "Symbol info ch: " + this.ch + "\t\tfreq: " + this.frequency +
                "\t\tcode: " + this.codeWord + "\t\tsize: " + this.codeWord.length();

        return str;
    }
}

