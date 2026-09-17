# Compléments de programmation - TD 1

## Remarques préliminaires
* Avez vous lu sur persee, l'annonce "La notation et l'IA" ?
* Les commandes `git` sont à taper en ligne de commande dans un *shell bash*.
* Vous pouvez utiliser l'IDE de votre choix.
Sur le cartable numérique, [Eclipse](www.eclipse.org), [IntelliJ IDEA](http://www.jetbrains.com/idea/) et [Visual Studio Code](https://code.visualstudio.com/) sont installés.
* Vous répondrez aux questions directement dans ce fichier en complétant les emplacements correspondants.
Ajoutez ensuite ce fichier au dépôt `git`.

## Partie I (à faire durant le TD) : découverte de `git`
Dans cet exercice, vous créerez une classe `Fraction` représentant un nombre rationnel et une classe `Main` qui testera les méthodes de la classe `Fraction` **avec des assertions** (cf. [Utilisation d'assertions](https://koor.fr/Java/Tutorial/java_assert.wp)).
À chaque étape, consultez le statut des fichiers du projet (`git status`) ainsi que l'historique (`git log`).

1. Sur la forge, créez le dépôt (_repository_) `SimpleFraction`;
En terme de *commits*, quelle différence constatez-vous entre cocher une (ou plusieurs) des cases *Initialize this repository with* et n'en cocher aucune ?
    > en cochant une ou plusieurs cases "Initialize this repository with"la forge crée automatiquement un premier commit contenant les fichiers sélectionnés. En ne cochant aucune case le dépôt est créé vide, sans aucun commit initial.

    *Pour la suite, ne cochez aucune de ces cases*.
1. Localement, configurez `git` avec votre nom (`user.name`) et votre email (`user.email`) (cf. [Personnalisation de Git](https://git-scm.com/book/fr/v2/Personnalisation-de-Git-Configuration-de-Git));
    j'ai configuré Git localement avec les commandes suivantes:
    git config --global user.name "FEDY"
git config --global user.email "fedy.benelmadjat@ens.uvsq.fr"



1. Initialisez le dépôt `git` local pour le projet (cf. [Démarrer un dépôt Git](https://git-scm.com/book/fr/v2/Les-bases-de-Git-D%C3%A9marrer-un-d%C3%A9p%C3%B4t-Git));
    j'ai initialisé le dépot git local avec la commande: git init


1. Dans votre IDE, créez la classe `Fraction` (vide pour le moment) et la classe `Main` (avec un simple affichage) dans le projet (cf. [Méthode `main`](https://docs.oracle.com/javase/specs/jls/se19/html/jls-12.html#jls-12.1.4));
Vérifiez que le projet compile et s'exécute dans l'IDE;
Validez les changements (cf. [Enregistrer des modifications dans le dépôt](https://git-scm.com/book/fr/v2/Les-bases-de-Git-Enregistrer-des-modifications-dans-le-d%C3%A9p%C3%B4t));
    Après avoir créé les fichiers Fraction.java et Main.java et vérifié que le projet compile et s’exécute dans l’IDE, j’ai validé les changements dans Git avec les commandes :
    git add src/Fraction.java
    git add src/Main.java
    git commit -m "Ajout des classes Fraction et Main"

1. Ajoutez la méthode `toString` à la classe `Fraction` (cf. [`Object.toString`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Object.html#toString())) qui retournera la chaîne `"Je suis une fraction."` et modifiez la classe `Main` en conséquence;
Validez les changements;
    Fraction f = new Fraction();
    System.out.println(f.toString());

1. Publiez vos modifications sur le dépôt distant (cf. [Travailler avec des dépôts distants](https://git-scm.com/book/fr/v2/Les-bases-de-Git-Travailler-avec-des-d%C3%A9p%C3%B4ts-distants));
Vous utiliserez le protocole `https` pour cela;
Vérifiez avec le navigateur;
      git remote add github https://github.com/foudfoud/SimpleFraction.git
      git push -u github master


1. Sur la forge, ajoutez un fichier de documentation `README.md`.
Quelle syntaxe est utilisée pour ce fichier ?
    Le fichier README.md utilise la syntaxe Markdown.
1. Récupérez localement les modifications effectuées sur la forge.
    git pull origin master

1. Ajoutez les répertoires et fichiers issus de la compilation aux fichiers ignorés par `git` (cf. [`.gitignore` pour Java](https://github.com/github/gitignore/blob/main/Java.gitignore));
    # Contenu de .gitignore pour les fichiers de compilation
    *.class
    out/
    target/
    bin/

1. Retirez les fichiers de configuration de l'IDE du projet;
    git rm -r --cached .idea/ *.iml .vscode/
    git commit -m "Retrait des fichiers de configuration de l'IDE"

    Ajoutez-les aux fichiers ignorés par `git`.
    # Ajout dans .gitignore
    .idea/
    *.iml
    .vscode/


1. Configurez l'accès par clé publique/clé privée à la forge (cf. [Connecting to GitHub with SSH](https://docs.github.com/en/authentication/connecting-to-github-with-ssh)).
    Pour configurer l’accès à la forge avec une authentification SSH, on commence par générer une paire de clés publique et privée sur sa machine, puis on copie la clé publique afin de l’ajouter dans les paramètres du compte sur la forge, ensuite on teste la connexion pour vérifier que l’authentification fonctionne correctement, et enfin on utilise l’URL SSH du dépôt pour effectuer les opérations Git en toute sécurité.

## Partie II (à faire durant le TD) : compléter la classe `Fraction`
Dans cet partie, vous compléterez les classes `Fraction` et `Main`.
Un exemple d'interface pour une telle classe est donné par la classe [`Fraction`](http://commons.apache.org/proper/commons-math/javadocs/api-3.6.1/org/apache/commons/math3/fraction/Fraction.html) de la bibliothèque [Apache Commons Math](http://commons.apache.org/math/).

Vous respecterez les consignes ci-dessous :
* chaque méthode de `Fraction` sera testée dans `Main` **avec des assertions** (cf. [Utilisation d'assertions](https://koor.fr/Java/Tutorial/java_assert.wp));
* à la fin de chaque question, consultez le statut des fichiers du projet (`git status`) ainsi que l'historique (`git log`) puis validez les changements.

1. Ajoutez les attributs représentants le numérateur et le dénominateur (nombres entiers).
    ```Java
    private int numerator;
    private int denominator;
    ```
1. Ajoutez les constructeurs (cf. [Constructor Declarations](https://docs.oracle.com/javase/specs/jls/se19/html/jls-8.html#jls-8.8)) suivants :
    * initialisation avec un numérateur et un dénominateur,
    * initialisation avec juste le numérateur (dénominateur égal à _1_),
    * initialisation sans argument (numérateur égal _0_ et dénominateur égal à _1_), 
    ```Java
    Fraction f1 = new Fraction(3, 4);
    Fraction f2 = new Fraction(5);
    Fraction f3 = new Fraction();
    assert f1.toString().equals("Je suis une fraction.");
    assert f2.toString().equals("Je suis une fraction.");
    assert f3.toString().equals("Je suis une fraction.");
    ```
1. Ajoutez les fractions constantes ZERO (0, 1) et UN (1, 1) (cf. [Constants in Java](https://www.baeldung.com/java-constants-good-practices)),
    ```Java
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction UN = new Fraction(1, 1);
    ```
1. Ajoutez une méthode de consultation du numérateur et du dénominateur (par convention, en Java, une méthode retournant la valeur de l'attribut `anAttribute` est nommée `getAnAttribute`),
    ```Java
    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }
    ```
1. Ajoutez une méthode de consultation de la valeur sous la forme d'un nombre en virgule flottante (méthode `doubleValue()`) (cf. [`java.lang.Number`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Number.html)),
   ```Java
    assert Math.abs(f1.doubleValue() - 0.75) < 1E-8;
    assert Math.abs(f2.doubleValue() - 5.0) < 1E-8;
    assert Math.abs(f3.doubleValue() - 0.0) < 1E-8;
    ```
1. Ajoutez une méthode permettant l'addition de deux fractions (la méthode `add` prend en paramètre *une* fraction et *retourne* la somme de la fraction courante et du paramètre),
   ```Java
    Fraction sum = new Fraction(1, 2).add(new Fraction(1, 3));
    assert Math.abs(sum.doubleValue() - (5.0 / 6.0)) < 1E-8;
    ```
1. Ajoutez le test d'égalité entre fractions (deux fractions sont égales si elles représentent la même fraction réduite) (cf. [`java.lang.Object.equals`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object))),
   ```Java
    assert new Fraction(1, 2).equals(new Fraction(2, 4));
    assert !new Fraction(1, 2).equals(new Fraction(1, 3));
    ```
1. Ajoutez la comparaison de fractions selon l'ordre naturel (cf. [`java.lang.Comparable`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Comparable.html)).
   ```Java
    assert new Fraction(1, 2).compareTo(new Fraction(1, 3)) > 0;
    assert new Fraction(1, 3).compareTo(new Fraction(1, 2)) < 0;
    assert new Fraction(1, 2).compareTo(new Fraction(2, 4)) == 0;
    ```
1. Faites hériter votre classe `Fraction` de la classe [`java.lang.Number`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Number.html) et complétez les méthodes
   ```Java
    // Vérifiez avec le code ci-dessous
    Number aNumber = java.math.BigDecimal.ONE;
    Number anotherNumber = new Fraction(1, 2);
    assert java.lang.Math.abs(aNumber.doubleValue() + anotherNumber.doubleValue() - 1.5) < 1E-8;
    ```

## Partie III (à faire à la maison) : révisions et perfectionnement *shell* et *IDE*
### Maîtriser le *shell* de commandes
L'objectif de cet exercice est de vous faire réviser/découvrir les commandes de base du *shell* de votre machine.
Vous pouvez répondre en utilisant le shell de votre choix (*bash*, *Powershell*, …).
Pour répondre à ces questions, vous devez effectuer les recherches documentaires adéquates (livre, web, …).

1. Quel OS et quel shell de commande utilisez-vous ?
    > J'utilise Windows 11 avec Windows PowerShell 5.1 comme shell de commande.
1. Quelle commande permet d'obtenir de l'aide ?
Donnez un exemple.
    
    Get-Help Get-ChildItem
    
1. Donnez la ou les commandes shell permettant de
    1. afficher les fichiers d'un répertoire triés par taille (taille affichée lisiblement)
        
       > Get-ChildItem | Sort-Object Length -Descending | Format-Table Name, @{Name="Taille";Expression={"{0:N2} Ko" -f ($_.Length/1KB)}}
        
    1. compter le nombre de ligne d'un fichier
        
        >(Get-Content Main.java | Measure-Object -Line).Lines
        
    1. afficher les lignes du fichier `Main.java` contenant la chaîne `uneVariable`
        
        >Select-String -Path Main.java -Pattern "uneVariable"
        
    1. afficher récursivement les fichiers `.java` contenant la chaîne `uneVariable`
        
        >Get-ChildItem -Recurse -Filter *.java | Select-String -Pattern "uneVariable"
        
    1. trouver les fichiers (pas les répertoires) nommés `README.md` dans une arborescence de répertoires
        
        >Get-ChildItem -Recurse -Filter README.md -File
    
    1. afficher les différences entre deux fichiers textes
        
        >Compare-Object (Get-Content fichier1.txt) (Get-Content fichier2.txt)
    
        
1. Expliquez en une ou deux phrases le rôle de ces commandes et dans quel contexte elles peuvent être utiles pour un développeur.
    * `ssh`
        >  Permet d'ouvrir une connexion chiffrée vers une machine distante (shell interactif, exécution de commandes, ou transport pour `git`/`scp`). Indispensable pour administrer un serveur à distance ou s'authentifier de façon sécurisée sur une forge Git.
    * `screen`/`tmux`
        > Multiplexeurs de terminal permettant de créer plusieurs sessions/fenêtres dans un seul terminal et surtout de les détacher : un programme lancé dans une session `tmux` continue de tourner même après déconnexion SSH, puis on peut s'y rattacher plus tard. Très utile pour des tâches longues sur un serveur distant.
    * `curl`/[HTTPie](https://httpie.org/)
        > Permettent d'envoyer des requêtes HTTP (GET, POST, etc.) directement en ligne de commande, sans navigateur. Pratique pour tester une API REST, télécharger un fichier, ou déboguer un service web.
    * [jq](https://stedolan.github.io/jq/)
        > Outil en ligne de commande pour filtrer, extraire et transformer du JSON (par exemple la sortie d'une commande `curl`). Utile pour scripter des traitements sur des réponses d'API sans écrire de code dans un langage complet.

### Découverte de votre *IDE*
Dans cet exercice, vous expliquerez en quelques phrases comment vous réalisez les actions ci-dessous dans votre IDE.
Vous pouvez choisir l'IDE/éditeur de texte de votre choix.
Pour réaliser cette exercice, vous devez bien évidemment vous reporter à la documentations de l'IDE ([IntelliJ IDEA](https://www.jetbrains.com/help/idea/discover-intellij-idea.html#developer-tools), [Visual Studio Code](https://code.visualstudio.com/docs), [Eclipse](https://help.eclipse.org/2020-09/index.jsp), …).

1. Quels IDE ou éditeurs de texte utilisez-vous pour le développement Java ?
    > J'utilise Vscode, avec l'extension "Extension Pack for Java" 

    Pour la suite, ne considérez que l'un de vos choix.
1. Comment vérifier/définir que l'encodage utilisé est *UTF-8* ?
    > En bas à droite de la fenêtre VS Code, une zone indique l'encodage du fichier ouvert (ex. "UTF-8"). En cliquant dessus, on peut choisir "Reopen with Encoding" ou "Save with Encoding" pour changer l'encodage. On peut aussi fixer un encodage par défaut pour tout le projet via le paramètre `files.encoding` dans `settings.json`.
1. Comment choisir le JDK à utiliser dans un projet ?
    > Avec l'extension Java, on ouvre la palette de commandes (`Ctrl+Maj+P`) puis "Java: Configure Java Runtime", ou on édite directement le paramètre `java.configuration.runtimes` dans les settings pour indiquer le chemin d'un ou plusieurs JDK installés et lequel utiliser par défaut.
1. Comment préciser la version Java des sources dans un projet ?
    > Dans un projet géré par Maven, on définit la propriété `maven.compiler.source`/`maven.compiler.target` dans le `pom.xml`. Sans build tool, on peut fixer `java.project.sourcePaths` et  `java.configuration.runtimes` dans les settings de VS Code.
1. Comment ajouter une bibliothèque externe dans un projet ?
    > Pour un projet Maven/Gradle, on ajoute la dépendance dans `pom.xml`/`build.gradle`. Pour un projet simple, on peut aussi ajouter le chemin d'un `.jar` via le paramètre `java.project.referencedLibraries` dans les settings, ou en le glissant dans un dossier `lib/` référencé par ce paramètre.
1. Comment reformater un fichier source Java ?
    > Clic droit dans l'éditeur puis "Format Document", ou raccourci `Maj+Alt+F` (Windows).
1. Comment trouver la déclaration d'une variable ou méthode ?
    > `Ctrl+Clic` sur le symbole, ou `F12` ("Go to Definition") avec le curseur positionné dessus.
1. Comment insérer un bloc de code prédéfini (*snippet*) ?
    > On commence à taper le nom du snippet (ex. `sysout`, `psvm`, `for`) et VS Code propose une complétion ; `Tab`/`Entrée` insère le bloc de code correspondant avec les champs à compléter.
1. Comment renommer une classe dans l'ensemble du projet ?
    > On sélectionne le nom de la classe dans l'éditeur puis `F2` ("Rename Symbol") : VS Code renomme automatiquement toutes les occurrences dans le projet, y compris le nom du fichier.
1. Comment exécuter le programme en lui passant un paramètre en ligne de commande ?
    > Dans `.vscode/launch.json`, on ajoute le champ `"args": ["monParametre"]` à la configuration de lancement, puis on démarre le débogage/l'exécution (`F5`) avec cette configuration. 
1. Comment déboguer le programme en visualisant le contenu d'une ou plusieurs variables ?
    > On place un point d'arrêt (clic dans la marge à gauche du numéro de ligne) puis on lance en mode débogage (`F5`). À l'arrêt, le panneau "Variables" de la vue Debug affiche le contenu des variables locales, et on peut aussi ajouter des expressions dans "Watch" ou survoler une variable dans l'éditeur.
1. Quels paramètres ou fonctionnalités vous semblent particulièrement importants/utiles pour le développement Java ?
    > La complétion/autocomplétion intelligente et la navigation, le renommage automatique à travers tout le projet, la coloration des erreurs de compilation en temps réel, l'intégration Git, et le débogueur intégré avec points d'arrêt et inspection de variables.
