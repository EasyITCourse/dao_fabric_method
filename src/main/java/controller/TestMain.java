package controller;


import dao.DisciplineDAO;
import dao.FactoryDao;
import dao.impl.FactoryDaoMySQLImpl;
import entity.Discipline;

import java.util.List;

public class TestMain {


    public static void main(String[] args) {

        Discipline disciplineForm = new Discipline(2,"Математика");



//       DataBase -> PSQL
//       FactoryDao factoryDaoPSQL = new FactoryDaoPSQLImpl();
//       deleteAccountDao(factoryDaoPSQL, 3);

        // DataBase -> MySQL
        FactoryDao factoryDaoMySQL = new FactoryDaoMySQLImpl();

        //DELETE Discipline
//       deleteDisciplineDao(factoryDaoMySQL, 10);


        //CREATE Discipline
//        Discipline discipline = new Discipline("Информатика");
//        setDisciplineAddDao(factoryDaoMySQL, discipline);

        //LIST <Discipline>
        for (Discipline iter : getDisciplinesListDao(factoryDaoMySQL)) {
            System.out.println(iter);
        }
    }

    // *********   Discipline   ***************

    //SELECT * FROM disciplines
    public static List<Discipline> getDisciplinesListDao(FactoryDao factoryDao) {
        DisciplineDAO disciplineDAO = factoryDao.createDisciplineDAO();
        return disciplineDAO.getDisciplines();
    }

    //"INSERT INTO disciplines (name) VALUES (?)";
    public static void setDisciplineAddDao(FactoryDao factoryDao, Discipline discipline) {
        DisciplineDAO disciplineDAO = factoryDao.createDisciplineDAO();
        disciplineDAO.addDiscipline(discipline);
    }

    //DELETE FROM disciplines WHERE id =?
    public static void deleteDisciplineDao(FactoryDao factoryDao, int id) {
        DisciplineDAO disciplineDAO = factoryDao.createDisciplineDAO();
        disciplineDAO.deleteeDiscipline(id);
    }
}
