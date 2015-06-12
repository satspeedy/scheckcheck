insert into TEILNEHMER values (1,0,'lars.beumann@googlemail.com','password','lbeumann',1,'Beumann',0,'Lars');

insert into TEILNEHMER values (2,0,'mail@brittamueller.de','password','bmueller',0,'Müller',1,'Britta');

insert into TEILNEHMER values (3,0,'mail@markusbrandt.de','password','mbrandt',1,'Brandt',0,'Markus');

insert into TEILNEHMER values (4,0,'maxm2402@gmail.com','password','cmetzmacher',1,'Metzmacher',0,'Christian');

insert into TEILNEHMER values (5,0,'joachim@hp.com','password','jthieltges',1,'Thieltges',0,'Joachim');

insert into TEILNEHMER values (6,0,'satspeedy@gmail.com','password','hhancioglu',1,'Hancioglu',0,'Halil');

insert into TEILNEHMER values (7,0,'mario.winter@fh-koeln.de','password','mwinter',1,'Winter',1,'Mario');

commit;

insert into PORTALMITARBEITER values (1,0,'satspeedy@gmail.com','password','Admin',1);

commit;

insert into BILDUNGSTRAEGER values(1,0,'Wir bieten Weiterbildungen rund um Kommunikation und Soft-Skills','Seit mehr als 15 Jahren bieten wir qualifizierte Weiterbildungen und ermöglichen neue berufliche Perspektiven','Bildungsstr. 15, 45127 Essen, E-Mail: info@bildmich.de','BildMich','Essen');

insert into BILDUNGSTRAEGER values(2,0,'Wir bieten technologische Weiterbildungen in allen Belangen.','Als zertifizierter Bildungsträger bringen wir sie auf den neusten Technologischen Stand. Und das mit jahrelanger Erfahrung','Siegerstr. 13, 10115 Berlin, E-Mail: info@gewinner.de','Gewinner eV','Berlin');

insert into BILDUNGSTRAEGER values(3,0,'Wir bieten Weiterbildungen rund um das Thema Finanzen','Um Ihnen neue berufliche Perpektiven zu bieten beschäftigen wir nur sehr gute und zertifizierte Dozenten.','Daxstr. 155, 20095 Hamburg, E-Mail: info@finance.de','Finance GmbH','Hamburg');

commit;

insert into BILDUNGSMASSNAHME values (1,0,'Lernen Sie die eigenarten der Softwareentwicklung und werden Sie fit für die Praxis.','Softwareentwicklung','Essen',1);

insert into BILDUNGSMASSNAHME values (2,0,'Dieser Kurs vermittelt Ihnen die Grundlagen in Netzwerktechnik und eröffnet Ihnen somit neue berufliche Perspektiven','Netzwerktechnik','Essen',1);

insert into BILDUNGSMASSNAHME values (3,0,'Kommunikation ist ein Kunst. Lernen Sie in diesem Kurs wie ein professioneller Auftriit funktioniert.','Softskill-Training','Berlin',2);

insert into BILDUNGSMASSNAHME values (4,0,'Lernen Sie Bewerbungen richtig zu schreiben. Mit diesem Kurs machen Sie den ersten Schritt','Bewerbungs-Training','Berlin',2);

insert into BILDUNGSMASSNAHME values (5,0,'Buchhaltung ist nur etwas für Profis? Bei werden sie ein Profi','Buchhaltung','Hamburg',3);

commit;

insert into BEWERTUNG values (1,0,4,5,3,3,1,3,2,STR_TO_DATE('04-17-2015 11:23:10','%m-%d-%Y %H:%i:%s'),'Insgesamt eine gelungene Veranstaltung',1,1);

insert into BEWERTUNG values (2,0,5,5,4,3,5,5,4,STR_TO_DATE('04-18-2015 10:11:07','%m-%d-%Y %H:%i:%s'),'So stelle ich mir eine kompetente Weiterbildung vor',1,2);

insert into BEWERTUNG values (3,0,3,5,5,5,3,4,5,STR_TO_DATE('04-20-2015 14:12:45','%m-%d-%Y %H:%i:%s'),'Bis auf die Ausstattung nichts zu beanstanden',1,3);

insert into BEWERTUNG values (4,0,2,2,1,3,2,2,1,STR_TO_DATE('05-10-2015 18:22:35','%m-%d-%Y %H:%i:%s'),'Absolut nicht zu empfehlen. Das Niveau war unterirdisch',2,4);

insert into BEWERTUNG values (5,0,3,4,5,5,4,4,3,STR_TO_DATE('04-17-2015 13:27:10','%m-%d-%Y %H:%i:%s'),'Sehr interessant aber teilweise auch anstrengend',2,5);

insert into BEWERTUNG values (6,0,5,5,5,5,4,5,5,STR_TO_DATE('04-17-2015 15:39:10','%m-%d-%Y %H:%i:%s'),'Herausragend. Für mich die Beste Veranstaltung seit langem',3,5);

insert into BEWERTUNG values (7,0,2,5,3,3,2,2,1,STR_TO_DATE('05-01-2015 11:23:10','%m-%d-%Y %H:%i:%s'),'War nicht ganz so wie ich es mir vorgestellt habe',4,6);

insert into BEWERTUNG values (8,0,4,3,5,4,3,3,3,STR_TO_DATE('05-21-2015 11:11:11','%m-%d-%Y %H:%i:%s'),'Ganz in Ordnung. Hätter mir jedoch mehr erwartet',5,1);

commit;