package HW4;

import java.io.IOException;
import java.util.*;

public class Main {

    //IOException 입출력시 지정한 파일이 시스템에 존재하지 않을때 사용 throws는 해당 클래스에서 예외가 발생하면 클래스에서 벗어난다는 뜻
    public static void main(String[] args) throws IOException {

        int[] stat = new int[256];
        FileReader f = new FileReader();
        StringBuffer sb = f.readFileLines("src//huffman.txt");


        String result = new String();

        for(int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            int c_index = (int)c;
            stat[c_index]++;
        }

        LinkedList<Symbol> syms = new LinkedList<Symbol>();

        for(int i = 0; i < 256; i++){
            Symbol s = new Symbol((char) i, stat[i]);
            syms.add(s);
        }

        Collections.sort(syms);

        Symbol root = null;

        //buildup huffman tree
        while(true){
            //pick two least freq nodes
            Symbol s1 = syms.removeFirst();
            if(syms.isEmpty()){
                root = s1;
                break;
            }
            Symbol s2 = syms.removeFirst();

            Symbol newNode = Symbol.buildUp(s1, s2);
            syms.add(newNode);
            Collections.sort(syms);
        }
        System.out.println("total freq: " + root.frequency);


        HashMap<Symbol, String> HuffmanTable = new HashMap<Symbol, String>();

        root.labeling("");

        Set<Symbol> keys = Symbol.HuffmanTable.keySet();
        Iterator<Symbol> iter = keys.iterator();
        String res = "";
        while(iter.hasNext()){

            Symbol s = iter.next();
            if(s.frequency == 0){
                continue;
            }
            res = res + s.codeWord;
            System.out.println(s);

        }


        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");

        System.out.println("encoding text: " + res);
        System.out.println("encoding text length: " + res.length());

        System.out.println("total freq: " + root.frequency);


        class Decoder{
            public  StringBuffer getDecodeMessage(StringBuffer sb, Symbol root){
                String result = "";

                Symbol n = root;
                for(int i = 0; i < sb.length(); i++){
                    char ch = sb.charAt(i);
                    if (ch == '0'){
                        n = n.left;
                    }
                    else {
                        n = n.right;
                    }
                    if (n.left == null){
                        result = result + n.ch;
                        n = root;
                    }
                }

                StringBuffer strResult = new StringBuffer();
                strResult.append(result);
                return strResult;
            }
        }

        StringBuffer sb2 = new StringBuffer();
        sb2.append(sb);
        Decoder decoder = new Decoder();
        decoder.getDecodeMessage(sb2 , root);

        StringBuffer sb3 = new StringBuffer();
        sb3.append(sb2);
        System.out.println(sb3);

    }
}