import Academics.Course;
import Academics.Deparment;
import Academics.LICourse;
import Academics.NYCCourse;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;

public class IO {



    public static String readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            //checks if line exists and not end in file
            while ((line = br.readLine()) != null) {

                if (line == null) {
                    continue;
                }

                if (line.contains("Cycle D") || line.contains("Spring 2025")){
                    String[] data = line.split(",");
                    if(data.length <9 )
                        continue;
                    String[] data1 = data[1].split(" ");
                    String deparement = data1[0];
                    String code =  data1[1];

                    String courseName = data[2];
                    String professorName = data[3];
                    String day = data[4];
                    String date = data[5];
                    String timeStart = data[6];
                    String timeEnd = data[7];
                    String building = data[8];
                    String room = data[9].split("Rm. ")[0];
                    String campus =data[10];
                    System.out.println(deparement);

                    Course c;
                    if (campus.equals("New York City")){

                        c = new NYCCourse(deparement + " " + code, courseName, code, professorName, date);
                    }
                    else{

                         c = new LICourse(deparement + " " + code, courseName, code, professorName, date);
                    }


                    if (!Deparment.doesDeparmentExist(deparement)){
                        Deparment deparmentVar = new Deparment(deparement, new Course[]{c});
                    }
                    else{
                        for(Deparment d: Deparment.deparments){
                            if (d.getName().equals(deparement)){
                                d.appendCourses(c);
                            }
                        }
                    }




                }




            }
            return sb.toString();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";


    }
}
