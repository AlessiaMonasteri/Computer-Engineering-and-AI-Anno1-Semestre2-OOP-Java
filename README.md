Questo progetto è una Command Line Interface (CLI) sviluppata per l'esame di Object-Oriented Programming,
che permette agli utenti di autenticarsi, esplorare e gestire una libreria multimediale composta da film, canzoni, giochi e podcast.

Funzionalità principali:

LOGIN UTENTE
-Verifica delle credenziali criptate (libreria jbcrypt) con il file Utils\users_hash.properties;
-Verifica dell'età tramite il file Utils\user_ages.properties per la riproduzione di contenuti con restrizione.

GESTIONE DELLA LIBRERIA MULTIMEDIALE
-Consultazione della libreria esistente;
-Ricerca per titolo, autore, anno o genere;
-Aggiunta e rimozione di media.

RIPRODUZIONE DEI MEDIA
-Comandi: play, stop, next.

PERSISTENZA DEI DATI
-Salvataggio della libreria aggiornata in un file CSV (MainApp\media_library.csv)

GESTIONE DEI LOG
-Tracking degli eventi significativi dell’applicazione (login, operazioni CRUD, riproduzione) con output su Utils\Log\app.log.

TECNOLOGIE
-Java SE 17
-Java I/O
-Java Collections Framework
-CLI con Scanner e System.out
-jBCrypt per la sicurezza delle password
-java.util.logging per la gestione dei log

DESIGN PATTERNS
-Composite Pattern: usato per trattare in modo uniforme singoli media e gruppi di media.
-Iterator Pattern: usato per scorrere gli elementi della libreria.
-Factory Pattern: usato per creare dinamicamente diversi tipi di media (game/movie/song/podcast).
-Sanitizzazione degli input: usato per migliorare la robustezza e la sicurezza ripulendo gli input inseriti dai simboli.

LIMITAZIONI
-L’interfaccia è testuale (CLI), ulteriori implementazioni implicherebbero l'uso di Java Swing o simili;
-La raccolta dovrebbe essere gestita con un database;
-Non è presente un supporto multilingua;
-Le informazioni sull'età sono facilmente modificabili, dovrebbero essere gestite con un file codificato (es.Base64, un sistema di codifica binario–testuale) per scoraggiare la modifica del file users_ages.properties, oppure gestire le date di nascita con un db.
-Non è presente un Gestore Utenze: al momento le users sono fisse e modificabili solo manualmente con il file users_ages e facendo uso dell'utility PasswordHasher.
Si potrebbero implementare in una classe aggiuntiva l'aggiunta (admin only), la rimozione (admin-only) e lo switch dell'account(all users).

TEST SUITE (junit)
-Verifica del login
-Verifica corretta aggiunta/rimozione/ricerca dei media
-Test sui comandi di riproduzione
-Test Restrizione in base all'età