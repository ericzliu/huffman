import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppMain {

    List<Symbol> readSymbol(String path) throws IOException {
        List<Symbol> result = new ArrayList<>();
        Scanner scanner = new Scanner(Paths.get(path));
        int symNumber = scanner.nextInt();
        for (int i = 0; i < symNumber; i++) {
            int symWeight = scanner.nextInt();
            Symbol symbol = new Symbol(i + 1, symWeight);
            result.add(symbol);
        }
        return result;
    }

    @Test
    public void tc1() {
        Huffman encoder = new Huffman();
        Symbol a = new Symbol(1, 6);
        Symbol b = new Symbol(2, 2);
        Symbol c = new Symbol(3, 1);
        Symbol d = new Symbol(4, 1);
        encoder.onInit(Arrays.asList(a, b, c, d));
        TreeNode codeTree = encoder.encode();
        List<Integer> limits = codeTree.getCodewordLengthLimits();
        Assert.assertEquals(1, limits.get(0).intValue());
        Assert.assertEquals(3, limits.get(1).intValue());
    }

    public static void main(String[] args) throws IOException {
        List<Symbol> symbols = new AppMain().readSymbol("huffman.txt");
        Huffman encoder = new Huffman();
        encoder.onInit(symbols);
        TreeNode codeTree = encoder.encode();
        List<Integer> limits = codeTree.getCodewordLengthLimits();
        System.out.println(limits.get(0));
        System.out.println(limits.get(1));
    }
}
