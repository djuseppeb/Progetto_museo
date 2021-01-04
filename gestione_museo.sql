-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 04, 2021 alle 18:55
-- Versione del server: 10.4.16-MariaDB
-- Versione PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestione_museo`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `art_piece`
--

CREATE TABLE `art_piece` (
  `ID_art` int(11) NOT NULL,
  `Title` varchar(250) NOT NULL,
  `Artist` varchar(250) NOT NULL,
  `Availability` set('Disponibile','In restauro','Venduto','In arrivo') NOT NULL,
  `Type` set('Quadro','Scultura','Mosaico','Manufatto') NOT NULL,
  `Room` int(11) NOT NULL,
  `Art_movement` set('Astrattismo','Cubismo','Espressionismo','Futurismo','Realismo','Arte rinascimentale') NOT NULL,
  `Description` text NOT NULL,
  `Position` int(11) NOT NULL,
  `Value_Euro` float NOT NULL,
  `Img_URL` text NOT NULL DEFAULT 'https://upload.wikimedia.org/wikipedia/it/8/83/No_immagini.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `art_piece`
--

INSERT INTO `art_piece` (`ID_art`, `Title`, `Artist`, `Availability`, `Type`, `Room`, `Art_movement`, `Description`, `Position`, `Value_Euro`, `Img_URL`) VALUES
(1, 'Gioconda', 'Leonardo Da Vinci', 'Disponibile', 'Quadro', 1, 'Arte rinascimentale', 'Opera iconica ed enigmatica della pittura mondiale, si tratta sicuramente del ritratto più celebre della storia nonché di una delle opere d\'arte più note in assoluto. Il sorriso impercettibile del soggetto, col suo alone di mistero, ha ispirato tantissime pagine di critica, letteratura, opere di immaginazione e persino studi psicoanalitici; sfuggente, ironica e sensuale, la Monna Lisa è stata di volta in volta amata e idolatrata, ma anche derisa o aggredita.', 1, 100000, 'https://upload.wikimedia.org/wikipedia/commons/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg'),
(2, 'Ultima Cena', 'Leonardo Da Vinci', 'In restauro', 'Quadro', 1, 'Arte rinascimentale', 'Si tratta della più celebre rappresentazione dell\'Ultima Cena, capolavoro di Leonardo e del Rinascimento italiano in generale. Nonostante ciò, l\'opera - a causa della singolare tecnica sperimentale utilizzata da Leonardo, incompatibile con l\'umidità dell\'ambiente - versa da secoli in un cattivo stato di conservazione, cui si è fatto fronte, per quanto possibile, nel corso di uno dei più lunghi restauri della storia, durato dal 1978 al 1999 con le tecniche più all\'avanguardia del settore', 2, 75000, 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Leonardo_da_Vinci_-_The_Last_Supper_high_res.jpg/1920px-Leonardo_da_Vinci_-_The_Last_Supper_high_res.jpg'),
(3, 'David', 'Michelangelo Buonarroti', 'Disponibile', 'Scultura', 1, 'Arte rinascimentale', 'Largamente considerato un capolavoro della scultura mondiale, è uno degli emblemi del Rinascimento nonché simbolo di Firenze e dell\'Italia all\'estero. L\'opera, che ritrae l\'eroe biblico nel momento in cui si appresta ad affrontare Golia, originariamente fu collocata in Piazza della Signoria, come simbolo della Repubblica fiorentina vigile e vittoriosa contro i nemici.\r\n\r\n', 3, 20000, 'https://upload.wikimedia.org/wikipedia/commons/2/24/%27David%27_by_Michelangelo_JBU0001.JPG'),
(4, 'Nascita di Venere', 'Sandro Botticelli', 'Venduto', 'Quadro', 0, 'Arte rinascimentale', 'Opera iconica del Rinascimento italiano, spesso assunta come simbolo della stessa Firenze e della sua arte, faceva forse anticamente collegamento con l\'altrettanto celebre Primavera sempre di Botticelli, con cui condivide la provenienza storica, il formato e alcuni riferimenti filosofici. Rappresenta una delle creazioni più elevate dell\'estetica del pittore fiorentino, oltre che un ideale universale di bellezza femminile.\r\n\r\n', 0, 10000, 'https://upload.wikimedia.org/wikipedia/commons/0/0b/Sandro_Botticelli_-_La_nascita_di_Venere_-_Google_Art_Project_-_edited.jpg'),
(5, 'Il pensatore', 'Auguste Rodin', 'Disponibile', 'Scultura', 2, 'Realismo', 'Inizialmente chiamata Il poeta, la statua faceva parte di una porta monumentale in bronzo commissionata a Rodin come porta d\'ingresso di un progettato Musée des Arts Décoratifs a Parigi che in realtà non sarà mai realizzato. Rodin decise di raffigurare un tema a lui caro, l\'universo dantesco della Divina Commedia in quanto opera ricchissima di spunti romantici e drammatici, e che oltretutto Rodin conosceva molto bene fin dai tempi della Petite École. Ogni figura da lui ideata rappresentava uno dei personaggi principali del poema. Il pensatore doveva raffigurare Dante davanti alle porte dell\'Inferno, mentre medita sul suo grande poema.', 1, 55000, 'https://upload.wikimedia.org/wikipedia/commons/5/56/The_Thinker%2C_Rodin.jpg'),
(6, 'Arrangiamento in grigio e nero, ritratto n. 1', 'James Abbott McNeill Whistler', 'In arrivo', 'Quadro', 2, 'Realismo', 'È stata Anna McNeill Whistler, madre dell\'artista, a posare per questo dipinto nell\'appartamento di Cheyne Walk del figlio, a Chelsea. L\'aneddotica che gravita intorno all\'opera è molto densa: pare, infatti, che Whistler decise di ritrarre l\'anziana madre solo perché un\'altra modella non si era presentata all\'appuntamento. Altri avanzano l\'ipotesi che la madre di Whistler sia ritratta seduta, e non stante, a causa delle sue difficoltà a stare in piedi.', 2, 20000, 'https://upload.wikimedia.org/wikipedia/commons/1/1b/Whistlers_Mother_high_res.jpg'),
(7, 'I mangiatori di patate', 'Vincent van Gogh', 'Disponibile', 'Quadro', 2, 'Realismo', 'L\'opera raffigura l\'interno di una povera abitazione di Nuenen, appena illuminata da una fioca luce che, sgorgando dalla lampada a petrolio appesa a una delle travi del soffitto, si riflette sulle cuffie bianche, sulle tazzine di caffè, e sul magro pasto dei commensali. Al centro della composizione è presente una famiglia di contadini che, dopo aver trascorso la giornata a lavorare duramente nei campi, si riunisce intorno a un tavolo, per consumare la cena. Un\'anziana signora, ricurva per la fatica, versa il caffè nelle tazzine, mentre l\'uomo alla sua destra, probabilmente suo marito, reca in mano una patata; la donna a sinistra intinge la forchetta nel vassoio delle patate. Lo sguardo della donna è rivolto verso l\'uomo accanto a lei, i cui lineamenti sono imbruttiti da fatica e rassegnazione, per un destino che non cambierà. In primo piano, una bambina, di spalle, tiene forse le mani giunte al petto, nell\'atto di recitare una preghiera prima del pasto (secondo un\'altra interpretazione, si ipotizza che l\'autore, nascondendone il volto, abbia voluto «salvarla» dal triste destino che l\'attende).', 3, 18000, 'https://upload.wikimedia.org/wikipedia/commons/2/22/Vincent_van_Gogh_-_The_potato_eaters_-_Google_Art_Project_%285776925%29.jpg'),
(8, 'L\'urlo', 'Edvard Munch', 'Venduto', 'Quadro', 0, 'Espressionismo', 'Il soggetto urlante è la figura in primo piano, terrorizzata, che per emettere il grido (e non per proteggersene) si comprime la testa con le mani, perdendo ogni forma e diventando preda del suo stesso sentimento: più che un uomo, infatti, ricorda un ectoplasma, con il suo corpo serpentiforme, quasi senza scheletro, privo di capelli, deforme. Si perde insieme alla sua voce straziata e alla sua forma umana tra le lingue di fuoco del cielo morente, così come morente appare il suo corpo, le sue labbra nere putrescenti, le sue narici dilatate e gli occhi sbarrati, testimoni di un abominio immondo. Ma il vero centro dell\'opera è costituito dalla bocca che, aprendosi in un innaturale spasmo, emette un grido che distorce l\'intero paesaggio, che in questo modo restituisce una sensazione di disarmonia, squilibrio. Questo sentimento di malessere non è esclusivo né dello sfondo, né dell\'animo di Munch: è infatti distintivo del pessimismo fin de siècle diffuso in quel periodo, che cominciò a mettere in dubbio le certezze dell\'essere umano, proprio mentre Sigmund Freud indagava gli abissi dell\'inconscio.\r\n\r\n', 0, 78000, 'https://upload.wikimedia.org/wikipedia/commons/f/f4/The_Scream.jpg'),
(9, 'Sera sul viale Karl Johan', 'Edvard Munch', 'Disponibile', 'Quadro', 2, 'Espressionismo', 'Anticipando il tema dei morti viventi, e mostrandosi sensibile ai pièce di Ibsen e Strindberg, Munch tramuta il piacevole rito del passeggio in un\'accusa all\'alienazione e allo spaesamento dell\'umanità nella società moderna. Munch rivolge questa feroce critica non solo ai singoli personaggi (ormai ridotti a un\'unica, compatta falange), bensì anche alle istituzioni: sullo sfondo si erge con fare intimidatorio il municipio, illuminato da una luce inizialmente gialla, che tramuta le finestre in occhi luminescenti che sembrano controllare che tutto vada secondo gli schemi previsti dalle convenzioni borghesi. A destra del municipio si eleva minacciosamente un\'escrescenza nerastra (secondo alcuni un cipresso), mentre a sinistra è presente una schiera di abitazioni, del tutto simile a quelle «case mostruose / dalle cento e cento occhiaie» cantate da Gabriele D\'Annunzio.', 4, 54500, 'https://upload.wikimedia.org/wikipedia/commons/8/83/Evening_on_Karl_Johan_Street.jpg'),
(10, 'La stanza rossa', 'Henri Matisse', 'In arrivo', 'Quadro', 2, 'Espressionismo', 'In questa sua opera emblematica del periodo fauves, Matisse visualizza la scena in un interno borghese, una camera con una finestra, in un angolo in alto a sinistra, attraverso la quale si intravede un paesaggio.\r\n\r\nAl colore dato per strisce e chiazze dirompenti in molteplici tonalità, si sono sostituite grandi superfici di colore pieno e la bidimensionalità decorativa; tutta la composizione inoltre, e persino la natura, non ha profondità spaziale. Essa assume invece una bidimensionalità illusionistica a cui vengono aggiunti elementi decorativi che diventeranno poi fondamentali nella seconda parte della sua carriera.\r\n\r\nQuesti motivi floreali e ondulati presenti sulla tovaglia, si ripetono nella tappezzeria e assumono un valore decorativo e musicale.\r\n\r\nLa costruzione prospettica (indicata dalla sottile linea nera del bordo del tavolo e della piega della tovaglia, sulla sinistra, appena accennata, ma anche dallo spessore del muro) è annullata dalla scelta dello stesso rosso, con l\'identico motivo floreale della tovaglia.\r\n\r\nI colori dominanti in quest\'opera sono i primari rosso, blu e giallo e la costruzione prospettica appena accennata anche dalla sedia e dallo spessore del muro in cui è ritagliata la finestra, si annulla completamente nel resto del dipinto proprio a causa dello stesso colore rosso. Da ciò si capisce che l\'artista con questo quadro non vuole rappresentare uno spazio reale, ma invece una dimensione interiore ed emotiva.\r\n\r\nMetaforicamente si può collegare la stanza rossa ed i colori forti alla mente di Matisse, che riecheggia nel caos. Mentre contemporaneamente possiamo pensare all\'ambiente fuoristante, cioè alla natura come un posto inarrivabile e tranquillo, quasi paradisiaco se confrontato alla sala interna.', 5, 65400, 'https://upload.wikimedia.org/wikipedia/en/0/0a/Matisse-The-Dessert-Harmony-in-Red-Henri-1908-fast.jpg'),
(11, 'Forme uniche della continuità nello spazio', 'Umberto Boccioni', 'Disponibile', 'Scultura', 3, 'Futurismo', 'Se si osserva lateralmente la scultura, si può riconoscere facilmente una figura umana in cammino priva però di alcune parti (ad esempio le braccia) e, per così dire, del suo \"involucro\" esterno. La figura appare quindi per un verso come uno \"scorticato\" anatomico (si riconoscono distintamente alcuni muscoli, come i polpacci, e l\'articolazione del ginocchio), per un altro come una \"macchina\", come un ingranaggio in movimento. L\'opera inoltre si sviluppa mediante l\'alternarsi di cavità, rilievi, pieni e vuoti che generano un frammentato e discontinuo chiaroscuro fatto di frequenti e repentini passaggi dalla luce all\'ombra. Osservando la figura da destra, il torso ad esempio pare essere pieno ma se si gira intorno alla statua e la si osserva da sinistra esso si trasforma in una cavità vuota. In tale modo sembra che la figura si modelli a seconda dello spazio circostante ed assume così la funzione per così dire di plasmare le forme.\r\n\r\nAnche la linea di contorno si sviluppa come una sequenza di curve ora concave, ora convesse: in tal modo i contorni irregolari non limitano la figura come di consueto ma la dilatano espandendola nello spazio. L\'interno stesso della statua è attraversato da solchi e spigoli che \"tagliano\" i piani, come se le figure fossero più di una e si sovrapponessero di continuo.\r\n\r\nSe vista lateralmente, la statua dà l\'impressione di un movimento avanzante che si proietta energicamente in avanti. Tuttavia se la si guarda frontalmente o a tre quarti si può notare una torsione o avvitamento delle forme nello spazio: più di una linea infatti si avvolge attorno alla figura in un moto a spirale, coinvolgendo i diversi piani in una rotazione che suggerisce un\'ulteriore espansione delle forme. La figura viene modellata dall\'aria creando così un corpo aerodinamico.\r\n\r\n', 1, 15000, 'https://upload.wikimedia.org/wikipedia/commons/7/73/Umberto_Boccioni_Forme_uniche_nella_continuit%C3%A0_dello_spazio_1913.jpg'),
(12, 'Primo acquarello astratto', 'Vasilij Vasil\'evič Kandinskij\r\n', 'Disponibile', 'Quadro', 3, 'Astrattismo', 'Fu lo stesso Kandinskij a rilevare in una sua dichiarazione la nascita dell\'arte astratta. L\'acquerello si presenta come uno schizzo informe ricongiungibile a uno scarabocchio infantile, in questo acquerello si è proposto di sperimentare il primo contatto dell\'essere umano con il mondo, con una realtà di cui non si sa nulla. L\'immagine è caratterizzata da diverse macchie colorate: alcune grosse velature espanse e trasparenti, situate in particolare nella parte alta del foglio, sembrano introdurre nella superficie bianca un senso di profondità fluttuante.', 2, 55000, 'https://upload.wikimedia.org/wikipedia/commons/7/79/Untitled_%28First_Abstract_Watercolor%29_by_Wassily_Kandinsky.jpg'),
(13, 'Composizione con giallo, blu e rosso', 'Piet Mondrian\r', 'Disponibile', 'Quadro', 3, 'Astrattismo', 'Fu dipinto da Mondrian in fase astrattistica ormai matura. Rappresenta un reticolato formato da righe nere su sfondo bianco, a formare una serie di quadrati e rettangoli. Di questi, una piccola parte è dipinta in giallo, rosso e blu. La profondità è data dal diverso stile di pittura; le strisce nere realizzate di piatto, le parti colore con pennellate unidirezionali, ed infine le parti bianche con pennellate multidirezionali.', 3, 55000, 'https://upload.wikimedia.org/wikipedia/commons/a/ab/Composition-with-red-yellow-and-blue.jpg'),
(14, 'Guernica', 'Pablo Picasso', 'In arrivo', 'Quadro', 4, 'Cubismo', 'La violenza, lo stupore, l\'angoscia e la sofferenza sono deducibili esplicitamente guardando, sulla sinistra dell\'opera, la madre che grida al cielo disperata, con in grembo il figlio ormai senza vita; da contraltare ad essa l\'altra figura apparentemente femminile a destra, che alza disperata le braccia al cielo. In basso nel dipinto c\'è un cadavere che ha una stigma sulla mano sinistra come simbolo di innocenza, in contrasto con la crudeltà nazi-fascista, e che stringe nella mano destra una spada spezzata, da cui sorge un pallido fiore, quasi a dare speranza per un futuro migliore. La gamma dei colori è limitata; vengono, infatti, utilizzati esclusivamente toni grigi, neri e bianchi, così da rappresentare l\'assenza di vita e la drammaticità. L\'alto senso drammatico nasce dalla deformazione dei corpi, dalle linee che si tagliano vicendevolmente, dalle lingue aguzze che fanno pensare ad urli disperati e laceranti, dall\'alternarsi di campi bianchi, grigi, neri, che accentuano la dinamica delle forme contorte e sottolineano l\'assenza di vita a Guernica. Questo quadro doveva rappresentare una sorta di manifesto che esponesse al mondo la crudeltà e l\'ingiustizia delle guerre. I colori del quadro sono il bianco e nero perché, secondo Picasso la guerra è sofferenza, ma nell\'opera, se si guarda bene, c\'è una lampadina che simboleggia la speranza.\r\n\r\n', 1, 15800, 'https://upload.wikimedia.org/wikipedia/commons/6/6f/Mural_del_Gernika.jpg'),
(15, 'Il sogno', 'Pablo Picasso', 'In restauro', 'Quadro', 4, 'Cubismo', 'Appartenente ad una serie di dipinti prodotti tra il gennaio e il marzo del 1932 raffiguranti donne addormentate, per i quali è stata presa a modello Marie Thérèse, Il sogno raffigura un soggetto femminile addormentato con le braccia piegate e la testa inclinata da un lato. Il suo volto appare contemporaneamente di profilo e frontale.\r\n\r\nIl senso di morbidezza, rievocato dalle fattezze tondeggianti della donna, è accentuato dalle linee curve della poltrona rossa sulla quale è seduta. Probabilmente ispirato alla pittura fauves di Henri Matisse[2] e distante dalle figure mostruose dei dipinti precedenti, il dipinto rievoca, nel suo insieme, armonia e serenità.', 2, 36000, 'https://upload.wikimedia.org/wikipedia/en/9/9d/Le-reve-1932.jpg');

-- --------------------------------------------------------

--
-- Struttura della tabella `room`
--

CREATE TABLE `room` (
  `ID_room` int(11) NOT NULL,
  `Temperature` float NOT NULL,
  `Status_thermal_system` tinyint(1) NOT NULL,
  `N_people` int(11) NOT NULL,
  `Average_distance` float NOT NULL,
  `Social_distancing` tinyint(1) NOT NULL,
  `lights_intensity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `room`
--

INSERT INTO `room` (`ID_room`, `Temperature`, `Status_thermal_system`, `N_people`, `Average_distance`, `Social_distancing`, `lights_intensity`) VALUES
(1, 16.3, 1, 7, 1.4, 1, 6),
(2, 16.8, 1, 9, 0.8, 0, 7),
(3, 15.7, 1, 5, 1.9, 1, 6),
(4, 12, 0, 0, 0, 1, 0);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `art_piece`
--
ALTER TABLE `art_piece`
  ADD PRIMARY KEY (`ID_art`);

--
-- Indici per le tabelle `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`ID_room`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `art_piece`
--
ALTER TABLE `art_piece`
  MODIFY `ID_art` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=344;

--
-- AUTO_INCREMENT per la tabella `room`
--
ALTER TABLE `room`
  MODIFY `ID_room` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
