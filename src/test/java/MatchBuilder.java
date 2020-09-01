public class MatchBuilder {

    public static Match getPerfectMatch(){
        Match match=new Match();
        for (int i = 0; i <72 ; i++)
            match.score(1);

        return match;
    }

    public static Match getTieBreak(){
        Match match=new Match();
        for (int i = 0; i <20 ; i++)
            match.score(1);

        for (int i = 0; i <24 ; i++)
            match.score(2);

        for (int i = 0; i <4 ; i++)
            match.score(1);

        return match;
    }
}
