import java.util.*;

public class Conversation {

  /**
   * This method asks how many conversation rounds the user wants to have. The chatbot takes in a 
   * user input and then the chatbot responds either with mirror words that makes the conversation relate to 
   * the user's input or if there are no mirror words, then the chatbot responds with a canned response that is random.
   * @param args there are multiple lists; the transcript list that the entire chatbot is added to and the 
   * words list which holds all the phrases said by the user. There is also the replies list that holds the random canned
   * responses from the computer.
   */
  public static void main(String[] args) {
    List<String> transcript = new ArrayList<>();

    System.out.print("How many conversation rounds would you like to have? ");
    int rounds = 0;
    Scanner input = new Scanner(System.in);
    rounds = input.nextInt();

    transcript.add("Hi there! What's on your mind?");
    System.out.println("Hi there! What's on your mind?");

    for (int i = 0; i < rounds; i++) {
      Scanner response = new Scanner(System.in);
      String phrase = response.nextLine();
      transcript.add(phrase);
      
      String[] words = phrase.split(" ");
      for (String word : words) {
        int x = Arrays.asList(words).indexOf(word);
        if (word.equals("I")){
          words[x] = "you";}
        if (word.equals("me") || (word.equals("Me"))){
          words[x] = "you";}
        if (word.equals("am")){
          words[x] = "are";}
        if (word.equals("you") || word.equals("You")){
          words[x] = "I";}
        if (word.equals("my") || word.equals("My")){
          words[x] = "your";}
        if (word.equals("your") || word.equals("Your")){
          words[x] = "my";}
        }
      String finalPhrase = String.join(" " , words);
      if (finalPhrase.equals(phrase)){
        String[] replies = {"Cool!", "Interesting!", "Hmm...", "Tell me more about that"};
        Random rand = new Random();
        int index = rand.nextInt(replies.length);
        transcript.add(replies[index]);
        System.out.println(replies[index]);
      }
      else{
        transcript.add(finalPhrase);
        System.out.println(finalPhrase);
      }
      
    }
    System.out.println("See ya! \n");
    transcript.add("See ya!");
    System.out.println("TRANSCRIPT:");


    for (int x = 0; x < transcript.size(); x++){
      System.out.println(transcript.get(x));
    }
    }
  }
