package saikaUnit;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class  IO {

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static void printLog(Object s)
    {
        s=sdf.format(new Date())+"::"+s;
        System.out.println("[info]" + s);
    }
    public static void printSys(Object s)
    {
        s=sdf.format(new Date())+"::"+s;
        System.out.println("[System]" + s);
    }

    public static void printWarn(Object s)
    {
        s=sdf.format(new Date())+"::"+s;
        System.out.println("[Warning]" + s);
    }

    public static void printErr(Object s)
    {
        s=sdf.format(new Date())+"::"+s;
        System.out.println("[ERROR]" + s);
    }
    public static String input(File file)
    {
        try {
            InputStreamReader read= new InputStreamReader(new FileInputStream(file));
            BufferedReader reader=new BufferedReader(read);
            // String FileLocation = null;
            StringBuilder data = new StringBuilder();
            String s;
            while ((s=reader.readLine())!=null)
                data.append(s).append("\r\n");
            reader.close();
            return data.toString();
        } catch (Exception e) {
            return null;
        }
    }
//    public ArrayList<String> inputArray(String file)
//    {
//        ArrayList<String> ls=new ArrayList<>();
//        try {
//            InputStreamReader read= new InputStreamReader(new FileInputStream(file));
//            BufferedReader reader=new BufferedReader(read);
//            String s;
//            while ((s=reader.readLine())!=null)
//                ls.add(s);
//            reader.close();
//            return ls;
//        } catch (Exception e) {
//            return null;
//        }
//    }
    public static boolean output(String filename, String input, boolean append)
    {
        try {
            File file=new File(filename);
            Writer writer=new OutputStreamWriter(new FileOutputStream(file,append));
            writer.write(input);
            writer.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
