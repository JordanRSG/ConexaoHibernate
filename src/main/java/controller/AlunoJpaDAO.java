package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Alunos;
 
public class AlunoJpaDAO {
 
         private static AlunoJpaDAO instance;
         protected EntityManager entityManager;
         
         public static AlunoJpaDAO getInstance(){
                   if (instance == null){
                            instance = new AlunoJpaDAO();
                   }
                   
                   return instance;
         }
 
         private AlunoJpaDAO() {
                   entityManager = getEntityManager();
         }
 
         private EntityManager getEntityManager() {
                   EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
                   if (entityManager == null) {
                            entityManager = factory.createEntityManager();
                   }
 
                   return entityManager;
         }
 
         public Alunos getById(final int id) {
                   return entityManager.find(Alunos.class, id);
         }
 
         @SuppressWarnings("unchecked")
         public List<Alunos> findAll() {
                   return entityManager.createQuery("FROM " + Alunos.class.getName()).getResultList();
         }
 
         public void persist(Alunos Aluno) {
                   try {
                            entityManager.getTransaction().begin();
                            entityManager.persist(Aluno);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void merge(Alunos Aluno) {
                   try {
                            entityManager.getTransaction().begin();
                            entityManager.merge(Aluno);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void remove(Alunos Aluno) {
                   try {
                            entityManager.getTransaction().begin();
                            Aluno = entityManager.find(Alunos.class, Aluno.getId());
                            entityManager.remove(Aluno);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void removeById(final int id) {
                   try {
                            Alunos Aluno = getById(id);
                            remove(Aluno);
                   } catch (Exception ex) {
                            ex.printStackTrace();
                   }
         }
 
}