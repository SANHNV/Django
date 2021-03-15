# TP DJANGO

+ use Java 8

## I. Injection de dépendance
+ Ajouter ApplicationContext dans Main
+ Annoter la classe utilisant la dépendance et la dépendance : @Component
+ Annoter la private dépendance : @Autowired
+ /!\ Créer une instance (pas de *new*) : appContext.getBean(ProductDAO.class);

## II. Hibernate
+ add hibernate dependance in build.gradle
+ POJO :
    + product : ID, Name (String), ProductCode (Integer), Quantity (double), LimiteDate (timeStamp), Image (String)
    + user : ID, Login (String), Password (String)
+ add annotations to pojo
+ Hibernate :
    + Edit config hibernate : use thread
    + Try connection to database
    + Create configuration


+ SessionFactory handle Session (atomic use => transaction)
+ Session handle Transaction (begin, commit, roolback)
+ hibernate.properties or hibernate.cfg.xml :
    + properties general (db, ...)
    + class objects to persiste
    + initialize hibernate,...
+ class to persist => POJO (Plain Old Java Object)
    + constructor public without param
    + attributes simples with getter & setter
    + ...
+ ...
+ Equals(), hashCode(), == :
    + Equals() for value
    + == for ref address
    + hashCode for the object hashed
+ ORM
    + annotations
    + use Session