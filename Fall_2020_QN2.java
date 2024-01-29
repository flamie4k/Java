import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fall_2020_QN2 {
    String filePath = "Exam.txt";
    byte[] data = {0x1C, 0x1B, 0x1A, 0X1F};

    void writingBytes() {
        try (FileOutputStream writer = new FileOutputStream(filePath)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readingBytes() {
        try (FileInputStream reader = new FileInputStream(filePath)) {
            int bytesRead;
            byte[] buffer = new byte[1024];
            while ((bytesRead = reader.read(buffer)) != -1) {
                processBytes(buffer, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processBytes(byte[] buffer, int bytesRead) {
        // Example: Print each byte as a character
        for (int i = 0; i < bytesRead; i++) {
            char character = (char) buffer[i];
            System.out.print(character);
        }
    }

    public static void main(String[] args) {
        Fall_2020_QN2 program = new Fall_2020_QN2();
        program.writingBytes();
        program.readingBytes();
    }
}
