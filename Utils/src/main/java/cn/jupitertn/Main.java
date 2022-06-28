package cn.jupitertn;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        String fileName = "D:\\DESKTOP\\answer.txt";
        String fileName = "D:\\GitWorkSpace\\JavaWebSpace\\Utils\\source.txt";
        readUseScanner(fileName);
    }

    private static void readUseScanner(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
//        int num = 19;
        int i = 1;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
//            String[] s = line.split(" ");
//            String sql="INSERT INTO question VALUES(null,'"+s[1]+"',"+s[0]+")";
//            String sql1 = "INSERT INTO answer VALUES(null,'" + s[1] + "'," + num + "," + s[0] + ")";
            Integer insert=0;
            switch (i) {
                case 1: {
                    for (int j = 1; j <= 15; j++) {
                        String sql1 = "INSERT INTO source VALUES(null,'" + line + "'," + j + ")";
                         insert = JDBCUtils.insert(sql1);
                    }
                }
                break;
                case 2: {
                    for (int j = 16; j <= 40; j++) {
                        String sql1 = "INSERT INTO source VALUES(null,'" + line + "'," + j + ")";
                         insert = JDBCUtils.insert(sql1);
                    }
                }
                break;
                case 3: {
                    for (int j = 41; j <= 60; j++) {
                        String sql1 = "INSERT INTO source VALUES(null,'" + line + "'," + j + ")";
                         insert = JDBCUtils.insert(sql1);
                    }
                }
                break;
                case 4: {
                    for (int j = 61; j <= 90; j++) {
                        String sql1 = "INSERT INTO source VALUES(null,'" + line + "'," + j + ")";
                         insert = JDBCUtils.insert(sql1);
                    }
                }
                break;
            }
//            if (i < 3) {
//                i++;
//            } else {
//                num++;
//                i = 0;
//            }
            i++;
            System.out.println(insert == 1 ? "成功!" : "失败");
        }
        scanner.close();
    }
}