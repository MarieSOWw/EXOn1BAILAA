package entities;

public class Unite extends AbstractEntity{
    //Attributs   Instances
    

    public Unite(){
        super();
    }
    public Unite(int id,String libelle){
        super(id,libelle);
    }
    @Override
    public String toString() {
        return "Unite "+super.toString();
    }

    

    
}
