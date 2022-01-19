package pojan192022;
import java.util.HashMap;

public class TextTwist {
    public static void main(String[] args){
        TextTwist test = new TextTwist();
        System.out.println(test.totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(test.totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(test.totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
    }
    private HashMap<Character, Integer> validLetterToCount;
    private final int[] sizeToPoints;
    public TextTwist() {
        validLetterToCount = new HashMap<>();
        sizeToPoints = new int[]{0, 0, 0, 1, 2, 3, 54};
    }
    boolean isValidGuess(String word) {
        HashMap<Character, Integer> letterToCount = new HashMap<>();
        for(int i = 0; i < word.length(); ++i) {
            char curChar = word.charAt(i);
            //exit on letter mismatch
            if(!validLetterToCount.containsKey(curChar))
                return false;

            //update the count of the letter
            if(letterToCount.containsKey(curChar))
                letterToCount.replace(curChar, letterToCount.get(curChar) + 1);
            else
                letterToCount.put(curChar, 1);

            //exit on higher character count
            if(letterToCount.get(curChar) > validLetterToCount.get(curChar))
                return false;
        }
        return true;
    }
    int totalPoints(String[] words, String unscrambledWord) {
        //determine the characters used in the unscrambled word
        validLetterToCount.clear();
        for(int i = 0; i < unscrambledWord.length(); ++i) {
            char curChar = unscrambledWord.charAt(i);
            if(validLetterToCount.containsKey(curChar))
                validLetterToCount.replace(curChar, validLetterToCount.get(curChar) + 1);
            else
                validLetterToCount.put(curChar, 1);
        }
        //Calculate points
        int points = 0;
        for(int i = 0; i < words.length; ++i) {
            if(words[i].length() <= 6 && isValidGuess(words[i]))
                points += sizeToPoints[words[i].length()];
        }
        return points;
    }
}
