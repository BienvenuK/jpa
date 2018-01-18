package testjpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestJdbc {

	public static void main(String[] args) throws Exception  {
	
		
	listerEtudiants();
	listerProfesseurs();
	listerSalles();
	cursusEtudiant("21002127");
	salleCours(67);
	listerCoursSalle("i57");
		listerEtudiantsCours(67);
	listerProfesseursCursus(10);
//	listerProfesseursMatiere(2);
//		listerProfsEtudiant("21002127");
//		emploiDuTempsSalle("i52");
//		emploiDuTempsEtudiant("21002128");
//		emploiDuTempsProfesseur(55);
//		renvoyer("21002128");

	}
	
		

	

	//	Liste les étudiants
	private static void listerEtudiants() throws SQLException {
	
			
		try {
			SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder ();
			CriteriaQuery <Etudiant> criteria =criteriaBuilder.createQuery (Etudiant.class );
			Root <Etudiant >root =criteria.from (Etudiant.class );
			criteria .select (root );
			Query <Etudiant >query = session.createQuery(criteria);
			List<Etudiant> etudiants =query.getResultList () ;
			
			System.out.println("\n***************************************************************************************************************");
			System.out.println("                           	Liste les étudiants                                                    ");
			System.out.println("\n***************************************************************************************************************");
			for (Etudiant etudiant : etudiants) {
				System.out.println(etudiant.toString());
				
			}
			
			System.out.println("\n***************************************************************************************************************");
			System.out.println("\n\n\n------------------------------------------------------------------------------------------------------------");
			
			sessionFactory.close();
			
		
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		
		

		
		
		  }
		
	}
		
		

	

	//	Liste les professeurs
	private static void listerProfesseurs() {
		
		try {
			SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder ();
			CriteriaQuery <Professeur> criteria =criteriaBuilder.createQuery (Professeur.class );
			Root <Professeur >root =criteria.from (Professeur.class );
			criteria .select (root );
			Query <Professeur >query = session.createQuery(criteria);
			List<Professeur> professeurs =query.getResultList () ;
			
			System.out.println("\n***************************************************************************************************************");
			System.out.println("                           	Liste les professeurs                                                    ");
			System.out.println("\n***************************************************************************************************************");
			for (Professeur professeur : professeurs) {
				
				System.out.println(professeur.toString());
				
			}
			
			System.out.println("\n***************************************************************************************************************");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			sessionFactory.close();
			
		
			
		} catch (Exception e) {
			// TODO: handle exception
		
		
		

		
		
		  }
	}

		//Liste les salles
	private static void listerSalles() {
		
		try {
			SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder ();
			CriteriaQuery <Salle> criteria =criteriaBuilder.createQuery (Salle.class );
			Root <Salle >root =criteria.from (Salle.class );
			criteria .select (root );
			Query <Salle >query = session.createQuery(criteria);
			List<Salle> Salles =query.getResultList () ;
			
			System.out.println("\n***************************************************************************************************************");
			System.out.println("                           	Liste Salles                                                ");
			System.out.println("\n***************************************************************************************************************");
			for (Salle salle : Salles) {
				
				System.out.println(salle.toString());
				
			}
			
			System.out.println("\n***************************************************************************************************************");
			System.out.println("------------------------------------------------------------------------------------------------------------");
	
			sessionFactory.close();
			
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		
		

		
		
		  }
		
	}
	

	//	Affiche le nom du cursus d'un étudiant
	private static void cursusEtudiant(String numeroEtudiant) {
		
		try {
			SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			 Etudiant etudiant = session.load(Etudiant.class, numeroEtudiant);
			Cursus cursus = etudiant.getCursus();
			
					
			
			System.out.println("\n***************************************************************************************************************");
			System.out.println("                           	Nom du cursus d un etudiant                                              ");
			System.out.println("\n***************************************************************************************************************");
			System.out.println(cursus.getNom());
			
			
			System.out.println("\n***************************************************************************************************************");
			System.out.println("------------------------------------------------------------------------------------------------------------");
	
			sessionFactory.close();
			
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		
		

		
		
		  }
		
		
		
		
		
		
		
	}

	//	Affiche le nom de la salle dans laquelle a lieu un cours
	private static void salleCours(long idCours) {
		
		try {
			SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			 Cours cours = session.load(Cours.class, idCours);
			 Salle salle = cours.getCreneau().getSalle();
			
					
			
			System.out.println("\n***************************************************************************************************************");
			System.out.println("                           	Nom de la salle  dans laquelle a lieu un cours                                             ");
			System.out.println("\n***************************************************************************************************************");
			System.out.println(salle.getNom());
			
			
			System.out.println("\n***************************************************************************************************************");
			System.out.println("------------------------------------------------------------------------------------------------------------");
	
			sessionFactory.close();
			
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		
		

		
		
		  }
		


	}

	//	Affiche le nom des cours ayant lieu dans une salle
	private static void listerCoursSalle(String nomSalle) {
		
		try {
			SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
			Session session = sessionFactory.openSession();
			CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder ();
			CriteriaQuery <Salle> criteria =criteriaBuilder.createQuery (Salle.class );
			Root <Salle >root =criteria.from (Salle.class );
			criteria .select (root ).where(criteriaBuilder.equal(root.get("nom"),nomSalle));
			
			
			Query <Salle >query = session.createQuery(criteria);
			 Salle salle =query.getSingleResult();
			 Collection<Creneau> creneaux = salle.getCreneaux();
			
					
			
			System.out.println("\n***************************************************************************************************************");
			System.out.println("                           	Nom  cours   dans    la salle                                       ");
			System.out.println("\n***************************************************************************************************************");
		for (Creneau creneau : creneaux) {
			System.out.println(creneau.getCours().getMatiere().getNom());
				
			}
			
			System.out.println("\n***************************************************************************************************************");
			System.out.println("------------------------------------------------------------------------------------------------------------");
	
			sessionFactory.close();
			
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		
		

		
		
		  }
		

	}

	





	//	Affiche le nom des étudiants qui assistent à un cours
	private static void listerEtudiantsCours(long idCours) {
		
		try {
			SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
			Session session = sessionFactory.openSession();
//			CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder ();
//			CriteriaQuery <Salle> criteria =criteriaBuilder.createQuery (Salle.class );
//			Root <Salle >root =criteria.from (Salle.class );
//			criteria .select (root ).where(criteriaBuilder.equal(root.get("nom"),nomSalle));
//			
			
//			Query <Salle >query = session.createQuery(criteria);
//			 Salle salle =query.getSingleResult();
//			 Collection<Creneau> creneaux = salle.getCreneaux();
			 
//			 Session session = sessionFactory.openSession();
			 Cours cours = session.load(Cours.class, idCours);
			 Collection<Cursus> cursus = cours.getMatiere().getCursus();
			
			
					
			
			System.out.println("\n***************************************************************************************************************");
			System.out.println("                           le nom des étudiants qui assistent à un cours                                     ");
			System.out.println("\n***************************************************************************************************************");
		for (Cursus cursus2 : cursus) {
			
			Collection<Etudiant>etudiants = cursus2.getEtudiants();
			System.out.println("\n***************************************************************************************************************");
			System.out.println("                           le nom du cursus                                 ");
			System.out.println("\n***************************************************************************************************************");
			
			System.out.println(cursus2.getNom());
			
			for (Etudiant etudiant : etudiants) {
				System.out.println(etudiant.getNom());
			}
		
			
			
				
			}
			
			System.out.println("\n***************************************************************************************************************");
			System.out.println("------------------------------------------------------------------------------------------------------------");
	
			sessionFactory.close();
			
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		
		

		
		
		  }
		

	}
	
	

	//	Affiche le nom des professeurss qui enseignent dans un cursus
	private static void listerProfesseursCursus(long idCursus) {
		
		try {
		
		SessionFactory sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
//		CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder ();
//		CriteriaQuery <Salle> criteria =criteriaBuilder.createQuery (Salle.class );
//		Root <Salle >root =criteria.from (Salle.class );
//		criteria .select (root ).where(criteriaBuilder.equal(root.get("nom"),nomSalle));
//		
		
//		Query <Salle >query = session.createQuery(criteria);
//		 Salle salle =query.getSingleResult();
//		 Collection<Creneau> creneaux = salle.getCreneaux();
		 
//		 Session session = sessionFactory.openSession();
		 Cursus cursus = session.load(Cursus.class, idCursus);
		 Collection< Matiere> matieres =  cursus.getMatieres();
		 for (Matiere matiere : matieres) {
			 Collection< Cours> cours = matiere.getCours();
			 for (Cours cours2 : cours) {
				Collection< Professeur> professeurs = cours2.getProfesseurs();
				for (Professeur professeur : professeurs) {
					System.out.println(professeur.getNom());
				}
				
			}
			
		}
		
		
				
	
	

		


	}

	//	Affiche le nom des professeurs qui enseignent une matière
	private static void listerProfesseursMatiere(long idMatiere) {
		


	}

	//	Affiche des profs qui enseignent à un étudiant
	private static void listerProfsEtudiant(String numeroEtudiant) {
		System.out.println(etudiant.getNom());


	}






	//	Affiche l'emploi du temps d'une salle
	private static void emploiDuTempsSalle(String nomSalle) {

	}

	//	Affiche l'emploi du temps d'un étudiant
	private static void emploiDuTempsEtudiant(String numeroEtudiant) {

	}

	//	Affiche l'emploi du temps d'un professeur
	private static void emploiDuTempsProfesseur(long idProfesseur) {

	}

	// Renvoie un étudiant
	private static void renvoyer(String numeroEtudiant) {

	}

}
