package java_type;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        List<String> students = new ArrayList(){{
            add("lihua");
            add("liming");
            add("ligoudan");
        }};

        students.forEach((String stu)->{System.out.println("name is " + stu);});

    }


}
