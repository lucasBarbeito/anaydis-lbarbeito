package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RunLengthEncoding implements Compressor{

    private final char scapeCharacter = (char) 27;

    @Override
    public void encode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        int reader = inputStream.read();
        char current = (char) reader;
        int counter = 0;
        outputStream.write(scapeCharacter);
        while(reader != -1){
            if (current == (char) reader){
                counter++;
            }else{
                outputStream.write(counter);
                outputStream.write(current);
                current = (char) reader;
                counter = 1;
                outputStream.write(scapeCharacter);
            }
            reader = inputStream.read();
        }
        if (counter > 0){
            outputStream.write(counter);
            outputStream.write(current);
        }
        inputStream.close();
        outputStream.close();
    }

    @Override
    public void decode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        while(inputStream.available() > 0){
            int aux = inputStream.read();
            if ((char) aux != scapeCharacter){
                char actual = (char) inputStream.read();
                for (int i = 0; i < aux; i++) {
                    outputStream.write(actual);
                }
            }
        }
    }
}
