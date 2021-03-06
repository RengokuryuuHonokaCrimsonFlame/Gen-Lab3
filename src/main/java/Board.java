import java.util.LinkedList;

public class Board {
    private LinkedList<Square> squares;

    public Board(){
        squares = new LinkedList<>();

        squares.add(new GoSquare("Go"));
        for(int i = 1; i < 40; i ++){
            switch (i) {
                case 4:
                    squares.add(new IncomeTaxSquare("Tax Square " + i));
                    break;
                default:
                    squares.add(new RegularSquare("Square "+ i));
            }

        }
    }

    public Square getSquare(Square oldLoc, int fvTot) {
        int i = 0;
        for(Square sq : squares){
            if(sq.equals(oldLoc)) break;
            ++i;
        }
        return squares.get((i + fvTot) % squares.size());
    }
}
