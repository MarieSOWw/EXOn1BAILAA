import java.util.Scanner;

import entities.ArticleConfection;
import entities.Categorie;
import repositories.list.Table;
import services.CategorieServiceImpl;

public class App {
    // creation objet Categrieserviceimpl
    private CategorieServiceImpl categorieServiceImpl = new CategorieServiceImpl();
    private Table<ArticleConfection> article = new Table<ArticleConfection>();

    static Scanner scanner = new Scanner(System.in);

    // fonction pour ajouter une categorie
    void ajouterCategorie() {
        Categorie categorie = new Categorie();

        System.out.println("Entrer le id");
        categorie.setId(scanner.nextInt());
        System.out.println("Entrer le libelle");
        categorie.setLibelle(scanner.next());
        categorieServiceImpl.add(categorie);
        System.out.println("une nouvele categorie a été ajoutée");
    }
    // fontion pour afficher la liste des categories

    void afficherlistCategorie() {
        categorieServiceImpl.getAll().forEach(System.out::println);
    }

    // fonction pour modifier une categorie
    private void modifierCategorie() {
        System.out.println("Entrer le id de la categorie a modifier");
        // recueillir le id de la categorie
        int id = scanner.nextInt();
        // cherche la categorie a modifier
        Categorie a = categorieServiceImpl.show(id);
        // modifier les attributs de la categorie
        System.out.println("Entrer le nouveau id ");
        a.setId(scanner.nextInt());
        System.out.println("Entrer le nouveau libelle ");
        a.setLibelle(scanner.next());
        // update la table avec la nouvelle categorie creee
        categorieServiceImpl.update(a);

    }

    // methode pour supprimer une categorie
    private void supprimerCategorie() {
        categorieServiceImpl.getAll().forEach(System.out::println);

        // recuperer le id de la categorrie a supprimer

        System.out.println("Entrer le id de la categorie a Supprimer");
        int id = scanner.nextInt();
        categorieServiceImpl.remove(id);

    }
    // fonction pouir suppression multiple

    void supprimerPlusieursCategorie() {
        // ArrayList<Integer> listids = new ArrayList<Integer>();
        System.out.println("Entrer le nombre decategorie a Supprimer");
        int nbre = scanner.nextInt();
        int[] ids = new int[nbre];
        System.out.println("Entrez les id a supprimer) : ");
        for (int i = 0; i < nbre; i++) {
            ids[i] = scanner.nextInt();
        }
        categorieServiceImpl.remove(ids);

    }
    // fonction pour ajouter article confection

    void ajouterArticle() {
        // creation objet Article confection
        ArticleConfection artcl = new ArticleConfection();
        System.out.println("Entrer le id");

        artcl.setId(scanner.nextInt());

        System.out.println("Entrer le libelle");
        artcl.setLibelle(scanner.next());

        System.out.println("Entrer le prix ");
        artcl.setPrix(scanner.nextDouble());

        System.out.println("Entrer la quantite ");
        artcl.setQte(scanner.nextDouble());

        System.out.println("entrer la categorie de l'article");
        artcl.setCategorie(categorieServiceImpl.show(scanner.nextInt()));
        System.out.println(artcl.getCategorie());

        article.insert(artcl);

        System.out.println(artcl.toString());

    }

    // fonction pour afficher la liste des articles
    void afficherlisteArticle() {
        article.findAll().forEach(System.out::println);

    }

    // fonction pour modifier un article

    private void modifierArticle() {

        System.out.println("entrer l'id de l'article");
        int id = scanner.nextInt();
        // chercher article a modifier
        ArticleConfection a = article.findById(id);

        // modifier les valeurs
        System.out.println("entrer nouveau id");
        a.setId(scanner.nextInt());
        System.out.println("entrer nouveau libelle");
        a.setLibelle(scanner.next());
        System.out.println("entrer nouveau prix");
        a.setPrix(scanner.nextDouble());
        System.out.println("entrer nouvelle quantite");
        a.setQte(scanner.nextDouble());
        System.out.println("entrer Categorie- entrer id categorie");
        a.setCategorie(categorieServiceImpl.show(scanner.nextInt()));
        article.update(a);

    }

    // fonction pour afficher un article et son categorie
    private void afficherUn_article() {
        System.out.println("Entrez le id de larticle");
        // chercher l'article a afficher
        ArticleConfection a = article.findById(scanner.nextInt());
        // appel fonction toString () de Article confection
        // fonction pour afficher les valeurs
        System.out.println(a.toString() + " " + a.getCategorie().toString());

    }

    private void supprimerArticle() {
        System.out.println("Entrez le id de l'article a supprimer");
        int id = scanner.nextInt();
        article.delete(id);
    }

    public static void main(String[] args) throws Exception {
        // creation Instance app de App
        App app = new App();
        int choix;
        do {

            System.out.println("Menu");
            System.out.println("1- Ajouter catégorie");
            System.out.println("2- Lister catégorie");
            System.out.println("3- Modifier une categorie");
            System.out.println("4- Supprimer une categorie");
            System.out.println("5- Supprimer plusieurs categories");
            System.out.println("6- Ajouter un article");
            System.out.println("7- Lister  tous les articles");
            System.out.println("8- Modifier  articles");
            System.out.println("9- Lister  un articles");
            System.out.println("10- Supprimer  un article");

            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    app.ajouterCategorie();

                    // CategorieServiceImpl.add(categorie);
                    break;
                case 2:
                    app.afficherlistCategorie();
                    break;

                case 3:
                    app.modifierCategorie();
                    break;
                case 4:
                    app.supprimerCategorie();
                    break;

                case 5:
                    app.supprimerPlusieursCategorie();

                    break;

                case 6:
                    app.ajouterArticle();
                    break;
                case 7:
                    app.afficherlisteArticle();
                    break;

                case 8:
                    app.modifierArticle();
                    break;
                case 9:
                    app.afficherUn_article();
                    break;
                case 10:
                    app.supprimerArticle();
                    break;

            }

        } while (choix != 11);
    }

}
