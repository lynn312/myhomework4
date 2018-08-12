import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
 
public class TransClient {
  public static void main(String[] args) throws IOException {
    /**
     * 1、创建Socket客户端对象
     * 2、获取键盘录入的数据
     * 3、将录入的信息发送给Socket输出流
     * 4、读取服务端的数据并返回的大写数据
     */
 
    // 1、创建Socket客户端对象
    Socket s = new Socket("192.168.1.100", 10004);
 
    // 2、获取键盘录入
    BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
 
    // 3、Socket输出流
    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
 
    // 4、Socket输入流，读取服务端的数据并返回的大写数据
    BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
 
    String line = null;
 
    while ((line = bufr.readLine()) != null) {
 
      if ("over".equals(line))
        break;
      out.println(line);
 
      // 读取服务端返回的一行大写数据
      String upperStr = bufIn.readLine();
      System.out.println(upperStr);
    }
    s.close();
  }
}