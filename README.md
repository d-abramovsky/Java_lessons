# Класс Binary для перевода десятичных чисел в двоичную систему счисления. 
## В классе реализованы различные методы. Рассмотрим приватные методы класса Binary.
### Метод bincode принимает int и возвращает двоичную 8-битную строковую запись принятого числа.
``` Java
private static String bincode(int num){
        String res = "";
            while (num > 0) {
                res = num % 2 + res;
                num /= 2;
            }
            int len = 8 - res.length();
            return ("0".repeat(len)) + res;
        }
```
### Метод invert_num принимает на вход строку и возвращает ее инвертированное значение.
``` Java
private static String invert_num(String num){
    String invert_str = "";
        while (num.length()>0){
            if (num.charAt(0) == '1'){
                invert_str += "0";
            } else{
                invert_str += "1";
            }
            num = num.substring(1);
        }
        return invert_str;
```
### Метод plus_bin добавляет единицу к двоичной записи числа. 
``` Java
private static String plus_bin(String str){
    return Integer.toBinaryString(Integer.parseInt(str, 2) + Integer.parseInt("00000001", 2));
}
```
## Публичные методы класса Binary.
### Метод bin отвечает за обработку полученного числа. Если оно положительное или равно 0, то число переводится в двоичную запись. 
#### Если число отрицательное:
- Оно переводится в двоичную систему счисления
- Каждый знак двоичной записи инвертируется
- К полученному числу добавляется 1
### После обработки получется дополнительный код.
``` Java
  public static String bin(int num){
      String result;
      if ((num>=-128) && (num <=127)){
          if (num>=0) {
              result = bincode(num);
          }
          else{
              num = Math.abs(num);
              result = plus_bin(invert_num(bincode(num)));
          }
      }else{
          result = "Программа рассчитана на работу в диапазоне [-128,127]";
      }
      return result;
  }
```


