public class Creature {
    public Input inputReader = new Input();
    private final String name;
    private final String greeting;
    private final int maxTalk = 3;
    private String[] options = new String[maxTalk];
    private String[] optionAnswers = new String[maxTalk];

    //Consturctor
    public Creature(String name, String greeting, String[] options, String[] optionAnswers) {
        this.name = name;
        this.greeting = greeting;
        this.options = options;
        this.optionAnswers = optionAnswers;
    }

    //method for talking to the creature, shows options and takes an option
    public void talkTo(){

        for (int i = 0; i < 3; i++) {
            System.out.println("Option " + (i+1) +": " + options[i]);
        }
        System.out.println("Choose option:");
        int input = inputReader.readInt();
        System.out.println(optionAnswers[input-1]);

        if (input != maxTalk){
            talkTo();
        }
    }


    public String getName() {
        return name;
    }

    public String getGreeting() {
        return greeting;
    }
}
