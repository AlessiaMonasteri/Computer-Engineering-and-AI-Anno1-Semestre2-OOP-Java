Questo progetto è una Command Line Interface (CLI) sviluppata per l'esame di Object-Oriented Programming,
che permette agli utenti di autenticarsi, esplorare e gestire una libreria multimediale composta da film, canzoni, giochi e podcast.

Funzionalità principali:

LOGIN UTENTE
-Verifica delle credenziali criptate (libreria jbcrypt) 
-Verifica dell'età tramite i file users_hash.properties e user_ages.properties.

GESTIONE DELLA LIBRERIA MULTIMEDIALE
-Consultazione della libreria esistente
-Ricerca per titolo, autore, anno o genere
-Aggiunta e rimozione di media

RIPRODUZIONE DEI MEDIA
-Riproduzione di contenuti (con gestione dei contenuti VM18)
-Comandi: play, stop, next

PERSISTENZA DEI DATI
-Salvataggio della libreria aggiornata in un file CSV

GESTIONE DEI LOG
-Tracking centralizzato di eventi significativi dell’applicazione (login, operazioni CRUD, riproduzione)
-Output su file app.log

TECNOLOGIE
-Java SE 17
-Java I/O (per lettura/scrittura file .properties e .txt)
-Java Collections Framework
-CLI con Scanner e System.out
-jBCrypt per la sicurezza delle password
-java.util.logging per la gestione dei log

DESIGN PATTERNS
-Composite Pattern: usato per trattare in modo uniforme singoli media e gruppi di media.
-Iterator Pattern: usato per scorrere gli elementi della libreria.
-Factory Pattern: usato per creare dinamicamente diversi tipi di media.
-Sanitizzazione degli input: usato per migliorare la robustezza e la sicurezza ripulendo gli input inseriti.

LIMITAZIONI
-L’interfaccia è solo testuale (CLI)
-L'autenticazione e la raccolta dovrebbero essere gestiti con un database
-Manca il supporto multilingua

TEST SUITE (junit)
-Verifica del login
-Verifica corretta aggiunta/rimozione/ricerca dei media
-Test sui comandi di riproduzione
-Test Restrizione in base all'età
-Verifica presenza di entry INFO/SEVERE in app.log