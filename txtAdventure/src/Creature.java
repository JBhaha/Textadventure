public class Creature {
    public Input inputReader = new Input();
    private String name;
    private String greeting;
    private String[] options = new String[3];
    private String[] optionAnswers = new String[3];

    public Creature(String name, String greeting, String[] options, String[] optionAnswers) {
        this.name = name;
        this.greeting = greeting;
        this.options = options;
        this.optionAnswers = optionAnswers;
    }

    public void talkTo(){
        System.out.println(greeting);
        System.out.println("Choose Option:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Option " + (i+1) +": " + options[i]);
        }
        int input = inputReader.readInt();
        System.out.println("Your input was: " + input);
    }


    public String getName() {
        return name;
    }

    public String getGreeting() {
        return greeting;
    }
}
