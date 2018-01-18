package fr.acceis.jpa.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {

//	public static void main(String[] args) throws Exception  {
//		Class.forName("org.hsqldb.jdbcDriver").newInstance();
//		Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");
//		Statement stmt = connexion.createStatement();
//
//		
//		stmt.close();
//		connexion.close();
//		
//	listerEtudiants();
//	listerProfesseurs();
//		listerSalles();
//	cursusEtudiant("21002127");
//		salleCours(67);
//	listerCoursSalle("i57");
//		listerEtudiantsCours(67);
//	listerProfesseursCursus(10);
//	listerProfesseursMatiere(2);
//		listerProfsEtudiant("21002127");
//		emploiDuTempsSalle("i52");
//		emploiDuTempsEtudiant("21002128");
//		emploiDuTempsProfesseur(55);
//		renvoyer("21002128");

	//}
	
		

	

	//	Liste les étudiants
	@SuppressWarnings("unused")
	private static void listerEtudiants() throws SQLException {
		
		
		try {
			
		
		
		Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");
		Statement stmt = connexion.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM ETUDIANT");
		
		ResultSetMetaData resultMeta = rs.getMetaData();
		
		   System.out.println("\n**********************************");
		
		 for(int i = 1; i <= resultMeta.getColumnCount(); i++)
			  System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
		      System.out.println("\n**********************************");

		      while(rs.next()){         

		          for(int i = 1; i <= resultMeta.getColumnCount(); i++)

		            System.out.print("\t" + rs.getObject(i).toString() + "\t |");

		              

		          System.out.println("\n---------------------------------");


		        }  

		      rs.close();
		      stmt.close();
		      
		} catch (Exception e) {
			// TODO: handle exception
		}

		      

		  }
		

		
		

	

	//	Liste les professeurs
	private static void listerProfesseurs() {
		
		try {
			
			
			
			Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");
			Statement stmt = connexion.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM PROFESSEUR");
			
			ResultSetMetaData resultMeta = rs.getMetaData();
			
			   System.out.println("\n**********************************");
			
			 for(int i = 1; i <= resultMeta.getColumnCount(); i++)
				  System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

		      

			      System.out.println("\n**********************************");

			      while(rs.next()){         

			          for(int i = 1; i <= resultMeta.getColumnCount(); i++)

			            System.out.print("\t" + rs.getObject(i).toString() + "\t |");

			              

			          System.out.println("\n---------------------------------");


			        }  

			      rs.close();
			      stmt.close();
			      
			} catch (Exception e) {
				// TODO: handle exception
			}


	}

	//	Liste les salles
	private static void listerSalles() {
		try {
			
			Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");
			Statement stmt = connexion.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM SALLE");
			
			ResultSetMetaData resultMeta = rs.getMetaData();
			
			   System.out.println("\n**********************************");
			
			 for(int i = 1; i <= resultMeta.getColumnCount(); i++)
				  System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

			      System.out.println("\n**********************************");

			      while(rs.next()){         

			          for(int i = 1; i <= resultMeta.getColumnCount(); i++)

			            System.out.print("\t" + rs.getObject(i).toString() + "\t |");

			          System.out.println("\n---------------------------------");
			        }  

			      rs.close();
			      stmt.close();
			      
			} catch (Exception e) {
				// TODO: handle exception
			}


	}
	

	//	Affiche le nom du cursus d'un étudiant
	private static void cursusEtudiant(String numeroEtudiant) {
		try {
			
			Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");
			Statement stmt = connexion.createStatement();
			
			   String query = "SELECT cursus.nom FROM ETUDIANT left join CURSUS on etudiant.cursus_id = cursus.id where etudiant.numeroEtudiant LIKE numeroEtudiant ";
			
			   ResultSet rs = stmt.executeQuery(query);
			      if (rs.next()) {
			    	  System.out.println( rs.getString("nom"));
					
				}
			      rs.close();
			      stmt.close();
			      
			} catch (Exception e) {
				// TODO: handle exception
			}

	}

	//	Affiche le nom de la salle dans laquelle a lieu un cours
	private static void salleCours(long idCours) {
		
try {
			
			Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");
			Statement stmt = connexion.createStatement();
			
			   String query = "SELECT salle.nom FROM COURS right join creneau  on cours.id = creneau.cours_id right Join salle on creneau.salle_id = salle.id where cours.id = " + idCours    ;
			
			   ResultSet rs = stmt.executeQuery(query);
			   
			 
			   
			   
			   if (rs.next()) {
				   System.out.println(rs.getString("nom"));
					
				}
			      rs.close();
			      stmt.close();
			      
			} catch (Exception e) {
				e.printStackTrace();
				
			}


	}

	//	Affiche le nom des cours ayant lieu dans une salle
	private static void listerCoursSalle(String nomSalle) {
try {
			
			Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");
			Statement stmt = connexion.createStatement();
			String query = "SELECT MATIERE.NOM   FROM  SALLE "
					+ " RIGHT JOIN CRENEAU ON SALLE.ID = CRENEAU.SALLE_ID"
			   		+ " RIGHT JOIN COURS   on   CRENEAU.COURS_ID = COURS.ID "
			   		+ " RIGHT Join MATIERE on COURS.MATIERE_ID = MATIERE.id WHERE SALLE.NOM='"+ nomSalle + "'" ;
			
			   ResultSet rs = stmt.executeQuery(query);
			   
			 
			   
			   
			   if (rs.next()) {
				   System.out.println(rs.getString("nom"));
					
				}
			      rs.close();
			      stmt.close();
			      
			} catch (Exception e) {
				e.printStackTrace();
				
			}


	}

	





	//	Affiche le nom des étudiants qui assistent à un cours
	private static void listerEtudiantsCours(long idCours) {
		
try {
			Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");
			
			String query = "SELECT ETUDIANT.NOM   FROM  COURS "
					+ " RIGHT JOIN MATIERE ON COURS.MATIERE_ID = MATIERE.ID"
			   		+ " RIGHT JOIN CURSUS_MATIERE ON MATIERE.ID = CURSUS_MATIERE.MATIERES_ID  "
					+ " RIGHT JOIN CURSUS ON CURSUS_MATIERE.CURSUS_ID = CURSUS.ID"
			   		+ " RIGHT JOIN ETUDIANT ON CURSUS_MATIERE.CURSUS_ID = ETUDIANT.CURSUS_ID WHERE COURS.ID=?";
			
			 PreparedStatement prepare = connexion.prepareStatement(query);
			 prepare.setLong( 1, idCours);
			 ResultSet  rs = prepare.executeQuery() ;
			 ResultSetMetaData resultMeta = rs.getMetaData();
				
			   System.out.println("\n**********************************");
			
			 for(int i = 1; i <= resultMeta.getColumnCount(); i++)
				  System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
			  System.out.println("\n**********************************");
			  
			  while(rs.next()){ 
		          for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		            System.out.print("\t" + rs.getObject(i).toString() + "\t |");
		          System.out.println("\n---------------------------------");
		        }  

		      rs.close();
		      rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}

	}
	
	

	//	Affiche le nom des professeurss qui enseignent dans un cursus
	private static void listerProfesseursCursus(long idCursus) {
		
try {
			
			Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");
			
			String query = "SELECT DISTINCT PROFESSEUR.NOM   FROM  CURSUS "
					+ " RIGHT JOIN CURSUS_MATIERE ON CURSUS.ID = CURSUS_MATIERE.CURSUS_ID  "
					+ " RIGHT JOIN MATIERE ON CURSUS_MATIERE.MATIERES_ID = MATIERE.ID"
			   		+ " RIGHT JOIN COURS ON MATIERE.ID = COURS.MATIERE_ID"
					+ " RIGHT JOIN COURS_PROFESSEUR ON COURS.ID = COURS_PROFESSEUR.COURS_ID"
			   		+ " RIGHT JOIN PROFESSEUR ON COURS_PROFESSEUR.PROFESSEURS_ID = PROFESSEUR.ID  WHERE CURSUS.ID =?";
			
			 PreparedStatement prepare = connexion.prepareStatement(query);
			 prepare.setLong( 1, idCursus);
			 ResultSet  rs = prepare.executeQuery() ;
			 ResultSetMetaData resultMeta = rs.getMetaData();
				
			   System.out.println("\n Affiche le nom des professeurss qui enseignent dans un cursus");
			
			 for(int i = 1; i <= resultMeta.getColumnCount(); i++)
				 
				  System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
			  System.out.println("\n**********************************");
			  while(rs.next()){ 
		          for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		            System.out.print("\t" + rs.getObject(i).toString() + "\t |");
		          System.out.println("\n---------------------------------");
		        }  

		      rs.close();
		      rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}

	}

	//	Affiche le nom des professeurs qui enseignent une matière
	private static void listerProfesseursMatiere(long idMatiere) {
		
try {
			
			Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");
			
			String query = "SELECT DISTINCT PROFESSEUR.NOM   FROM  MATIERE "
					+ " RIGHT JOIN COURS ON MATIERE.ID = COURS.MATIERE_ID  "
					+ " RIGHT JOIN COURS_PROFESSEUR ON COURS.ID = COURS_PROFESSEUR.COURS_ID"
			   		+ " RIGHT JOIN PROFESSEUR ON COURS_PROFESSEUR.PROFESSEURS_ID = PROFESSEUR.ID  WHERE MATIERE.ID=? ";
			
			 PreparedStatement prepare = connexion.prepareStatement(query);
			 prepare.setLong( 1, idMatiere);
			 ResultSet  rs = prepare.executeQuery() ;
			 ResultSetMetaData resultMeta = rs.getMetaData();
			 System.out.println("	Affiche le nom des professeurs qui enseignent une matière");
			
			 for(int i = 1; i <= resultMeta.getColumnCount(); i++)
				  System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
			      System.out.println("\n**********************************");
			      
			  while(rs.next()){ 
		          for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		            System.out.print("\t" + rs.getObject(i).toString() + "\t |");
		          System.out.println("\n---------------------------------");
		        }  

		      rs.close();
		      rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}


	}

	//	Affiche des profs qui enseignent à un étudiant
	private static void listerProfsEtudiant(String numeroEtudiant) {

try {
			
			Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");
			
			String query = "SELECT DISTINCT PROFESSEUR.NOM   FROM  ETUDIANT "
					+ " RIGHT JOIN CURSUS ON ETUDIANT.CURSUS_ID = CURSUS.ID  "
					+ " RIGHT JOIN CURSUS_MATIERE ON CURSUS.ID = CURSUS_MATIERE.CURSUS_ID"
			   		+ " RIGHT JOIN MATIERE ON CURSUS_MATIERE.MATIERES_ID = MATIERE.ID  "
			   		+ " RIGHT JOIN COURS ON MATIERE.ID = COURS.MATIERE_ID  "
					+ " RIGHT JOIN COURS_PROFESSEUR ON COURS.ID = COURS_PROFESSEUR.COURS_ID"
			   		+ " RIGHT JOIN PROFESSEUR ON COURS_PROFESSEUR.PROFESSEURS_ID = PROFESSEUR.ID  WHERE ETUDIANT.NUMEROETUDIANT =?";
			
			 PreparedStatement prepare = connexion.prepareStatement(query);
			 prepare.setString( 1, numeroEtudiant);
			 ResultSet  rs = prepare.executeQuery() ;
			 ResultSetMetaData resultMeta = rs.getMetaData();
			 System.out.println("Affiche des profs qui enseignent à un étudiant");
			
			 for(int i = 1; i <= resultMeta.getColumnCount(); i++)
				  System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
			      System.out.println("\n**********************************");
			      
			  while(rs.next()){ 
		          for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		            System.out.print("\t" + rs.getObject(i).toString() + "\t |");
		          System.out.println("\n---------------------------------");
		        }  

		      rs.close();
		      rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}


	}






	//	Affiche l'emploi du temps d'une salle
	private static void emploiDuTempsSalle(String nomSalle) {
try {
			
			Connection connexion = DriverManager.getConnection("jdbc:hsqldb:data/basejpa", "sa",  "");
			
			String query = "SELECT DISTINCT PROFESSEUR.NOM   FROM  ETUDIANT "
					+ " RIGHT JOIN CURSUS ON ETUDIANT.CURSUS_ID = CURSUS.ID  "
					+ " RIGHT JOIN CURSUS_MATIERE ON CURSUS.ID = CURSUS_MATIERE.CURSUS_ID"
			   		+ " RIGHT JOIN MATIERE ON CURSUS_MATIERE.MATIERES_ID = MATIERE.ID  "
			   		+ " RIGHT JOIN COURS ON MATIERE.ID = COURS.MATIERE_ID  "
					+ " RIGHT JOIN COURS_PROFESSEUR ON COURS.ID = COURS_PROFESSEUR.COURS_ID"
			   		+ " RIGHT JOIN PROFESSEUR ON COURS_PROFESSEUR.PROFESSEURS_ID = PROFESSEUR.ID  WHERE ETUDIANT.NUMEROETUDIANT =?";
			
			 PreparedStatement prepare = connexion.prepareStatement(query);
			 prepare.setString( 1, nomSalle);
			 ResultSet  rs = prepare.executeQuery() ;
			 ResultSetMetaData resultMeta = rs.getMetaData();
			 System.out.println("Affiche des profs qui enseignent à un étudiant");
			
			 for(int i = 1; i <= resultMeta.getColumnCount(); i++)
				  System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
			      System.out.println("\n**********************************");
			      
			  while(rs.next()){ 
		          for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		            System.out.print("\t" + rs.getObject(i).toString() + "\t |");
		          System.out.println("\n---------------------------------");
		        }  

		      rs.close();
		      rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				
			}

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
