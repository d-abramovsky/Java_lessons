public class Binary {
        private static String bincode(int num){
            String res = "";
            while (num > 0) {
                res = num % 2 + res;
                num /= 2;
            }
            int len = 8 - res.length();
            return ("0".repeat(len)) + res;
        }
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
        }
        private static String plus_bin(String str){
            return Integer.toBinaryString(Integer.parseInt(str, 2) + Integer.parseInt("00000001", 2));
        }
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
    }

