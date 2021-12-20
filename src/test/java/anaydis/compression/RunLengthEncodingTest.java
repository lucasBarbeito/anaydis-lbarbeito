package anaydis.compression;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class RunLengthEncodingTest {
    @Test
    public void RLETest() throws IOException {
        final String text = "abrc";
        InputStream input = new ByteArrayInputStream(text.getBytes());
        ByteArrayOutputStream encoded = new ByteArrayOutputStream();
        ByteArrayOutputStream decoded = new ByteArrayOutputStream();
        final RunLengthEncoding rle = new RunLengthEncoding();
        rle.encode(input, encoded);
        final byte[] output = encoded.toByteArray();
        System.out.println(Arrays.toString(output));
        rle.decode(new ByteArrayInputStream(encoded.toByteArray()), decoded);
        assertArrayEquals(text.getBytes(), decoded.toByteArray());
    }
}
