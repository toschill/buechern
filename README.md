buechern
========

#Web Tech Projekt 2014 Buecher-Verkauf-Service#

Webtech 			büchern			15.01.2015
Team 6: Bastian Kopf, Fabian Ambrosi, Tobias Schiller

##Dokumentation zur des Portals büchern.de##

http://buechern.herokuapp.com/

Um büchern.de auf Heroku bzw. lokal vollständig testen zu können, ist es wichtig sich zunächst zu registrieren. Das Registrierungsformular kann über die Profil-Seite aufgerufen werden. Zum Anmelden wird der Vorname und das Passwort benötigt. Anschließend können Bücher über die Verkaufen-Seite eingestellt und bereits eingestelle Bücher über die Einkaufen Seite gekauft werden. Um den Kaufprozess zu testen, empfiehlt es sich zunächst zu registrieren und ein oder mehrere Bücher anzulegen. Mit einer zweiten Registrierung kann dann beispielsweise ein Buch gekauft werden. Diese Transaktionen werden anschließend auf der Profil-Seite des jeweiligen Accounts angezeigt.

###Das Team###

<strong>Fabian Ambrosi:</strong>  
Studiengang: Wirtschaftsinformatik  
Vertiefungsrichtung: SSE  
Fachsemester: 7

<strong>Tobias Schiller:</strong>  
Studiengang: Wirtschaftsinformatik  
Vertiefungsrichtung: SSE  
Fachsemester: 7

<strong>Bastian Kopf:</strong>  
Studiengang: Wirtschaftsinformatik  
Vertiefungsrichtung: SSE  
Fachsemester: 7

###Motivation
Im Rahmen der Vorlesung Webtechnologien im Wintersemester 14/15, soll von den Studenten eine Webseite bzw. ein Portal erstellt werden. Hierfür bilden die Studenten jeweils Gruppen zu zwei bzw. drei Personen. Um dieses Portal zu erstellen haben sich Fabian Ambrosi, Tobias Schiller und Bastian Kopf als Gruppe zusammen gefunden. Für das Thema der Webseite (des Portals) wurde den Studenten freie Wahl gelassen. Somit konnten die unterschiedlichsten Interessen mit eingebunden werden. 


###Beschreibung der Idee 
Um ein solches Portal aufzubauen zu können, musste zunächst ein passendes Thema gefunden werden. Wichtig war es dabei auch darauf zu achten, das Thema nicht zu groß zu wählen, da die gesamte Umsetzung im Rahmen der Vorlesung bzw. der dazugehörigen Übung durchgeführt werden sollte. Während des Studiums werden oftmals Bücher passend zu Vorlesungen gekauft. Meist werden diese Bücher von Professoren für eine gewisse Vorlesung empfohlen. Nach dem Semester werden diese Bücher dann häufig an Studenten aus tieferen Semestern weiterverkauft, da diese die Bücher für die Vorlesung erneut verwenden können. Diesen Sachverhalt greift büchern.de auf und bietet eine Plattform Bücher, passend zu Vorlesungen, an andere Studenten weiterzuverkaufen.

###Anforderungsanalyse  

####Funktionale Anforderungen  
* Der User soll sich Registrieren können (Persönliche Daten - Benutzername - E-Mail-Adresse-Passwort)
* Der User soll sich anschließend anmelden können (Benutzername und Passwort)
* Der User soll eine Liste von bereits eingestellten Büchern auf der Einkaufen-Seite sehen
* Der User soll selbst Bücher zum verkauf einstellen können
* Der User soll in seinem Profil sehen wenn er ein Buch gekauft hat
* Der User soll in seinem Profil sehen wenn eines seiner eingestellten Büchern Verkauft wurde und an wen
* Der User soll seine E-Mail-Adresse und sein Passwort ändern können
* Der User soll auf der Einkaufen Seite nach Büchern suchen können
* Der User soll über den Status (Bsp. neues Buch wurde eingestellt) im Footer informiert werden

####Nichtfunktionale Anforderungen    
* •	Versionskontrolle  über GitHub  
Dies soll auch gleichzeitig die Möglichkeit bieten unter "realen" Gesichtspunkten zu entwickeln.
Hierbei sollen Branches verwendet werden und somit Verteilt an dem Portal arbeiten zu können.

####Use-Case-Diagramm    
<img height="300px" src="https://github.com/toschill/buechern/blob/master/Planung/usecase_v2.png"/>

#####Abläufe: (Aus der ersten Planung des Portals)  
Nutzer des Portals müssen sich zunächst im Portal registrieren (Log-In).
Anschließend kann der User nach den unterschiedlichen Kriterien suchen bzw. ein Buch zum Verkauf anbieten.
Möchte der User ein Buch verkaufen, muss er zunächst Angaben zum Buch machen.
Hierfür ist vorgesehen, dass Titel, Autor, Erscheinungsjahr, Auflage und Zustand (ISBN) und Preis eingetragen werden. 
Es soll die Möglichkeit geben, ein Buch einer Vorlesung (eine Vorlesung gehört zu einem Professor) zuzuweisen. Somit kann nicht nur nach dem Titel / Autor gesucht werden, sondern auch nach einzelnen Vorlesungen.
Bei der Suche nach einer Vorlesung soll dem User eine Liste der vom Professor empfohlenen Bücher angezeigt werden. Hier kann der User in Erfahrung bringen, ob dieses Buch von einem anderen User angeboten wird. 

###Planung des Portals büchern.de  
Die MockUps wurden jeweils mit Photoshop erstellt

####MockUp des Portals  
<img height="400px" src="https://github.com/toschill/buechern/blob/master/Planung/mockup.JPG"/>

####Responsive Design MockUp des Portals  
<img height="450px" src="https://github.com/toschill/buechern/blob/master/Planung/mockup_responsive.JPG"/>

###Architektur  

####Komponenten Diagramm  

####Klassendiagramm  

####Sequenzdiagramm  

###Eingesetzte Technologien  

####HTML5  
HTML5 ist die aktuelle Version von HTML (Hypertext Markup Language)
Diese Sprache wird primär dazu verwendet, Inhalte von Webseiten im Browser Darstellung zu lassen. Diese Technologie wurde im Rahmen des Portals dazu verwendet, die Seite aufzubauen und die Inhalte im Browser für den User verständlich auszuspielen.   Beispiele: http://www.w3schools.com/htmL/html5_intro.asp

####CSS3  
Bei CSS3 handelt es sich um die aktuelle Version von CSS (Cascading Style Sheets).
In der neusten Version wurden viele neue Regeln für das Styling von Webseiten mit eingebracht. Zusätzlich werden mit der neuen Version neue Selektoren und Stylingmöglichkeiten bereitgestellt. Somit kann effektiver am Aufbau von Webseiten gearbeitet werden.  
Beispiele: http://www.w3schools.com/htmL/html_css.asp

####Responsive Design von Hand  
Responsive Design bedeutet, dass sich eine Webseite sowohl auf stationären als auch auf mobilen Endgeräten ohne Einschränkungen darstellen lässt. Hierbei können unterschiedliche Ansätze verfolgt werden. Das responsive Design von büchern.de wurde von Hand umgesetzt. Dabei wurde darauf geachtet, einzelne Boxen nicht statisch (durch Angabe von Pixeln) sondern Dynamisch (durch %-Angaben) zu erstellen. Dies ermöglicht es, dass eine Box sich prozentual der Größe des Displays eines Gerätes Anpasst. Ebenso wurde dieser Ansatz für Bilder verfolgt. Bei der Anordnung der einzelnen Boxen, beispielsweise auf der Einkaufen Seite, auf welcher bereits eingestellte Bücher dargestellt werden. Wurde zusätzlich mit Media Queries gearbeitet. Diese ermöglichen es, eine Seite nicht nur prozentual anzupassen, sondern auch, eine gesamte Webseite bei einer bestimmten Display Größe auf eine bestimmte Art darzustellen. Ein bekanntes Beispiel hierfür ist die Navigation einer Webseite. Stationär werden oftmals ganze Leisten für die Navigation angezeigt, wogegen bei kleineren mobilen Endgeräten oftmals lediglich ein Symbol dargestellt wird, über welches eine DropDown Navigation eingeblendet werden kann. Dieser Ansatz des Menüs wurde bei büchern.de unteranderem auch verwendet.

####PlayFramework  
Play ist ein OpenSource Web Application Framework, welches in Scala und Java geschrieben wurde. Das Framework unterstützt die Programmiersprache Scala. Das Framework ermöglicht es innerhalb einer Entwicklungsumgebung, alle Funktionalitäten der Webseite in Java zu entwickeln. Es unterstützt außerdem das einbinden einer SQLite Datenbank und kann hierbei die dementsprechenden Abfragen verstehen und anwenden. Das gesamte Portal Büchern.de wurde unter Play entwickelt. Aus diesem Grund findet man auch beispielsweise auf den einzelnen Seiten die jeweiligen Scala Annotationen. Ein Bespiel hierfür sind die @main Annotationen, welche auf jeder Unterseite (im HTML Code) im oberen Bereich gefunden werden können. Diese Annotationen sind das Gegenstück zu einem PHP-Include.

####Datenbank  
Die Datenbank, für die Userregistrierung bzw. Anmeldung, und auch für die Einstellung und den Verkauf von Büchern, wurde über SQLite realisiert. SQLite ist eine lightweight Lösung zu SQL Datenbanken. Hierbei wird keine Installation von beispielsweise MySQL benötigt. Über diese Technologie kann eine Datenbank erzeugt werden, in welcher anschließend die jeweiligen Tabellen angelegt werden können. Diese DB-Datei wird dann im dementsprechenden Ordner (im Dateisystem) der Webseite untergebracht. Die Webseite kann nun auf die Datenbank zugreifen und es können Inhalte gelesen und geschrieben werden.

####Ajax  
Ajax ist eine Technologie zum Asynchronen Nachladen von Inhalte einer Webseite. Dies bedeutet, dass auf einer bereits vollständig geladenen Webseite weitere Daten zusätzlich hinzugeladen werden. Man spricht dabei auch von einer DOM-Manipulation. Ein bekanntes Beispiel hierfür ist es, wenn man auf einer Webseite verschiedene Einträge anzeigt bekommt (z.B. in einem Gästebuch). Wenn man am Ende der Seite angelangt ist muss man auf die nächste Seite wechseln (Paginierung). Ajax ermöglicht es hierbei, einen Inhalt direkt unten auf der Seite anzuhängen und somit die Inhalte der Seite zu erweitern. Oftmals wird Ajax auch bei der Suche nach Inhalten verwendet. Auf büchern.de wurde Ajax für die Suche auf der Einkaufen-Seite verwendet. Sucht man hier nach einem Titel wird nach jedem Tastendruck (onkeyup-Event) in der Datenbank nach einem Treffer gesucht. Dieser wird dann sofort auf der Seite angezeigt. Drückt man also als erstes ein <strong>a</strong>, werden lediglich die Bücher angezeigt bei denen ein a in beispielsweise Titel, Autor oder ähnlichem enthalten ist.

####Websockets und Observer-Pattern  
Websockets wurden auf büchern.de dazu verwendet, den aktuellen Status der Webseite an den Besucher weiterzugeben. Hierfür wurde ein Platzhalter im Footer definiert. An dieser Stelle werden dem User die Updates angezeigt. Es wird hierbei immer das letzte Ereignis darstellt. Ein Beispiel hierfür ist "Neues Buch wurde eingestellt".

###Deployment Herokuapp

###Ergebnis  
Das Ergebnis dieses Projekts ist ein nahezu fertiges Portal Büchern.de. Für einen tatsächlichen Go-Live müssten jedoch zunächst weitere Funktionalitäten entwickelt und eingebaut werden, welche es den Usern erleichtern Büchern zu Verkaufen und zu Kaufen. Diese Können im letzten Punkt der Dokumentation eingesehen werden.
Büchern.de bietet jedoch jetzt schon die Möglichkeiten und Funktionen, welche auch in der ersten Anforderungsanalyse aufgestellt wurden. Durch den Einsatz der verschiedenen Technologien, ist es möglich, dass sich User zunächst registrieren, anschließend anmelden und dann direkt Bücher zum Verkauf anbieten oder bereits eingestellte Bücher kaufen können. Dieser Ablauf funktioniert sowohl auf einem stationären, als auch auf einem mobilen Endgerät ohne hierbei einen Verlust von Funktionalitäten zu erleiden.

Es wurden alle geforderten bzw. alle für das Portal relevanten Technologien eingesetzt und zusammen ergeben Sie das Portal büchern.de

###Screenshots  
Die Screenshots wurden am 16.01 direkt von der Seite erstellt.

####Startseite büchern.de
<img height="400px" src="https://github.com/toschill/buechern/blob/master/Planung/Startseite.jpg"/>

####Login-Seite büchern.de
<img height="400px" src="https://github.com/toschill/buechern/blob/master/Planung/LoginSeite.jpg"/>

####Responsive Startseite mit Menü und Login-Seite
<img height="400px" src="https://github.com/toschill/buechern/blob/master/Planung/Resposinve.jpg"/>

###Fazit  
Während der Umsetzung des Portals wurde schnell klar, dass im Team unterschiedliche Wissensstände zum Thema Webtechnologien herrschen. Da sich das Projekt jedoch nicht nur auf die Webentwicklung bezieht, sondern gerade durch Play auch den kompletten funktionellen Teil mit sich bringt, konnten die Aufgaben sehr gut verteilt werden. Damit jedes Teammitglied vom Können und Wissen der anderen profitiert, wurde die Umsetzung zwar zunächst in einzelne Arbeitstakte aufgeteilt, beim wöchentlichen Meeting wurden die neusten Erkenntnisse und persönlichen Erfolge dann aber mit dem gesamten Team geteilt. Somit war es möglich, dass jeder einzelne einen Einblick in alle Gebiete erhält und es keine Einzel-Spezialisierung gibt.
Die Arbeit im Team gestaltete sich sehr gut. Die wöchentlichen Meetings wurden von allen eingehalten und jeder einzelne trug dazu bei die Arbeitsatmosphäre oben zuhalten. Somit konnten die ersten Ergebnisse sehr schnell erzielt werden und die zwei wöchentlichen Abgabe Termine immer eingehalten werden.

###Optionale Funktionen
*	Die beiden User können sich dann über portalinterne Nachrichten absprechen und einen Ort / Zeitpunkt ausmachen, an welchem Sie sich zur Übergabe treffen können. 
*	Wird ein Buch von einem User angeboten, kann der Käufer in Kontakt mit dem Verkäufer treten.
*	Daten zum Buch direkt nach der Eingabe der ISBN automatisch beziehen
*	Bewertungssystem für Verkäufer
*	Von Usern empfohlene Bücher zu Vorlesungen mit Anzeigen und anbieten
*	Suchanfrage von Usern die auf der Suche nach einem bestimmten Buch sind
