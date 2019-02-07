# Obligatorisk øvelse 2 Håndbrekket

## Deloppgave 1 - Organiser teamet

## Deloppgave 2 - Få oversikt over forventet produkt
### Overordnede målet for applikasjonen:
Det overordnende målet for applikasjonen er å implementere spillet Robot Rally. Lage et system som følger settet med Regler for dette spillet. 
### En liste over krav til systemet baser på høynivåkravene gjennomgått i forelesning:
Dette er listen over krav gjennomgått i forelesningen.
* Ha et spillbrett
* vise en brikke
* kunne flytte en brikke
* dele ut kort
* velge kort (5 av 9)
* flytte brikke utfra kort
* dele ut nye kort ved ny runde
* vise flere (i alle fall to) brikker på samme brett
* dele ut kort til hver robot
* flytte flere brikker samtidig
* flytte brikker utfra prioritet på kort
* flagg på brettet
* kunne registrere at en robot har vært innom et flagg
* håndtere konflikter i bevegelse riktig
* kunne legge igjen backup
* restarte fra backup v ødeleggelse
* går du i et hull, blir du ødelagt, mister et liv og begynner fra forrige backup
* går du av brettet, blir du ødelagt, mister et liv og begynner fra forrige backup
* blir du skutt i fillebiter (9 i skade) blir du ødelagt, mister et liv og begynner fra forrige backup
* vender en robot mot deg ved slutten av en fase blir du skutt og får en i skade
* får du skade får du mindre kort i henhold til skaden du har
* kan ikke gå gjennom vegger
* kunne ta powerdown for å reparere skade
* vanskelighetsgrad på brett??
* for mye skade brenner fast programkort fra runde til runde


### Prioritert liste over hvilke krav dere vil ha med i første iterasjon:
Per siste gruppemøte (06.02.2019) har vi følge liste over krav vi vil ha med i første iterasjon:
 * Interfaces for de klassene vi tenker å implementere til første iterasjon
 * Board klasse med enkle metoder
 * Square klasse med enkle metoder
 * Robot klasse med enkle metoder
 * Lage et enkelt spillbrett, vi tenker å vise det i terminalen først.
 * Main klassen skriver ut et spillbrett ved hjelp av Board klassen
 * Fylle board klassen med Squares
 * Fylle eventuelle Squares med Robot


## Deloppgave 3 - Velg og tilpass en prosess for laget
###Beskrivelse av organisering og planlegging på prosjekt INF112
Planlegging og organisering av vårt prosjekt den første tiden
 
skal være på følgende måte:

**Kommunikasjon:** Vi kommer til å ha aktiv kommunikasjon via msn og slack mellom 
alle medlemmer i gruppen.

**- Prosjekt (obligatoriske innleveringer):** Vi lagger en grunnleggende struktur (Game og kort), 
på samme måte som vi kommer til å lage et diagram med de forskjellige faser som vårt 
prosjekt kommer til å ha. Vi følger med forretningsregler som står beskrevet i GitHub (master 
fra foreleser).

Dette er noe som kommer til å utvikle seg etter hvert vi ser hvordan det går med utviklingen 
av med selve prosjektet.

**- Dokumentasjon:** Vi dokumenterer alt som blir avtalt i våre møter på samme måte lager leder 
av gruppen en agenda for hva skal vi gjøre til neste møte. Dette er noe som vi forsette å ha 
videre i organisering.

Vi kommer til å bruke Kanban for å ha en effektiv måte å følge med prosjektet vårt.

**- Fordeling av oppgaver:** Vi kommer til å jobbe med tester og par programmering. Dette kommer til å være spesiell brukt når vi begynner å jobbe mer, med de avanserte oppgavene (Interface, kjerne «featurers», visualisering, osv.) i prosjektet vårt.
Vi kommer til å dele oppgaver slik at alle for å gjøre sin del (dette gjelder med kompetanse av hvert medlem i vår gruppen), men samtidig kommer vi til å være forsiktig med at ingen av oss skal sitte alene med en oppgave eller skal ha alt for mye arbeid for seg selv. 

## Deloppgave 4 - kode



