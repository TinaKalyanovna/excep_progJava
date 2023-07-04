package HW_3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class task_2 {
    public static boolean isAlpha(String s, String term) {
        if (s == null) {
            return false;
        }
        if (term == null){
            return true;
        }
        String myTerm = term.replaceAll("[\\[\\]]","");
        String[] myStr = myTerm.split("::");
        char[] myChar = myStr[0].replace("-", "").toCharArray();

        for (int i = 0; i < s.length(); i++)
        {
            boolean myCheck = true;
            char c = s.charAt(i);
            for (int j = 1; j < myChar.length; j+=2)
                if (c >= myChar[j-1] && c <= myChar[j]) {
                    myCheck = false;
                    break;
            }
            if (myCheck&& myStr.length > 1){
                for (int j = 0; j < myStr[1].length();j++){
                    char f = myStr[1].charAt(j);
                    if(c==f ||c == ' '){
                        myCheck = false;
                        break;
                    }
                }
            }
            if(myCheck) return false;
        }
        return true;
    }
    public static boolean isNumeric(String s ,boolean b) {
        if (s.chars().allMatch(Character::isDigit) && s.length() <= 13)
            return true;
        if (b) return false;
        throw new MyInvalidInputFormat("Неверный формат номера телефона ожидается в формате 7хххххххххх получено " + s);
    }
    public static boolean isDateValid(String inputDate,String DATE_FORMAT,boolean b) {
        String date = inputDate.replace(",",".");
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            if (b) return false;
            throw new MyInvalidInputFormat("Неверный формат даты ожидается дата типа dd.mm.yyyy получено " + date);
        }
    }
    public static String myDataParseLine (String name,int lengthElement,String oneMatch,String twoMatch,String threeMatch){
        if (isAlpha(name,oneMatch)){
            String [] myData = name.split(" ");
            StringBuilder strData = new StringBuilder();

            if (myData.length != lengthElement) throw new MyInvalidInputFormat("Неверный ввод данных нужно ввести 6 элементов через пробел" +
                    "Фамилия Имя Отчество Дата_рождения(dd.mm.yyyy) Номер_телефона(7хххххххххх) пол(m,f)\nвы ввели " + myData.length + "элементов");

            for (int i = 0; i < myData.length; i++){
                if (myData[i].length() > 1 && isAlpha(myData[i], twoMatch)){
                    if (i < 3)
                        strData.append(myData[i]).append(" ");
                    else
                        throw new MyInvalidInputFormat("Неверный ввод данных ожидается данные типа dd.mm.yyy получено "+myData[i]);
                }else if (i == 3 && isDateValid(myData[i], "dd.mm.yyyy",false))
                    strData.append(myData[i].replace(",",".").replace("-",".").replace("/",".")).append(" ");
                else if (i == 4 && isNumeric(myData[i], false))
                    strData.append(myData[i]).append(" ");
                else if (i == 5 && isAlpha(myData[i], threeMatch))
                    strData.append(myData[i]);
                else throw new MyInvalidInputFormat("Невереный ввод данных " + myData[i]);
            }
            return strData.toString();
        }
        throw new MyInvalidInputFormat("Недопустимый символ "+name.replaceAll(oneMatch.replace("[+]","*"), ""));
    }
    public static String myDataParse (String name,int lengthElement,String oneMatch,String twoMatch,String threeMatch){
        if (isAlpha(name,oneMatch)) {
            String[] myData = name.split(" ");
            ArrayList<String> strDataHuman = new ArrayList<>();
            String strDataBirthday = "", strDataPhoneNumber = "", strDataGender = "";

            if (myData.length != lengthElement) throw new MyInvalidInputFormat("Неверный ввод данных нужно ввести 6 элементов через пробел" +
                    "Фамилия Имя Отчество Дата_рождения(dd.mm.yyyy) Номер_телефона(7хххххххххх) пол(m,f)\nвы ввели " + myData.length + "элементов");

            for (String myStr : myData) {
                if (myStr.length() > 1) {
                    if (isAlpha(myStr,twoMatch)) {
                        if (strDataHuman.size() < 3) {
                            strDataHuman.add(myStr+" ");
                            continue;
                        }
                        throw new MyInvalidInputFormat("Неверный ввод данных ожидается ввод года рождения, телефона или гендера получено " + myStr);
                    }
                    if (isDateValid(myStr, "dd.mm.yyyy",true)) {
                        strDataBirthday = myStr.replace(",", ".").replace("-", ".").replace("/", ".") + " ";
                        continue;
                    }
                    if (isNumeric(myStr, true)) {
                        strDataPhoneNumber = myStr + " ";
                        continue;
                    }
                }
                if (isAlpha(myStr,threeMatch)) {
                    strDataGender = myStr.toLowerCase();
                    continue;
                }
                throw new MyInvalidInputFormat("Невереный ввод данных " + myStr);
            }
            if (!strDataBirthday.isEmpty() && !strDataPhoneNumber.isEmpty() && !strDataGender.isEmpty()) {
                strDataHuman.add(strDataBirthday);
                strDataHuman.add(strDataPhoneNumber);
                strDataHuman.add(strDataGender);
            }
            else {
                if (strDataBirthday.isEmpty()) {
                    throw new MyInvalidInputFormat("Ошибка введите дату рождение");
                }
                if (strDataPhoneNumber.isEmpty()) {
                    throw new MyInvalidInputFormat("Ошибка введите номер телефона");
                }
                throw new MyInvalidInputFormat("Ошибка введите пол");
            }
            return strDataHuman.toString();
        }
        throw new MyInvalidInputFormat("Недопустимый символ "+name.replaceAll(oneMatch, ""));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String myDataParse (String name){
        return myDataParse (name,6,"[a-zA-Zа-яА-Я0-9::.,/-]","[a-zA-Zа-яА-Я]","[::fmFM]");
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String myDataParseLine (String name){
        return myDataParseLine (name,6,"[a-zA-Zа-яА-Я0-9::.,/-]","[a-zA-Zа-яА-Я]","[::fmFM]");
    }
}
