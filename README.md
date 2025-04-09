Pour tester l'application, voici les étapes à suivre :

Configuration et Utilisation de l'Application
Prérequis
Java 11+
Maven
PostgreSQL
ActiveMQ
IBM MQ
Configuration
Base de Données (BDD)

Assurez-vous que PostgreSQL est installé et en cours d'exécution. Créez une base de données nommée messagerie.
    url: jdbc:postgresql://localhost:5432/messagerie
    username: postgres
    password: password

Assurez-vous que ActiveMQ est installé et en cours d'exécution.
    
IBM MQ
docker run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --publish 1414:1414 --publish 9443
:9443 --detach ibmcom/mq  
Assurez-vous que IBM MQ est installé et en cours d'exécution.

===============================================================================================

Démarrage de l'Application
Cloner le dépôt

git clone https://github.com/mouhssine65/messaging.git
cd messaging
Construire et démarrer les applications front et back

===============================================================================================

Utilisation

Envoyer un message à la file d'attente
Utilisez l'API suivante pour envoyer un message :
curl -X POST "http://localhost:8080/api/queue/send?message=cacib"

Vérifier les données dans le front-end
Accédez au front-end de l'application pour voir les données sauvegardées sur : http://localhost:4200/

Pour plus de détails, vous pouvez consulter le dépôt GitHub ici.
Si vous avez des questions ou besoin d'aide supplémentaire, n'hésitez pas à demander !
