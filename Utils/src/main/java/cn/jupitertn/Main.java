package cn.jupitertn;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\DESKTOP\\answer.txt";
        readUseScanner(fileName);
    }

    private static void readUseScanner(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        int num=19;
        int i=0;
        while (scanner.hasNextLine()){
            String line=scanner.nextLine();
            System.out.println(line);
            String[] s = line.split(" ");
//            String sql="INSERT INTO question VALUES(null,'"+s[1]+"',"+s[0]+")";
            String sql1="INSERT INTO answer VALUES(null,'"+s[1]+"',"+num+","+s[0]+")";
            Integer insert = JDBCUtils.insert(sql1);
            if (i < 3) {
                i++;
            }else {
                num++;
                i=0;
            }
            System.out.println(insert);
        }
        scanner.close();
    }
}