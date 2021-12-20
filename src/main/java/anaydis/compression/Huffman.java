package anaydis.compression;

import anaydis.bit.Bits;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;

public class Huffman implements Compressor{

    private static class Node{

        private char aChar;
        private final int freq;
        private Node left, right;

        Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        Node(char aChar, int freq){
            this.aChar = aChar;
            this.freq = freq;
        }

        public boolean isLeaf(){
            return left == null && right == null;
        }
    }

    private final Map<Character, Bits> codes = new HashMap<>();
    private final List<Character> characters = new ArrayList<>();
    private final List<Integer> frequencies = new ArrayList<>();

    @Override
    public void encode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        BufferedInputStream buffer = new BufferedInputStream(inputStream);
        buffer.mark(Integer.MAX_VALUE);
        charFrequencies(buffer);
        buildTrie();
        buffer.reset();
        int reader = buffer.read();
        while (reader != -1) {
            if (codes.get((char) reader) != null){
                Bits bits = codes.get((char) reader);
                bits.writeInto(outputStream);
            }
            reader = buffer.read();
        }
    }

    private void buildTrie() {
        PriorityQueue<Node> priorityQueue = buildQueue();
        Node parent = null;
        while (priorityQueue.size() > 1){
            Node left = priorityQueue.peek();
            priorityQueue.poll();
            Node right = priorityQueue.peek();
            priorityQueue.poll();
            assert right != null;
            parent = new Node(left.freq + right.freq, left, right);
            priorityQueue.offer(parent);
        }
        buildCode(parent, "");
        priorityQueue.poll();
    }

    private void buildCode(Node node, String word){
        if (node != null){
            if (node.isLeaf()){
                Bits bits = new Bits();
                for (int i = 0; i < word.length(); i++) {
                    bits.add(word.charAt(i) != '0');
                }
                codes.put(node.aChar, bits);
                return;
            }
        }
        assert node != null;
        buildCode(node.left, word + '0');
        buildCode(node.right, word + '1');
    }

    private PriorityQueue<Node> buildQueue() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.freq));
        for (int i = 0; i < characters.size(); i++) {
            Node node = new Node(characters.get(i), frequencies.get(i));
            priorityQueue.add(node);
        }
        return priorityQueue;
    }

    private void charFrequencies(InputStream inputStream) throws IOException {
        int reader = inputStream.read();
        while(reader != -1){
            if (!characters.contains((char) reader)){
                characters.add((char) reader);
                frequencies.add(1);
            }else{
                frequencies.set(characters.indexOf((char) reader), frequencies.get(characters.indexOf((char) reader)) + 1);
            }
            reader = inputStream.read();
        }
    }

    @Override
    public void decode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        int reader = inputStream.read();
        while (reader != -1){
            int length = reader;
            StringBuilder string = new StringBuilder();
            int aux;
            if (length % 8 == 0){
                aux = length / 8;
            }else{
                aux = length / 8 + 1;
            }
            for (int i = 0; i < aux; i++) {
                reader = inputStream.read();
                StringBuilder string2 = new StringBuilder(Integer.toBinaryString(reader));
                while(string2.length() < 8){
                    string2.insert(0, "0");
                }
                if (i == aux - 1){
                    if (length % 8 != 0){
                        string.append(string2.substring(0, length % 8));
                    }else{
                        string.append(string2.substring(0, 8));
                    }
                }else{
                    string.append(string2);
                }
            }
            Bits bits = new Bits();
            for (int i = 0; i < length; i++) {
                bits.add(string.charAt(i) != '0');
            }
            for (Map.Entry<Character, Bits> entry : codes.entrySet()){
                if (entry.getValue().getLength() == bits.getLength() && entry.getValue().getValue() == bits.getValue()){
                    outputStream.write(entry.getKey());
                    break;
                }
            }
            reader = inputStream.read();
        }
    }
}
