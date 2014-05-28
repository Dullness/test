
/**
 * Created by anizienko on 14.05.14.
 */
public class Comp {
    Integer cost;
    Integer simpleFee;
    Integer filialFee;
    Integer predFee;
    Integer groupId;
    Integer upCost;
    String owner;
    Integer branchLevel;
    Integer branchCost;
    Integer costRent;
    String f1,f2,f3;
    String group [];
    Comp (int a,int b,int c,int d,int e, int f)
    {
        cost=a;
        simpleFee=b;
        filialFee=c;
        predFee=d;
        groupId=e;
        upCost=f;
        owner=null;
        branchLevel=1;
    }

    public  void setOwner( String newPlayer) {
        this.owner=newPlayer;
    }
    public String  getOwner()
    {
        return (owner==null ? "free" : owner) ;
    }





    public Integer getCost()
    {
        return this.cost;
    }


    public Integer getRent()
    {
        switch (branchLevel)
        {
            case 1: costRent= simpleFee; break;
            case 2: costRent= filialFee; break;
            case 3: costRent= predFee; break;
        }
        return costRent;
    }

    public Integer getBranchcost()
    {
        switch (branchLevel)
        {
            case 1: branchCost= 0; break;
            case 2: branchCost= upCost; break;
            case 3: branchCost= upCost*2; break;
        }
        return branchCost;
    }

    public Integer getBranchlevel()
    {
        return branchLevel;
    }

    public Integer getGroup()
    {
        return groupId;
    }

    public void upBranchlevel()
    {
        branchLevel++;
    }
    public void downBranchlevel()
    {
        branchLevel--;
    }

    static void show()
    {
        System.out.println("Для дебаг мода");
    }
}