import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
public class UrlClassExample {
public static void main(String[] args) {
try {
URL url = new URL("https://genesistls.com");
URLConnection urlconnect = url.openConnection();
InputStream ins = urlconnect.getInputStream();
int i;
while((i=ins.read())!=-1){
System.out.print((char)i);
}
} catch (Exception e) {
e.printStackTrace();
}
}
}