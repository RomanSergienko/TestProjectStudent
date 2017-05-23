package utils;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.Random;


/**
 * Created by Роман on 23.05.2017.
 * Generate and write to csv file  random student
 * Students info
 *
 */
public class StudentCSVGenerate {
    public static void main(String[] args) {

        StudentCSVGenerate studentCSVGenerate =  new StudentCSVGenerate();

        String filename = args[0];
        int studentAmount  = Integer.parseInt(args[1]);


        try {
            FileOutputStream out = new FileOutputStream(filename);
            for (int i = 0; i<studentAmount; i++)
            {
                String entry = studentCSVGenerate.generateStudent();
                out.write(entry.getBytes());
            }

            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String generateStudent() {
        String name;
        String surname;
        Random rnd = new Random();
        if (rnd.nextBoolean())      //generate random gender of students
        {
            name = PatternTemplates.arrayOfMaleName.get((int)(Math.random()*(PatternTemplates.arrayOfMaleName.size())));
            surname = PatternTemplates.arrayOfMaleSurName.get((int)(Math.random()*(PatternTemplates.arrayOfMaleSurName.size())));
        }else {
            name = PatternTemplates.arrayOfFemaleName.get((int)(Math.random()*(PatternTemplates.arrayOfFemaleName.size())));
            surname = PatternTemplates.arrayOfFemaleSurName.get((int)(Math.random()*(PatternTemplates.arrayOfFemaleSurName.size())));
        }
        int groupId = (int)(100 + Math.random()*50);//generate number of group

        String ratingEGE= String.format("%,2f", (60 + Math.random()*40));  //  generate rating
        Date date = new Date(Math.abs(System.currentTimeMillis() - rnd.nextLong()));

        return groupId + ";" + name + ";" + surname + ";" + date + ";" + ratingEGE + "\n";
    }



}
