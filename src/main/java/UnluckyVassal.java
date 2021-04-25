import java.util.List;

class UnluckyVassal {
    public void printReportForKing(List<String> pollResults) {
        Man king = new Man("король");
        for (String str: pollResults) {
            int t =  str.indexOf(":");
            Man vassal = null;
            String nameVassal = t == -1 ? str : str.substring(0, t);
            vassal = king.find(nameVassal);
            if (vassal == null) {
                vassal = new Man(nameVassal);
                king.addVassal(vassal);
            }
            if (t != -1)
            {
                for(String vassalName: str.substring(t + 2).split(", ")){
                    Man man = king.find(vassalName);
                    if (!(man == null)) {
                        king.delete(man);
                        vassal.addVassal(man);
                    }
                    else
                        vassal.addVassal(new Man(vassalName));
                }
            }
        }
        king.sort();
        System.out.println(king);
    }
}




