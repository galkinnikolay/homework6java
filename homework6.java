/*
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре 
будут повторяющиеся имена с разными телефонами, 
их необходимо считать, как одного человека с разными телефонами. 
Вывод должен быть отсортирован по убыванию числа телефонов.
Пример:
Пастухов 1254658
Пастухов 1365489
Пастухов 5469871
Георгиевич 45689
Георгиевич 96547
Работягин 945628
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class homework6 {
    
    public static void printData(Map<String, ArrayList<Integer>> map, String name){
        if(!map.containsKey(name)) return;
        ArrayList<Integer> phones = map.get(name);
        for(int one : phones)
            System.out.printf(name + " " + one + System.lineSeparator());
    }
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> map = new HashMap<>(); 

        String[] source = {"Пастухов 1254658",
        "Пастухов 1365489",
        "Пастухов 5469871",
        "Георгиевич 45689",
        "Георгиевич 96547",
        "Работягин 945628"};

        for(String one : source){
            String[] splitted = one.split(" ");
            String Name = splitted[0]; 
            int Phone = Integer.parseInt(splitted[1]);

            if(map.containsKey(Name)){
                ArrayList<Integer> phones = map.get(Name);
                for(int phone : phones)
                    if(Phone==phone)
                        continue;                                   
                phones.add(Phone);
                Collections.sort(phones);
                map.put(Name, phones);                
            }else{ 
                ArrayList<Integer> phones = new  ArrayList<Integer>();
                phones.add(Phone);
                map.put(Name, phones);              
            }
        }

        Set<String> keyset  = map.keySet();    
        while(!keyset.isEmpty()){
            int max=0; String smax="";
            for (String s : keyset) {
                if(map.get(s).size() > max){
                    max = map.get(s).size();
                    smax = s;
                }
            }  
            printData(map, smax);
            keyset.remove(smax);
        }
    }
}