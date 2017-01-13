package week5.tictactoe;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World";

        System.out.println(Hex.encodeHexString(input.getBytes()));

        String res = Hex.encodeHexString(input.getBytes());
        String backToString = new String(res.getBytes());
        System.out.println(backToString);
    }
}
//Antwoord op vraag 11: hij wordt alleen steeds langer

//Antwoord op vraag 13: hij wordt ook daadwerkelijk steeds anders ipv slechts langer