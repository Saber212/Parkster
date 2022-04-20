package se.parkster.rps;

public class Game {
      private int player_one;
      private int player_two;
      private String result;


    public int getPlayer_one() {
        return player_one;
    }

    public void setPlayer_one(int player_one) {
        this.player_one = player_one;
    }

    public int getPlayer_two() {
        return player_two;
    }

    public void setPlayer_two(int player_two) {
        this.player_two = player_two;
    }
    public String getResult() { return result; }

    public void setResult(String result) { this.result = result; }

    public String calculateResult(int player_one, int player_two){
        setResult("");
        if(player_one<1 || player_one>3 || player_two<1 || player_two>3 ){
            setResult("Invalid input!");
        }
        else{
        final int ROCK = 1, SCISSOR = 2, PAPER = 3;
        String player1 = "Player one wins!";
        String player2 = "Player two wins!";
        String tie = "It is a tie!";
        if (player_one == player_two){
            setResult(tie);
        } else {
            switch (player_one) {
                case ROCK:
                    if (player_two == SCISSOR)
                        setResult(player1);
                    else
                        setResult(player2);
                    break;
                case SCISSOR:
                    if (player_two == PAPER)
                        setResult(player1);
                    else
                        setResult(player2);
                    break;
                case PAPER:
                    if (player_two == ROCK)
                        setResult(player1);
                    else
                        setResult(player2);
                    break;
            }
            }
        }
        return getResult();
    }
}

