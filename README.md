
# Projet d'Architecture Logicielle 4A ESIEA

## Tetris par Pierre-Ange Fourcade et Sami Kartit

##### Building

Pour lancer le projet :

``` mvn clean install && java -jar target/*.jar ```

##### Features

  - 7 pièces ont été créés
  - Les saisies du clavier sont récupérées à l'aide de RawConsoleInput
  - La pièce peut être descendue, tournée, déplacée à gauche et à droite
  - Détection de ligne pleine et restructuration de la grille
  - Détection de "game over"
  - Le score du joueur est comparé à une liste des 5 meilleurs scores déjà réalisés

##### Comment jouer ?

Voici les commandes du jeu :

| Commande     | Description                    |
|--------------|:------------------------------:|
| ```Z```      | Fait pivoter la piece          |
| ```S```      | Fait descendre la piece        |
| ```Q```      | Décale la piece vers la gauche |
| ```D```      | Décale la piece vers la droite |

##### Architecture

  + Modèle : ce composant gère les données du jeu. Il récupére les informations du Tétromino, de la grille et du score, elles sont ensuites transmises au contrôleur pour être traitées.
  + Vue : ce composant affiche la grille du jeu avec le tétromino qui se déplace. Une fois la partie terminée, elle affiche la liste des 5 meilleurs scores.
  + Contrôleur : ce composant gère la logique du jeu et les règles qui le régit. C'est l'intermédiaire entre le modèle et la vue : le contrôleur va demander au modèle les données puis les traiter avant de les renvoyer à la vue pour l'affichage.

##### Design patterns et SOLID

  + DAO : Ce design pattern est utilisé pour gérer le fichier CSV des highscores. Il permet de récupérer ces donneés.
  + Listener : Il sert à récupérer les événements qui interargissent avec le déroulement du jeu, notamment les touches du clavier pour les déplacements grâce à RawConsoleInput.
  + Single Responsibility Principle : Chaque classe possède plusieurs méthodes qui n'ont qu'un unique but, il nous est alors plus facile de faire des extensions ou de corriger des défauts.
  + Façade : Une unique interface simple (```Game```) nous permet de masquer la complexité sous-jacente au code de l'application.
