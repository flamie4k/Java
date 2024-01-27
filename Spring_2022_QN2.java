import java.io.FileOutputStream;
import java.io.IOException;
public class Spring_2022_QN2 {
/*WAP to write bytes of data in a file called javaExam. */
    public static void main(String[] args) {
        try{
            FileOutputStream writer = new FileOutputStream("Write.bin");
            byte[] data = {0X6F, 0X1C, 0X21};
            writer.write(data);
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
