import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
 
public class TransClient {
  public static void main(String[] args) throws IOException {
    /**
     * 1������Socket�ͻ��˶���
     * 2����ȡ����¼�������
     * 3����¼�����Ϣ���͸�Socket�����
     * 4����ȡ����˵����ݲ����صĴ�д����
     */
 
    // 1������Socket�ͻ��˶���
    Socket s = new Socket("192.168.1.100", 10004);
 
    // 2����ȡ����¼��
    BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
 
    // 3��Socket�����
    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
 
    // 4��Socket����������ȡ����˵����ݲ����صĴ�д����
    BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
 
    String line = null;
 
    while ((line = bufr.readLine()) != null) {
 
      if ("over".equals(line))
        break;
      out.println(line);
 
      // ��ȡ����˷��ص�һ�д�д����
      String upperStr = bufIn.readLine();
      System.out.println(upperStr);
    }
    s.close();
  }
}