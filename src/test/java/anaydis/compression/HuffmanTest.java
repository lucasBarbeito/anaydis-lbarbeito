package anaydis.compression;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertArrayEquals;

public class HuffmanTest {

    @Test
    public void huffmanTest() throws IOException {
        final String text = "ab";
        InputStream input = new ByteArrayInputStream(text.getBytes());
        ByteArrayOutputStream encoded = new ByteArrayOutputStream();
        ByteArrayOutputStream decoded = new ByteArrayOutputStream();
        //huffman.encode(new ByteArrayInputStream(text.getBytes()), encoded);
        final Huffman huffman = new Huffman();
        huffman.encode(input, encoded);
        final byte[] output = encoded.toByteArray();
        //System.out.println(Arrays.toString(output));

        huffman.decode(new ByteArrayInputStream(encoded.toByteArray()), decoded);
        assertArrayEquals(text.getBytes(), decoded.toByteArray());
    }
}
