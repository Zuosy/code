package java_type;

public class MainApp {

    public static void main(String args[]) {
        String str = "a";
        long time = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            str += "c";
        }
        System.out.println("加号所花费的时间：");
        System.out.println(System.currentTimeMillis()-time);
        
        String str2 = "a";
        time = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            str2.concat("c");
        }
        System.out.println("cancat方法所花费的时间：");
        System.out.println(System.currentTimeMillis()-time);
        time = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder("a");
        for (int i = 0; i < 50000; i++) {
            stringBuilder.append("c");
        }
        String str3 = stringBuilder.toString();
        System.out.println("StringBuilder的append方法：");
        System.out.println(System.currentTimeMillis()-time);

        String _str = "a[%s]";
        String _str2 = _str;
        time = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
             String.format(_str, "c");
             _str = _str2;
        }
        System.out.println("format 方法:");
        System.out.println(System.currentTimeMillis()-time);
    }


}

class Teather {
    String name;
    
    @Override
    public String toString() {
        return name;
    }
}
