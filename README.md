# Geocache

Geocache est une application console permettant à un développeur Java de tester l'ORM Hibernate, à partir d'une base de données déjà conçue.

# Pré-requis
  - Intellij Idea 2020.3.2 (le succès de la procédure d'installation n'est pas garanti sur une version plus ancienne).
  - (Optionnel) Docker [(Procédure d'installation)](https://docs.docker.com/engine/install/)
  - Java 11

# Installation
  1. Récupérer le projet via Github 
```sh 
git clone https://github.com/NathanSalez/geocache-2021.git
```
  2. Lancer la base de données via Docker ou la créer à l'aide du script présent dans **sql/creationbdd.sql**
```sh
docker create volume v-mysql
docker run --name mysql-server -p <port_hote>:3306 -v v-mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=<mdp> -d nsalez/geocache-sql:1.0
```
  3. Ouvrir le projet sur Intellij Idea
  4. Modifiez le fichier hibernate.cfg.xml de façon à ce que l'application puisse se connecter à la base de données lancée.
  5. Sur Intellij Idea, ajouter un nouveau point d'exécution de type **Application** en cliquant sur "Add Configurations..." ayant pour classe principale **Main**.
  6. Exécutez l'application !
