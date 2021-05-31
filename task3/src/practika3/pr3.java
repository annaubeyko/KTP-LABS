package practika3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;


import static java.lang.Math.*;

public class pr3 {
    public static void main(String[] args) {
        System.out.println("Answer 1 = " );millionsRounding(new String[][] {{"Manila", "13923452"},{"Kuala Lumpur", "7996830"}, {"Jakarta", "10770487"}});
        System.out.println("Answer 2 = " + Arrays.toString(otherSides(12)));
        System.out.println("Answer 3 = " + rps("scissors", "scissors"));
        System.out.println("Answer 4 = " + warOfNumbers(new int[]{5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243}));
        System.out.println("Answer 5 = " + reverseCase("Happy Birthday"));
        System.out.println("Answer 6 = " + inat("oooo"));
        System.out.println("Answer 7 = " + doesBrickFit(1,1,1,1,1));
        System.out.println("Answer 8 = " + totalDistance(36.1, 8.6, 3, true));
        System.out.println("Answer 9 = " + mean(new int[] {1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3}));
        System.out.println("Answer 10 = " + parityAnalysis(3));
    }

    /*Метод для задачи 1 из блока 3/6
Учитывая массив городов и населения, верните массив, в котором все население округлено до ближайшего миллиона.*/
    public static void millionsRounding(String[][] str){
        int i = 0;
        while (i < str.length) {
            BigDecimal a = new BigDecimal(str[i][1]); // BigDecimal - большие числа
            a=a.divide(new BigDecimal("1000000")).setScale(0, RoundingMode.HALF_UP); // Этот метод принимает два параметра newScale,
            // которые используются для установки масштаба этого BigDecimal и roundingMode, чтобы установить значение округления результата.
            str[i][1]=a.toString();
            i++;
        }
        System.out.println(Arrays.deepToString(str)); // Этот метод предназначен для преобразования многомерных массивов в строки.
    }
    /*Метод для задачи 2 из блока 3/6
    * Учитывая самую короткую сторону треугольника 30° на 60° на 90°, вы должны найти другие 2 стороны
    * (верните самую длинную сторону, сторону средней длины).
    * Примечание:
- треугольники 30° на 60° на 90° всегда следуют этому правилу, скажем, самая короткая длина стороны равна x единицам, гипотенуза будет равна 2 единицам, а другая сторона будет
 равна x * root3 единицам.
- Результаты тестов округляются до 2 знаков после запятой.
- Верните результат в виде массива.
*/
    public static double[] otherSides(int a) {
        //Подсчет сторон
        int b = 2 * a;
        double c = a * sqrt(3);
        double cr; // для средней длины

        //Поиск максимального и среднего
        double maxst = max(c, max(a, b));
        double minst = min(c, min(a, b));
        if ((a == maxst && b == minst) || (b == maxst && a == minst)) {
            cr = c;
        } else {
            if ((a == maxst && c == minst) || (c == maxst && a == minst)) {
                cr = b;
            } else {
                cr = a;
            }
        }
        //Округление
       double scale=Math.pow(10,2);
        cr=Math.ceil(cr*scale)/scale; // округление в большую сторону
        return new double[]{maxst,cr};
    }
    /*Метод для задачи 3 из блока 3/6
    * Создайте функцию, имитирующую игру "камень, ножницы, бумага". Функция принимает входные данные обоих игроков (камень, ножницы или бумага), первый параметр от первого игрока,
    * второй от второго игрока. Функция возвращает результат как таковой:

"Игрок 1 выигрывает"
"Игрок 2 выигрывает"
"НИЧЬЯ" (если оба входа одинаковы)
Правила игры камень, ножницы, бумага, если не известны:

Оба игрока должны сказать одновременно "камень", "бумага" или "ножницы".
Камень бьет ножницы, бумага бьет камень, ножницы бьют бумагу.
*/
    public static String rps(String s, String g){
    if ((s.equals("rock") & g.equals("paper"))) return "Player 2 wins";
    if ((s.equals("paper") & g.equals("rock"))) return "Player 1 wins";
    if ((s.equals("scissors") & g.equals("rock"))) return "Player 2 wins";
    if ((s.equals("rock") & g.equals("scissors"))) return "Player 1 wins";
    if ((s.equals("scissors") & g.equals("paper"))) return "Player 1 wins";
    if ((s.equals("paper") & g.equals("scissors"))) return "Player 2 wins";
     return "TIE";
    }

    /*Метод для задачи 4 из блока 3/6
    * Идет великая война между четными и нечетными числами. Многие уже погибли в этой войне, и ваша задача-положить этому конец.
    *  должны определить, какая группа суммируется больше: четная или нечетная. Выигрывает большая группа.

Создайте функцию, которая берет массив целых чисел, суммирует четные и нечетные числа отдельно, а затем возвращает разницу между суммой четных и нечетных чисел.
*/
    public static int warOfNumbers(int[] war) {
        int chet = 0;
        int nechet =0;
        for (int j : war) {
            if (j % 2 == 0) chet += j;
            else nechet += j;
        }
        if (chet>nechet) return chet - nechet;
        else return nechet-chet;
    }

    /*Метод для задачи 5 из блока 3/6
    * Учитывая строку, создайте функцию для обратного обращения. Все буквы в нижнем регистре должны быть прописными, и наоборот.*/
    public static String reverseCase(String a) {
     StringBuilder a_caseReversed = new StringBuilder();
     for (char c : a.toCharArray()) {
         if (Character.isLowerCase(c))
     a_caseReversed.append(Character.toUpperCase(c));
     else
     a_caseReversed.append(Character.toLowerCase(c));}
     return a_caseReversed.toString();
    }

    /*Метод для задачи 6 из блока 3/6
    * Создайте функцию, которая принимает строку из одного слова и выполняет следующие действия:

Конкатенирует inator до конца, если слово заканчивается согласным, в противном случае вместо него конкатенирует  -inator
Добавляет длину слова исходного слова в конец, снабженный '000'.
*/
    public static String inat(String st){
       int k; // длина слова
        String s = null;
        char[] strToArray = st.toCharArray(); // Преобразуем строку st в массив символов (char)
        k=strToArray.length*1000;
        char[] vowels={'a','e','i','o','u','y'};
        for (char vowel : vowels) {
            if (vowel == strToArray[strToArray.length - 1]) // сравнивает последний символ с массивом volwes
            {
                s = st + "-" + "inator" + " "  + k;
            } else {
                s = st + "inator" + " " + k ;
            }
        }
        return s;
    }

    /*Метод для задачи 7 из блока 3/6
    * Напишите функцию, которая принимает три измерения кирпича: высоту(a), ширину(b) и глубину(c) и возвращает true,
    *  если этот кирпич может поместиться в отверстие с шириной(w) и высотой(h).
    * Примечание:
- Вы можете повернуть кирпич любой стороной к отверстию.
- Мы предполагаем, что кирпич подходит, если его размеры равны размерам отверстия (то есть размер кирпича должен быть меньше или равен размеру отверстия, а не строго меньше).
- Нельзя класть кирпич под неортогональным углом.
*/
    public static boolean doesBrickFit(int a, int b, int c, int w, int h)
    {return (((w>=a||w>=b)&&h>=c)||((w>=a||w>=c)&&h>=b)||((w>=b||w>=c)&&h>=a));}

    /*Метод для задачи 8 из блока 3/6
    * Напишите функцию, которая принимает топливо (литры), расход топлива (литры/100 км), пассажиров, кондиционер (логическое значение) и возвращает максимальное расстояние,
    *  которое может проехать автомобиль.
топливо-это количество литров топлива в топливном баке.
Расход топлива-это базовый расход топлива на 100 км (только с водителем внутри).
Каждый дополнительный пассажир увеличивает базовый расход топлива на 5%.
Если кондиционер включен, то его общий (не базовый) расход топлива увеличивается на 10%.
*/
    public static double totalDistance(double toplivo, double rashod,int passangers,boolean condey){
        rashod=passangers*rashod*0.05+rashod;
        if (condey) {rashod=rashod*1.1;}
        return toplivo/rashod*100;
    }

    /* Метод для задачи 9 из блока 3/6
Создайте функцию, которая принимает массив чисел и возвращает среднее значение (average) всех этих чисел.
     */
    public static double mean(int[] mass){
        OptionalDouble res = IntStream.of(mass).average(); //IntStream average () возвращает OptionalDouble,
        // описывающее среднее арифметическое элементов этого потока, или пустое необязательное значение, если этот поток пуст.
        return res.getAsDouble();}

   // OptionalDouble - объект-контейнер, используемый для хранения ненулевых объектов.

    /* Метод для задачи 10 из блока 3/6
Создайте функцию, которая принимает число в качестве входных данных и возвращает true, если сумма его цифр
 имеет ту же четность, что и все число. В противном случае верните false.
     */
    public static boolean parityAnalysis(int a){
        int sum=0;
        int b=a;
        while (a>0){
            sum=sum+a%10;
            a=a/10;
        }
        return b%2==sum%2;
    }
}