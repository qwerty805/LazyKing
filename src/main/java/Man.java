import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Man {
    private String name;
    private List<Man> vassalList;
    private Man parrent = null;

    public Man(String name) {
        this.name = name;
        this.vassalList = new ArrayList<>();
    }

    public void addVassal(Man vassal)
    {
        vassal.parrent = this;
        this.vassalList.add(vassal);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        print(stringBuilder,"", "\t");
        return stringBuilder.toString();
    }

    private void print(StringBuilder stringBuilder, String prefix, String childrenPrefix) {
        stringBuilder.append(prefix);
        stringBuilder.append(name);
        stringBuilder.append('\n');
        for (Iterator<Man> iterator = vassalList.iterator(); iterator.hasNext();)
            iterator.next().print(stringBuilder, childrenPrefix, childrenPrefix + "\t");
    }
        public Man find(String name) {
        Man result = null;
        if (this.name.equals(name))
            return this;
        else
            if (this.vassalList.iterator().hasNext())
            {
                for (Iterator<Man> iterator = vassalList.iterator(); iterator.hasNext();)
                {
                    result = iterator.next().find(name);
                    if (result != null)
                        return result;
                }
            }
            return result;
    }

    public void sort(){
        vassalList.sort(new Comparator<Man>() {
            @Override
            public int compare(Man o1, Man o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
    }

    public void delete(Man man) {
        man.parrent.vassalList.remove(man);
    }
}

