Repository Github destiné aux personnes à qui je donne des cours d'algorithme/programmation et de TDD.

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)


## Algorithmes présents

### Tris

#### Tri à Bulles

Le tri à bulles est un tri consistant à trier un ensemble d'éléments en les comparant un à un.

**Exemple** : 15 2 20 3 

On commence par le premier nombre d'indice 0 qui est 15.

**Etape 1** : 

On commence par comparer 15 et 2, 15 > 2 donc on échange les places de 15 et 2

**15** 2 20 3 devient 2 **15** 20 3 

On continue avec le deuxième nombre d'indice 1 qui est toujours 15 (grâce à l'échange).

On compare 15 et 20, 15 n'est pas plus grand que 20, on n'échange pas.

On continue avec le troisième nombre d'indice 2 qui est 20.

On compare 20 et 3, 20 > 3 donc on échange les places de 20 et 3

2 15 **20** 3 devient 2 15 3 **20**

On est arrivé à la fin du tableau. On constate que le tableau n'est toujours pas trié. On recommence donc
l'étape de comparaisons jusqu'à que le tableau soit complètement trié.

**Etape 2** : 

2 > 15 ? Non, on n'échange pas.

15 > 3 ? Oui, on échange 15 et 3

2 **15** 3 20 devient 2 3 **15** 20

15 > 20 ? Non, on échange pas

2 3 15 20, le tableau est trié, on s'arrête.

#### Tri Cocktail

Le tri cocktail est une variante du tri à bulles. Le fonctionnement est similaire sauf au niveau du sens
de parcours des comparaisons. En effet, on trie dans un premier temps de la gauche vers la droite, puis
dans un deuxième temps de la droite vers la gauche et on continue l'alternance jusqu'à que le tableau soit
complètement trié. C'est un peu comme le cocktail (on secoue les ingrédients dans tous les sens pour obtenir le cocktail,
d'où le tri cocktail / shake sort).

**Exemple** : 15 2 20 3 

**Etape 1 (gauche vers la droite)** : 

On commence par comparer 15 et 2, 15 > 2 donc on échange les places de 15 et 2

**15** 2 20 3 devient 2 **15** 20 3 

On continue avec le deuxième nombre d'indice 1 qui est toujours 15 (grâce à l'échange).

On compare 15 et 20, 15 n'est pas plus grand que 20, on n'échange pas.

On continue avec le troisième nombre d'indice 2 qui est 20.

On compare 20 et 3, 20 > 3 donc on échange les places de 20 et 3

2 15 **20** 3 devient 2 15 3 **20**

On est arrivé à la fin du tableau. On constate que le tableau n'est toujours pas trié. Sauf que
la prochaine étape de comparaison se fera de la droite vers la gauche !

**Etape 2 (droite vers la gauche)** :

3 > 20 ? Non, on n'échange pas

15 > 3 ? Oui, on échange

2 **15** 3 20 devient 2 3 **15** 20

2 > 3 ? Non, on n'échange pas

On est arrivé à la fin du tableau, le tableau est trié.

2 3 15 20, le tableau est trié, on s'arrête.

#### Tri Pair-Impair

Le tri Pair-Impair est une variante du tri à bulles. Ce tri consiste à
effectuer des comparaisons avec des nombres d'indices paires/impaires puis effectuer 
des comparaisons avec des nombres d'indices impaires/paires du tableau à trier.

**Exemple** : 15 2 20 3

Etape 1 : Comparaison des nombres à indices paires/impaires

15 > 2 ? Oui, on échange   (indice 0)

**15** 2 20 3 devient 2 **15** 20 3

20 > 3 ? Oui, on échange (indice 2)

2 15 **20** 3 devient 2 15 3 **20**

Etape 2 : Comparaison des nombres à indices impaires/paires

Rappel : le tableau est actuellement 2 15 3 20

15 > 3 ? Oui, on échange (indice 1)

2 **15** 3 20 devient 2 3 **15** 20

On ne peut pas continuer les comparaisons, car le prochain indice est 3 et
indice+1 qui est 4 n'existe pas.

2 3 15 20, le tableau est trié, on s'arrête. Bien entendu, si le tableau n'était pas trié
on recommencerait les comparaisons paires/impaires et impaires/paires.

#### Tri peigne

#### Tri rapide

#### Tri fusion

### Chaînes de caractères

#### Palindrome

Un palindrome est un mot qui peut se lire indifféremment de la gauche
vers la droite ou de la droite vers la gauche tout en gardant le même sens.

**Exemples** : sexes, radar, non, pop, tôt

#### FizzBuzz

L'algorithme du FizzBuzz consiste à afficher une liste de nombres entre N et M, deux nombres. 
Parmi ces nombres affichés, si on tombe sur un multiple de 3, ce nombre est remplacé par Fizz, si
on tombe sur un multiple de 5, ce nombre est remplacé par Buzz et si on tombe sur un
multiple de 3 et un multiple de 5, ce nombre est remplacé par FizzBuzz.

**Exemple** : Génération d'une chaîne FizzBuzz à partir de 1 jusqu'à 30 

12Fizz4BuzzFizz78FizzBuzz11Fizz1314Fizzbuzz1617Fizz19BuzzFizz2223FizzBuzz26Fizz2829Fizzbuzz

### Nombres

#### Nombres premiers

Un nombre premier n'est qu'un nombre qui se divise par 1 et lui-même. On en déduit donc
qu'il ne peut pas être divisible par un autre nombre.

**Exemple** : 3 est un nombre premier car il est divisible que par 1 et lui-même.

Pour trouver l'ensemble des nombres premiers jusqu'à N, il suffit de vérifier que pour chacun
de ses nombres jusqu'à N, si ce dernier est divisible par un autre nombre (en dehors de 1 et lui-même,
autre nombre >= 2).

**Exemple** : Générons des nombres premiers jusqu'à 10 

* 0 n'est pas premier car il est divisible par tous les nombres positifs.
* 1 n'est pas premier car il n'a qu'un seul diviseur (lui-même).
* 2 est premier car il n'est divisible que par 1 et lui-même.
* 3 est premier car il n'est divisible que par 1 et lui-même.
* 4 n'est pas premier car 4 % 2 = 0.
* 5 est premier car il n'est divisible que par 1 et lui-même.
* 6 n'est pas premier car 6 % 2 = 0.
* 7 est premier car il n'est divisible que par 1 et lui-même.
* 8 n'est pas premier car 8 % 2 = 0.
* 9 n'est pas premier car 9 % 3 = 0.
* 10 n'est pas premier car 10 % 2 = 0.

**Résultats** : 2, 3, 5, 7

### Structures de données 

#### Liste chaînée

Description en cours...

#### Liste doublement chaînée

Description en cours...

#### Liste chaînée circulaire

Description en cours...

### Arbre

#### Arbre binaire de recherche

Description en cours...

### Graphes

#### Dijkstra

Description en cours...