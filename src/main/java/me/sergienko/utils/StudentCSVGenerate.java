/**
 * Created by Роман on 23.05.2017.
 * Generate and write to csv file  random student
 * Parametrs
 * args[0] - path to *.csv file
 * args[1] - Number of students to generate
 */
package me.sergienko.utils;


import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class StudentCSVGenerate {

    public static List<String> maleNames = Arrays.asList("Андрей", "Глеб", "Константин", "Вениамин", "Денис", "Шарль",
            "Абрам", "Руслан", "Юрий", "Кирилл", "Борис", "Артем", "Всеволод", "Один", "Федор");
    public static List<String> maleSurNames = Arrays.asList("Петров", "Пивоваров", "Алексеев", "Михайлов", "Окшаньский",
            "Смирнов", "Григорьев", "Соколов", "Бутылкин", "Фёдоров", "Павлов", "Грозный", "Веселов", "Ким", "Непейпиво");
    public static List<String> femaleNames = Arrays.asList("Земфира", "Марина", "Елизавета", "Вероника", "Лидия",
            "Яна", "Любовь", "Дарья", "Ирина", "Моника");
    public static List<String> femaleSurNames = Arrays.asList("Капустина", "Осипова", "Путинцева", "Белова",
            "Горбунова", "Борисова", "Цветкова", "Орлова", "Федорова", "Ильина");

    public static int id = 1;

    public static void main(String[] args) throws IOException, ParseException {

        StudentCSVGenerate studentCSVGenerate = new StudentCSVGenerate();

        String filename = "mytest.csv";
        int studentAmount = 1000;


        try (FileWriter fw = new FileWriter(filename)) {

            for (int i = 0; i < studentAmount; i++) {
                String entry = studentCSVGenerate.generateStudent();
                fw.write(entry);
            }
        }
    }

    /**
     * Returns random fields of student.
     */
    private String generateStudent() throws ParseException {
        String name;
        String surname;
        Random rnd = new Random();
        //generate random gender of students and name, surname
        if (rnd.nextBoolean()) {
            name = maleNames.get(rnd.nextInt(maleNames.size()));
            surname = maleSurNames.get(rnd.nextInt(maleSurNames.size()));
        } else {
            name = femaleNames.get(rnd.nextInt(femaleNames.size()));
            surname = femaleSurNames.get(rnd.nextInt(femaleSurNames.size()));
        }
        //generate number of group
        int groupId = 100 + rnd.nextInt(50);
        //generate rating Ege
        double ratingEGE = 60 + rnd.nextDouble() * 40.0;
        //generate random date between 1990/0/0 and current date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD");
        Date d1 = simpleDateFormat.parse("1990-00-00");
        Date currentDate = new Date();
        long tmp = currentDate.getTime() - d1.getTime();
        Date enrolmentDate = new Date(d1.getTime() + ThreadLocalRandom.current().nextLong(tmp));

        return String.format("%d;%s;%s;%.2f;%tF\n", groupId, name, surname, ratingEGE, enrolmentDate);
    }


}
