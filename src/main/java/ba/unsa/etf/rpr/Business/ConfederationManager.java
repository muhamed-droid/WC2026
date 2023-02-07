package ba.unsa.etf.rpr.Business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Team;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

/**
 * Business Logic Layer for management of Confederations
 *
 * @author Muhamed-droid
 */

public class ConfederationManager {
    public void validateCategoryName(String name) throws MyException {
        //Trebalo bi da ako dodajemo novu da ona prije ne postoji to jest da bude nova skroz
        //if (name == null || name.length() > 45 || name.length() < 3){
          //  throw new MyException("Category name must be between 3 and 45 chars");
        //}
    }

    public Confederation add(Confederation con) throws MyException {
        if (con.getId() != 0){
            throw new MyException("Can't add confederation with ID. ID is autogenerated");
        }
        //validateCategoryName(con.getName());

        try{
            return DaoFactory.confederationDao().add(con);
        }catch (MyException e){
            if (e.getMessage().contains("UQ_NAME")){
                throw new MyException("Confederation with same name exists");
            }
            throw e;
        }
    }

    public void delete(int categoryId) throws MyException{
        try{
            DaoFactory.confederationDao().delete(categoryId);
        }catch (MyException e){
            if (e.getMessage().contains("FOREIGN KEY")){
                throw new MyException("Cannot delete confederation which is related to teams." +
                        " First delete related teams before deleting confederation.");
            }
            throw e;
        }

    }

    public Confederation update(Confederation con) throws MyException{
        //validateCategoryName(con.getName());
        return DaoFactory.confederationDao().update(con);
    }

    public List<Confederation> getAll() throws MyException{
        return DaoFactory.confederationDao().getAll();
    }

}
