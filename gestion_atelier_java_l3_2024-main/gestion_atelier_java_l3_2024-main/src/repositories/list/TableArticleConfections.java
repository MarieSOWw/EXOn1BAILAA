package repositories.list;

import java.util.ArrayList;

import entities.ArticleConfection;

import repositories.ITables;

public class TableArticleConfections implements ITables<ArticleConfection> {
    private ArrayList<ArticleConfection> tables=new ArrayList<>();
    @Override
    public int insert(ArticleConfection data) {
            tables.add(data);
        return 1;
    }

    @Override
    public int update(ArticleConfection data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<ArticleConfection> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ArticleConfection findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public  int indexOf(int id){
        int pos=0;
       for (ArticleConfection cat : tables) {
           if(cat.getId()==id){
             return pos;
           }
           pos++;
       }
       return -1;
    }
    
}
