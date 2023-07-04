package HW_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class task_1 {
    public static String isFileExists(File[] listFiles,String startsWith, String endsWith){
        String fileName;
        for (var file : listFiles) {
            fileName = file.getName();
            if (fileName.startsWith(startsWith) && fileName.endsWith(endsWith)) {
                return fileName;
            }
        }
        return "";
    }
    public static void myWriter(String lineToWrite) throws IOException{
        if (lineToWrite == null){
            throw new MyInvalidInputFormat("Метод myWriter получил пустой объект");
        }

        File[] files = new File(new File("").getAbsolutePath()).listFiles();
        String myLine = lineToWrite.toString().replaceAll(",",";");
        String[] temp = Arrays.copyOfRange(myLine.split(";"),0,4);

        String nameFile = temp[0]+".txt";
        for (int i = 0; i < 3; i++){
            for (int j =0; j < temp.length-1; j++){
                String tmp = isFileExists(files,temp[i].substring(0,temp[i].length()-i),".txt");
                if (!tmp.isEmpty()){
                    nameFile = tmp;
                    i = 3;
                    break;
                }
            }
        }

        try(BufferedWriter fw = new BufferedWriter(new FileWriter(nameFile,true));
            Scanner fr = new Scanner(new FileReader(nameFile))) {

            while (fr.hasNext()){
                int count = 0;
                for (var i: fr.nextLine().split(";")){
                    for (var j : temp){
                        if (i.equals(j)) {
                            count++;
                            break;
                        }
                    }
                }
                if(count >= 4) {
                    System.out.println("Такая запись " + myLine + " уже существует");
                    return;
                }
            }
            fw.write(myLine+"\n");
        }
    }
    public static void main(String[] args) {
        String lastName = null;
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите ФИО, дата рождения в формате dd.mm.yyyy, номер телефона только цифры без знаков" +
                    "до 13 цифр, пол f-женский m-мужской");
            lastName = MyHumanDataBase.myDataParse(in.nextLine()).replaceAll("[\\[\\] ]", "");
            myWriter(lastName);
        }catch (MyInvalidInputFormat e){
            e.printMessage();
        }catch (IOException e){
            System.out.println("Что то пошло не так "+e.getMessage());
        }
        System.out.println(lastName);
    }
}
