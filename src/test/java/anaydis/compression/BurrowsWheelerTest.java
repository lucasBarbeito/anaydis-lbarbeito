package anaydis.compression;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class BurrowsWheelerTest {

    @Test
    public void burrowsWheelerTest() throws IOException {
        final String text = "DRDOBBS";
        InputStream input = new ByteArrayInputStream(text.getBytes());
        ByteArrayOutputStream encoded = new ByteArrayOutputStream();
        ByteArrayOutputStream decoded = new ByteArrayOutputStream();
        final BurrowsWheeler burrowsWheeler = new BurrowsWheeler();
        burrowsWheeler.encode(input, encoded);

        System.out.println(Arrays.toString(encoded.toByteArray()));

        burrowsWheeler.decode(new ByteArrayInputStream(encoded.toByteArray()), decoded);
        assertArrayEquals(text.getBytes(), decoded.toByteArray());
    }
}
