<%@page import="fr.ngando.person.domain.Person"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="resources/css/default.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">

</head>
<body>
	<div class="wrapper">
		<%@include file="../../commons/view/header.jsp"%>
		<c:if test="${sessionScope.isConnected}">
			<c:redirect url="account" />
		</c:if>
		<h1>Inscription</h1>
		<c:if test="${ErrorAlreadyExistsUser != null }">
			<p class="text-center error connexionMsg">
				:( Une erreur s'est produite lors de la création de ton compte ! <br>
				Ton adresse mail est déjà associée à un compte chez nous ! <br>
				<a href="login">Aller à la page de connexion</a>
			</p>
		</c:if>
		<c:if test="${adduser != null }">
			<p class="text-center success connexionMsg">
				:) Ton compte a été créé avec success ! <br> Tu peux maintenant
				te connecter !<br> <a href="login" class="underline">connexion</a>
			</p>
		</c:if>
		<section>
			<fieldset>
				<legend>Vos coordonnées :</legend>
				<form id="register" name="register" action="register" method="post">
					<div class="input-block">
						<div class="input-radio">
							<input type="radio" name="civilite" value="Mme" checked="checked"><label>Mme</label>
						</div>
						<div class="input-radio">
							<input type="radio" name="civilite" value="Mrs"><label>Mrs</label>
						</div>
					</div>
					<div class="input-block">
						<label for="name">Nom : </label><sup class="indianred">*</sup><br>
						<input type="text" name="name" maxlength="40" placeholder="nom"
							value="NG" />
						<p class="error"></p>
					</div>
					<div class="input-block">
						<label for="firstname">Prenom : </label><sup class="indianred">*</sup><br>
						<input type="text" name="firstname" maxlength="40"
							placeholder="prenom" value="Wéli" />
						<p class="error"></p>
					</div>
					<div class="input-block">
						<label for="mail">Email : </label><sup class="indianred">*</sup><br>
						<input name="email" type="email" placeholder="mail"
							value="weli@yahoo.fr">
						<p class="error"></p>
					</div>
					<div class="input-block">
						<label for="password">Mot de passe : </label><sup
							class="indianred">*</sup><br> <input name="password"
							type="password" placeholder="mot de passe" value="1234">
						<p class="error"></p>
					</div>
					<div class="input-block">
						<label for="confirmPassword">Confirmation mot de passe : </label><sup
							class="indianred">*</sup><br> <input name="confirmPassword"
							type="password" placeholder="confirmation mot de passe"
							value="1234">
						<p class="error"></p>
					</div>
					<div class="input-block">
						<label for="birthday">Date de naissance : </label><sup
							class="indianred">*</sup><br> <input type="date"
							name="birthday" maxlength="40" placeholder="jj/mm/aaaa"
							value="2017-06-28" />
						<p class="error"></p>
					</div>
					<div class="input-block">
						<label for="adress">N° et rue :</label><br> <input
							type="text" name="adress" maxlength="40" placeholder="n° et rue"
							value="1 rue de la Bougeotte" />
					</div>
					<div class="input-block">
						<label for="town">Ville :</label><br> <input type="text"
							name="town" maxlength="40" placeholder="ville" value="Lille" />
					</div>
					<div class="input-block">
						<label for="department">Département :</label><br> <select
							name="department">
							<option>
							<option value="(01) Ain" region="Rhône-Alpes">(01) Ain</option>
							<option value="(02) Aisne" region="Picardie">(02) Aisne</option>
							<option value="(03) Allier" region="Auvergne">(03)
								Allier</option>
							<option value="(04) Alpes-de-Haute-Provence"
								region="Provence-Alpes-Côte-d'Azur">(04)
								Alpes-de-Haute-Provence</option>
							<option value="(05) Hautes-Alpes"
								region="Provence-Alpes-Côte-d'Azur">(05) Hautes-Alpes</option>
							<option value="(06) Alpes-Maritimes"
								region="Provence-Alpes-Côte-d'Azur">(06)
								Alpes-Maritimes</option>
							<option value="(07) Ardèche" region="Rhône-Alpes">(07)
								Ardèche</option>
							<option value="(08) Ardennes" region="Champagne-Ardenne">(08)
								Ardennes</option>
							<option value="(09) Ariège" region="Midi-Pyrénées">(09)
								Ariège</option>
							<option value="(10) Aube" region="Champagne-Ardenne">(10)
								Aube</option>
							<option value="(11) Aude" region="Languedoc-Roussillon">(11)
								Aude</option>
							<option value="(12) Aveyron" region="Midi-Pyrénées">(12)
								Aveyron</option>
							<option value="(13) Bouches-du-Rhône"
								region="Provence-Alpes-Côte-d'Azur">(13)
								Bouches-du-Rhône</option>
							<option value="(14) Calvados" region="Basse-Normandie">(14)
								Calvados</option>
							<option value="(15) Cantal" region="Auvergne">(15)
								Cantal</option>
							<option value="(16) Charente" region="Poitou-Charentes">(16)
								Charente</option>
							<option value="(17) Charente-Maritime" region="Poitou-Charentes">(17)
								Charente-Maritime</option>
							<option value="(18) Cher" region="Centre">(18) Cher</option>
							<option value="(19) Corrèze" region="Limousin">(19)
								Corrèze</option>
							<option value="(21) Côte-d'Or" region="Bourgogne">(21)
								Côte-d'Or</option>
							<option value="(22) Côtes-d'Armor" region="Bretagne">(22)
								Côtes-d'Armor</option>
							<option value="(23) Creuse" region="Limousin">(23)
								Creuse</option>
							<option value="(24) Dordogne" region="Aquitaine">(24)
								Dordogne</option>
							<option value="(25) Doubs" region="Franche-Comté">(25)
								Doubs</option>
							<option value="(26) Drôme" region="Rhône-Alpes">(26)
								Drôme</option>
							<option value="(27) Eure" region="Haute-Normandie">(27)
								Eure</option>
							<option value="(28) Eure-et-Loir" region="Centre">(28)
								Eure-et-Loir</option>
							<option value="(29) Finistère" region="Bretagne">(29)
								Finistère</option>
							<option value="(2A) Corse-du-Sud" region="Corse">(2A)
								Corse-du-Sud</option>
							<option value="(2B) Haute-Corse" region="Corse">(2B)
								Haute-Corse</option>
							<option value="(30) Gard" region="Languedoc-Roussillon">(30)
								Gard</option>
							<option value="(31) Haute-Garonne" region="Midi-Pyrénées">(31)
								Haute-Garonne</option>
							<option value="(32) Gers" region="Midi-Pyrénées">(32)
								Gers</option>
							<option value="(33) Gironde" region="Aquitaine">(33)
								Gironde</option>
							<option value="(34) Hérault" region="Languedoc-Roussillon">(34)
								Hérault</option>
							<option value="(35) Ille-et-Vilaine" region="Bretagne">(35)
								Ille-et-Vilaine</option>
							<option value="(36) Indre" region="Centre">(36) Indre</option>
							<option value="(37) Indre-et-Loire" region="Centre">(37)
								Indre-et-Loire</option>
							<option value="(38) Isère" region="Rhône-Alpes">(38)
								Isère</option>
							<option value="(39) Jura" region="Franche-Comté">(39)
								Jura</option>
							<option value="(40) Landes" region="Aquitaine">(40)
								Landes</option>
							<option value="(41) Loir-et-Cher" region="Centre">(41)
								Loir-et-Cher</option>
							<option value="(42) Loire" region="Rhône-Alpes">(42)
								Loire</option>
							<option value="(43) Haute-Loire" region="Auvergne">(43)
								Haute-Loire</option>
							<option value="(44) Loire-Atlantique" region="Pays de la Loire">(44)
								Loire-Atlantique</option>
							<option value="(45) Loiret" region="Centre">(45) Loiret</option>
							<option value="(46) Lot" region="Midi-Pyrénées">(46) Lot</option>
							<option value="(47) Lot-et-Garonne" region="Aquitaine">(47)
								Lot-et-Garonne</option>
							<option value="(48) Lozère" region="Languedoc-Roussillon">(48)
								Lozère</option>
							<option value="(49) Maine-et-Loire" region="Pays de la Loire">(49)
								Maine-et-Loire</option>
							<option value="(50) Manche" region="Basse-Normandie">(50)
								Manche</option>
							<option value="(51) Marne" region="Champagne-Ardenne">(51)
								Marne</option>
							<option value="(52) Haute-Marne" region="Champagne-Ardenne">(52)
								Haute-Marne</option>
							<option value="(53) Mayenne" region="Pays de la Loire">(53)
								Mayenne</option>
							<option value="(54) Meurthe-et-Moselle" region="Lorraine">(54)
								Meurthe-et-Moselle</option>
							<option value="(55) Meuse" region="Lorraine">(55) Meuse</option>
							<option value="(56) Morbihan" region="Bretagne">(56)
								Morbihan</option>
							<option value="(57) Moselle" region="Lorraine">(57)
								Moselle</option>
							<option value="(58) Nièvre" region="Bourgogne">(58)
								Nièvre</option>
							<option value="(59) Nord" region="Nord-Pas-de-Calais"
								selected="selected">(59) Nord</option>
							<option value="(60) Oise" region="Picardie">(60) Oise</option>
							<option value="(61) Orne" region="Basse-Normandie">(61)
								Orne</option>
							<option value="(62) Pas-de-Calais" region="Nord-Pas-de-Calais">(62)
								Pas-de-Calais</option>
							<option value="(63) Puy-de-Dôme" region="Auvergne">(63)
								Puy-de-Dôme</option>
							<option value="(64) Pyrénées-Atlantiques" region="Aquitaine">(64)
								Pyrénées-Atlantiques</option>
							<option value="(65) Hautes-Pyrénées" region="Midi-Pyrénées">(65)
								Hautes-Pyrénées</option>
							<option value="(66) Pyrénées-Orientales"
								region="Languedoc-Roussillon">(66) Pyrénées-Orientales</option>
							<option value="(67) Bas-Rhin" region="Alsace">(67)
								Bas-Rhin</option>
							<option value="(68) Haut-Rhin" region="Alsace">(68)
								Haut-Rhin</option>
							<option value="(69) Rhône" region="Rhône-Alpes">(69)
								Rhône</option>
							<option value="(70) Haute-Saône" region="Franche-Comté">(70)
								Haute-Saône</option>
							<option value="(71) Saône-et-Loire" region="Bourgogne">(71)
								Saône-et-Loire</option>
							<option value="(72) Sarthe" region="Pays de la Loire">(72)
								Sarthe</option>
							<option value="(73) Savoie" region="Rhône-Alpes">(73)
								Savoie</option>
							<option value="(74) Haute-Savoie" region="Rhône-Alpes">(74)
								Haute-Savoie</option>
							<option value="(75) Paris" region="Ile-de-France">(75)
								Paris</option>
							<option value="(76) Seine-Maritime" region="Haute-Normandie">(76)
								Seine-Maritime</option>
							<option value="(77) Seine-et-Marne" region="Ile-de-France">(77)
								Seine-et-Marne</option>
							<option value="(78) Yvelines" region="Ile-de-France">(78)
								Yvelines</option>
							<option value="(79) Deux-Sèvres" region="Poitou-Charentes">(79)
								Deux-Sèvres</option>
							<option value="(80) Somme" region="Picardie">(80) Somme</option>
							<option value="(81) Tarn" region="Midi-Pyrénées">(81)
								Tarn</option>
							<option value="(82) Tarn-et-Garonne" region="Midi-Pyrénées">(82)
								Tarn-et-Garonne</option>
							<option value="(83) Var" region="Provence-Alpes-Côte-d'Azur">(83)
								Var</option>
							<option value="(84) Vaucluse" region="Provence-Alpes-Côte-d'Azur">(84)
								Vaucluse</option>
							<option value="(85) Vendée" region="Pays de la Loire">(85)
								Vendée</option>
							<option value="(86) Vienne" region="Poitou-Charentes">(86)
								Vienne</option>
							<option value="(87) Haute-Vienne" region="Limousin">(87)
								Haute-Vienne</option>
							<option value="(88) Vosges" region="Lorraine">(88)
								Vosges</option>
							<option value="(89) Yonne" region="Bourgogne">(89) Yonne</option>
							<option value="(90) Territoire de Belfort" region="Franche-Comté">(90)
								Territoire de Belfort</option>
							<option value="(91) Essonne" region="Ile-de-France">(91)
								Essonne</option>
							<option value="(92) Hauts-de-Seine" region="Ile-de-France">(92)
								Hauts-de-Seine</option>
							<option value="(93) Seine-Saint-Denis" region="Ile-de-France">(93)
								Seine-Saint-Denis</option>
							<option value="(94) Val-de-Marne" region="Ile-de-France">(94)
								Val-de-Marne</option>
							<option value="(95) Val-d'Oise" region="Ile-de-France">(95)
								Val-d'Oise</option>
							<option value="(971) Guadeloupe"
								region="Départements d'Outre-Mer">(971) Guadeloupe</option>
							<option value="(972) Martinique"
								region="Départements d'Outre-Mer">(972) Martinique</option>
							<option value="(973) Guyane" region="Départements d'Outre-Mer">(973)
								Guyane</option>
							<option value="(974) La Réunion"
								region="Départements d'Outre-Mer">(974) La Réunion</option>
							<option value="(975) Saint-Pierre-et-Miquelon"
								region="Départements d'Outre-Mer">(975)
								Saint-Pierre-et-Miquelon</option>
							<option value="(976) Mayotte" region="Départements d'Outre-Mer">(976)
								Mayotte</option>
							<option value="(984) Terres Australes et Antarctiques"
								region="Territoires d'Outre-Mer">(984) Terres Australes
								et Antarctiques</option>
							<option value="(986) Wallis et Futuna"
								region="Territoires d'Outre-Mer">(986) Wallis et Futuna</option>
							<option value="(987) Polynésie Française"
								region="Territoires d'Outre-Mer">(987) Polynésie
								Française</option>
							<option value="(988) Nouvelle-Calédonie"
								region="Territoires d'Outre-Mer">(988)
								Nouvelle-Calédonie</option>
							</option>
						</select>
					</div>
					<div class="input-block">
						<label for="country">Pays</label><br> <select name="country">
							<optgroup label="Afrique">
								<option value="afriqueDuSud">Afrique Du Sud</option>
								<option value="algerie">Algérie</option>
								<option value="angola">Angola</option>
								<option value="benin">Bénin</option>
								<option value="botswana">Botswana</option>
								<option value="burkina">Burkina</option>
								<option value="burundi">Burundi</option>
								<option value="cameroun">Cameroun</option>
								<option value="capVert">Cap-Vert</option>
								<option value="republiqueCentre-Africaine">République
									Centre-Africaine</option>
								<option value="comores">Comores</option>
								<option value="republiqueDemocratiqueDuCongo">République
									Démocratique Du Congo</option>
								<option value="congo">Congo</option>
								<option value="coteIvoire">Côte d'Ivoire</option>
								<option value="djibouti">Djibouti</option>
								<option value="egypte">Égypte</option>
								<option value="ethiopie">Éthiopie</option>
								<option value="erythrée">Érythrée</option>
								<option value="gabon">Gabon</option>
								<option value="gambie">Gambie</option>
								<option value="ghana">Ghana</option>
								<option value="guinee">Guinée</option>
								<option value="guinee-Bisseau">Guinée-Bisseau</option>
								<option value="guineeEquatoriale">Guinée Équatoriale</option>
								<option value="kenya">Kenya</option>
								<option value="lesotho">Lesotho</option>
								<option value="liberia">Liberia</option>
								<option value="libye">Libye</option>
								<option value="madagascar">Madagascar</option>
								<option value="malawi">Malawi</option>
								<option value="mali">Mali</option>
								<option value="maroc">Maroc</option>
								<option value="maurice">Maurice</option>
								<option value="mauritanie">Mauritanie</option>
								<option value="mozambique">Mozambique</option>
								<option value="namibie">Namibie</option>
								<option value="niger">Niger</option>
								<option value="nigeria">Nigeria</option>
								<option value="ouganda">Ouganda</option>
								<option value="rwanda">Rwanda</option>
								<option value="saoTomeEtPrincipe">Sao Tomé-et-Principe</option>
								<option value="senegal">Séngal</option>
								<option value="seychelles">Seychelles</option>
								<option value="sierra">Sierra</option>
								<option value="somalie">Somalie</option>
								<option value="soudan">Soudan</option>
								<option value="swaziland">Swaziland</option>
								<option value="tanzanie">Tanzanie</option>
								<option value="tchad">Tchad</option>
								<option value="togo">Togo</option>
								<option value="tunisie">Tunisie</option>
								<option value="zambie">Zambie</option>
								<option value="zimbabwe">Zimbabwe</option>
							</optgroup>
							<optgroup label="Amérique">
								<option value="antiguaEtBarbuda">Antigua-et-Barbuda</option>
								<option value="argentine">Argentine</option>
								<option value="bahamas">Bahamas</option>
								<option value="barbade">Barbade</option>
								<option value="belize">Belize</option>
								<option value="bolivie">Bolivie</option>
								<option value="bresil">Brésil</option>
								<option value="canada">Canada</option>
								<option value="chili">Chili</option>
								<option value="colombie">Colombie</option>
								<option value="costaRica">Costa Rica</option>
								<option value="cuba">Cuba</option>
								<option value="republiqueDominicaine">République
									Dominicaine</option>
								<option value="dominique">Dominique</option>
								<option value="equateur">Équateur</option>
								<option value="etatsUnis">États Unis</option>
								<option value="grenade">Grenade</option>
								<option value="guatemala">Guatemala</option>
								<option value="guyana">Guyana</option>
								<option value="haiti">Haïti</option>
								<option value="honduras">Honduras</option>
								<option value="jamaique">Jamaïque</option>
								<option value="mexique">Mexique</option>
								<option value="nicaragua">Nicaragua</option>
								<option value="panama">Panama</option>
								<option value="paraguay">Paraguay</option>
								<option value="perou">Pérou</option>
								<option value="saintCristopheEtNieves">Saint-Cristophe-et-Niévès</option>
								<option value="sainteLucie">Sainte-Lucie</option>
								<option value="saintVincentEtLesGrenadines">Saint-Vincent-et-les-Grenadines</option>
								<option value="salvador">Salvador</option>
								<option value="suriname">Suriname</option>
								<option value="triniteEtTobago">Trinité-et-Tobago</option>
								<option value="uruguay">Uruguay</option>
								<option value="venezuela">Venezuela</option>
							</optgroup>
							<optgroup label="Asie">
								<option value="afghanistan">Afghanistan</option>
								<option value="arabieSaoudite">Arabie Saoudite</option>
								<option value="armenie">Arménie</option>
								<option value="azerbaidjan">Azerbaïdjan</option>
								<option value="bahrein">Bahreïn</option>
								<option value="bangladesh">Bangladesh</option>
								<option value="bhoutan">Bhoutan</option>
								<option value="birmanie">Birmanie</option>
								<option value="brunei">Brunéi</option>
								<option value="cambodge">Cambodge</option>
								<option value="chine">Chine</option>
								<option value="coreeDuSud">Corée Du Sud</option>
								<option value="coreeDuNord">Corée Du Nord</option>
								<option value="emiratsArabeUnis">Émirats Arabe Unis</option>
								<option value="georgie">Géorgie</option>
								<option value="inde">Inde</option>
								<option value="indonesie">Indonésie</option>
								<option value="iraq">Iraq</option>
								<option value="iran">Iran</option>
								<option value="israel">Israël</option>
								<option value="japon">Japon</option>
								<option value="jordanie">Jordanie</option>
								<option value="kazakhstan">Kazakhstan</option>
								<option value="kirghistan">Kirghistan</option>
								<option value="koweit">Koweït</option>
								<option value="laos">Laos</option>
								<option value="liban">Liban</option>
								<option value="malaisie">Malaisie</option>
								<option value="maldives">Maldives</option>
								<option value="mongolie">Mongolie</option>
								<option value="nepal">Népal</option>
								<option value="oman">Oman</option>
								<option value="ouzbekistan">Ouzbékistan</option>
								<option value="pakistan">Pakistan</option>
								<option value="philippines">Philippines</option>
								<option value="qatar">Qatar</option>
								<option value="singapour">Singapour</option>
								<option value="sriLanka">Sri Lanka</option>
								<option value="syrie">Syrie</option>
								<option value="tadjikistan">Tadjikistan</option>
								<option value="taiwan">Taïwan</option>
								<option value="thailande">Thaïlande</option>
								<option value="timorOriental">Timor oriental</option>
								<option value="turkmenistan">Turkménistan</option>
								<option value="turquie">Turquie</option>
								<option value="vietNam">Viêt Nam</option>
								<option value="yemen">Yemen</option>
							</optgroup>
							<optgroup label="Europe">
								<option value="allemagne">Allemagne</option>
								<option value="albanie">Albanie</option>
								<option value="andorre">Andorre</option>
								<option value="autriche">Autriche</option>
								<option value="bielorussie">Biélorussie</option>
								<option value="belgique">Belgique</option>
								<option value="bosnieHerzegovine">Bosnie-Herzégovine</option>
								<option value="bulgarie">Bulgarie</option>
								<option value="croatie">Croatie</option>
								<option value="danemark">Danemark</option>
								<option value="espagne">Espagne</option>
								<option value="estonie">Estonie</option>
								<option value="finlande">Finlande</option>
								<option value="france" selected>France</option>
								<option value="grece">Grèce</option>
								<option value="hongrie">Hongrie</option>
								<option value="irlande">Irlande</option>
								<option value="islande">Islande</option>
								<option value="italie">Italie</option>
								<option value="lettonie">Lettonie</option>
								<option value="liechtenstein">Liechtenstein</option>
								<option value="lituanie">Lituanie</option>
								<option value="luxembourg">Luxembourg</option>
								<option value="exRepubliqueYougoslaveDeMacedoine">Ex-République
									Yougoslave de Macédoine</option>
								<option value="malte">Malte</option>
								<option value="moldavie">Moldavie</option>
								<option value="monaco">Monaco</option>
								<option value="norvege">Norvège</option>
								<option value="paysBas">Pays-Bas</option>
								<option value="pologne">Pologne</option>
								<option value="portugal">Portugal</option>
								<option value="roumanie">Roumanie</option>
								<option value="royaumeUni">Royaume-Uni</option>
								<option value="russie">Russie</option>
								<option value="saintMarin">Saint-Marin</option>
								<option value="serbieEtMontenegro">Serbie-et-Monténégro</option>
								<option value="slovaquie">Slovaquie</option>
								<option value="slovenie">Slovénie</option>
								<option value="suede">Suède</option>
								<option value="suisse">Suisse</option>
								<option value="republiqueTcheque">République Tchèque</option>
								<option value="ukraine">Ukraine</option>
								<option value="vatican">Vatican</option>
							</optgroup>
							<optgroup label="Océanie">
								<option value="australie">Australie</option>
								<option value="fidji">Fidji</option>
								<option value="kiribati">Kiribati</option>
								<option value="marshall">Marshall</option>
								<option value="micronesie">Micronésie</option>
								<option value="nauru">Nauru</option>
								<option value="nouvelleZelande">Nouvelle-Zélande</option>
								<option value="palaos">Palaos</option>
								<option value="papouasieNouvelleGuinee">Papouasie-Nouvelle-Guinée</option>
								<option value="salomon">Salomon</option>
								<option value="samoa">Samoa</option>
								<option value="tonga">Tonga</option>
								<option value="tuvalu">Tuvalu</option>
								<option value="vanuatu">Vanuatu</option>
							</optgroup>
						</select>
					</div>
					<div class="input-block">
						<label for="phone">Numéro téléphone : </label><br> <input
							name="phone" type="tel" placeholder="0000000000" maxlength="10"
							value="0306512344">
						<p class="error"></p>
					</div>
					<div class="input-block">
						<button class="left" type="reset">Annuler</button>
						<button class="right" type="submit" onclick="return valideForm()">Envoyer</button>
					</div>
				</form>
			</fieldset>
		</section>
		<%@include file="../../commons/view/footer.jsp"%>
	</div>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/login.js"></script>
</body>
</html>