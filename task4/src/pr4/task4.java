package pr4;

import java.util.Arrays;
import java.util.Locale;

public class task4 {
    public static void main(String[] args) {
        System.out.println("Answer 1 = " + sevenBoom(new int[] {1, 2, 3, 4, 5, 6, 97}));
        System.out.println("Answer 2 = " + cons (new int[] {5, 6, 7, 8, 9, 13}));
        System.out.println("Answer 3 = " + unmix("hTsii  s aimex dpus rtni.g"));
        System.out.println("Answer 4 = " + noYelling("Oh my goodness!!!"));
        System.out.println("Answer 5 = " + xPronounce("OMG x box unboxing video x D") );
        System.out.println("Answer 6 = " + largestGap(new int[] {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5}));
        System.out.println("Answer 7 = " + raznitsa(832));
       // System.out.println("Answer 8 = " + commonLastVowel("Watch the characters dance!"));
        System.out.println("Answer 9 = " + memeSum(26, 39));
        System.out.println("Answer 10 = " + unrepeated("hello"));
    }
// Метод для задачи 1 из task4
    public static String  sevenBoom (int[] seven)
    { int a = 0;
        String s;
    for (int i: seven){
        s = Integer.toString(i); // число в строку
        if (s.contains("7"))
        { a +=1;
        }}
    if (a>0) return "BOOM!";
    else return "there is no 7 in the array";
    }

// Метод для задачи 2 из task4
    public static boolean cons(int[] sort){
        boolean k = false;
        Arrays.sort(sort); // класс arrays, метод сорт
       for(int i =1; i < sort.length;i++){
           k = sort[i] - sort[i - 1] == 1;
       }
        return k;
    }

// Метод для задачи 3 из task4
    public static String unmix(String mix){
        char obm;
        char[] a = mix.toCharArray();
        for( int i = 0; i<a.length; i+=2){
        obm = a[i];
        a[i] = a[i+1];
        a[i+1]=obm;
        }
        return String.valueOf(a); //возвращает строковое представление int аргумента
    }

// Метод для задачи 4 из task4
    public static String noYelling(String yell){
        while (yell.endsWith("!!") || yell.endsWith("??")) {
            yell = yell.substring(0, yell.length() - 1); // удаление последнего элемента строки
        }
        return yell;
    }

// Метод для задачи 5 из task4
public static String xPronounce(String x) {
    x = x.replaceAll("\sx\s", " ecks ");
    x = x.replaceAll("\sx", " z");
    x = x.replaceAll("x", "cks");
        return x;
}
// Метод для задачи 6 из task4
    public static int largestGap (int[] gap){
        Arrays.sort(gap);
        int r = 0;
        for(int i = 0; i< gap.length - 1 ;i++)
        if ((gap[i+1] - gap[i])>r)
            r = gap[i+1] - gap[i];
        return r;
    }
// Метод для задачи 7 из task4
public static int raznitsa(int t) {
    String k = String.valueOf(t); // int -> string
    StringBuilder result = new StringBuilder();
    char[] b = k.toCharArray();
    for (int i = b.length-1; i >= 0; i--) { //запись числа в обратном порядке
        result.append(b[i]); // перепись
    }
    int res = Integer.parseInt(result.toString().trim()); //string ->int, trim удаляет пробелы
    return t - res;
}

// Метод для задачи 8 из task4
  /*  public static char commonLastVowel(String str){

        int [] k = new int [5];
        String[] words = str.split(" ");

        for (int i = 0; i< words.length-1; i++){
            if (Character.isLetter(words[i].charAt(words[i].length()-1))){
                if (isVowel(words[i].charAt(words[i].length()-1))!=-1){
                    k[isVowel(words[i].charAt(words[i].length()-1))]+=1;
                }
            }
            else {
                if (isVowel(words[i].charAt(words[i].length()-2))!=-1){
                    k[isVowel(words[i].charAt(words[i].length()-2))]+=1;
            }
        }
        int max = 0;
            int m = -1;
            for (int a : k){
            if (k[a] > max)
            {max = k[a];
            m = a;}
            }
        }
        String isVowel = "aeiouy";
        return  isVowel.charAt(m);
    } */

// Метод для задачи 9 из task4
    public static int memeSum(int a1, int a2){
        int len = Math.max(String.valueOf(a1).length(),String.valueOf(a2).length());
        String w  = "";
        for (int i = len - 1; i>= 0 ; i--){
            w = (a1 % 10 + a2 % 10) + w;
            a1 /=10;
            a2 /=10;
        }
        return Integer.parseInt(w);
    }

// Метод для задачи 10 из task4
public static String unrepeated (String str){
int l = str.length();
StringBuilder rez = new StringBuilder();
for(int i=0; i< l; i++){
    if (!rez.toString().contains(String.valueOf(str.charAt(i)))) //добавление неповторяющейся буквы
        rez.append(str.charAt(i));
}
    return rez.toString();
}
}

