package com.company;

import java.util.ArrayList;
import java.util.List;

public class Text implements Result{

    public class Count_Char{
        char character;
        int count;

        public Count_Char(char character, int count) {
            this.character = character;
            this.count = count;
        }

        public String Str_out(){
            StringBuilder str = new StringBuilder();
            str.append("Character: " + character + " - " + count + " times");
            return str.toString();
        }
    }

    @Override
    public String getResult() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < ch_arr.size(); i++) {
            str.append(ch_arr.get(i).Str_out() + "\n");
        }
        return str.toString();
    }

    private char[] array;
    private List <Count_Char> ch_arr = new ArrayList<Count_Char>();

    Text(String str){
        str = str.replaceAll(" ", "");
        array = str.toCharArray();
    }

    Text(List<Character> list){
        //array = list.toString().toCharArray();
        array = new char[list.size()];
        for(int i = 0; i < array.length; i++)
            array[i] = list.get(i);
    }

    Text(char[] arr){
        array = arr;
    }

    public void Calculate(){
        for (int i = 0; i < array.length; i++){
            if (ch_arr.size() == 0) {
                Count_Char new_char = new Count_Char(array[i], 1);
                ch_arr.add(new_char);
                continue;
            }
            for (int j = 0; j < ch_arr.size(); j++){
                if (ch_arr.get(j).character == array[i]){
                    ch_arr.get(j).count++;
                    break;
                }
                else if (j == ch_arr.size() - 1){
                    Count_Char new_char = new Count_Char(array[i], 1);
                    ch_arr.add(new_char);
                    break;
                }
            }
        }
    }
}
