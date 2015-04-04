package dao.impl;

import dao.DisciplineDAO;
import database.DBConnection;
import entity.Discipline;

import java.util.List;

/**
 * class RdbDAO2
 */
public class DisciplineMySQLDaoImpl implements DisciplineDAO {

    private DBConnection dbConnection = null;

    public DisciplineMySQLDaoImpl(){
        dbConnection = new DBConnection();
        dbConnection.loadPreparedStatements();
    }

    @Override
    public List<Discipline> getDisciplines() {
        return dbConnection.getDisciplinesList();
    }

    @Override
    public Discipline getDisciplineById(int id) {
        return null;
    }

    @Override
    public boolean updateDiscipline(Discipline discipline) {
        return false;
    }

    @Override
    public boolean addDiscipline(Discipline discipline) {
        dbConnection.setDisciplineAdd(discipline);
        //Logic
        return false;
    }

    @Override
    public boolean deleteeDiscipline(int id) {
        dbConnection.setDisciplineByIdDelete(id);
        //Logic
        return true;
    }

    //Thread -> monitor
    public void close(){
        dbConnection.closePreparedStatements();
        dbConnection.close();
    }
}
