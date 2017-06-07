package me.sergienko.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;


public class StudentCSVGenerator {

    private static List<String> maleNames = Arrays.asList("Андрей", "Глеб", "Константин", "Вениамин", "Денис", "Шарль",
            "Абрам", "Руслан", "Юрий", "Кирилл", "Борис", "Артем", "Всеволод", "Один", "Федор");
    private static List<String> maleSurNames = Arrays.asList("Петров", "Пивоваров", "Алексеев", "Михайлов", "Окшаньский",
            "Смирнов", "Григорьев", "Соколов", "Бутылкин", "Фёдоров", "Павлов", "Грозный", "Веселов", "Ким", "Непейпиво");
    private static List<String> femaleNames = Arrays.asList("Земфира", "Марина", "Елизавета", "Вероника", "Лидия",
            "Яна", "Любовь", "Дарья", "Ирина", "Моника");
    private static List<String> femaleSurNames = Arrays.asList("Капустина", "Осипова", "Путинцева", "Белова",
            "Горбунова", "Борисова", "Цветкова", "Орлова", "Федорова", "Ильина");

    private int id = 1; //for generate primary key for db

    public static void main(String[] args) throws IOException, ParseException {

        StudentCSVGenerator generatorStudentInCSV = new StudentCSVGenerator();

        String filename = args[0];
        int studentAmount = Integer.parseInt(args[1]);


        try (FileWriter fw = new FileWriter(filename)) {

            for (int i = 0; i < studentAmount; i++) {
                String entry = generatorStudentInCSV.generateStudent();
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
        //generate random date between 1990/0/0 and 2016
        GregorianCalendar gregorianCalendar = new GregorianCalendar(1990 + rnd.nextInt(26), rnd.nextInt(11), rnd.nextInt(28));
        Date enrolmentDate = gregorianCalendar.getTime();

        return String.format(Locale.ROOT, "%d;%d;%s;%s;%.2f;%tF\n", id++, groupId, name, surname, ratingEGE, enrolmentDate);
    }


}
